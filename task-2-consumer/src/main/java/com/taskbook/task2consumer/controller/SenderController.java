package com.taskbook.task2consumer.controller;

import com.taskbook.task2consumer.service.NotifierService;
import com.taskbook.task2consumer.service.RabbitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/get-data")
@RequiredArgsConstructor
public class SenderController {

    private final NotifierService notifierService;
    private final RabbitService rabbitService;

    @GetMapping
    public Object fetchDataAndReturn() {
        var response = notifierService.fetchData();
        rabbitService.sendMessage(response);
        return response;
    }
}
