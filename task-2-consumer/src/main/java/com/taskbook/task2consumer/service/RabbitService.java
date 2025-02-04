package com.taskbook.task2consumer.service;

import com.taskbook.task2consumer.model.ResponseData;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Setter
@RequiredArgsConstructor
public class RabbitService {

    @Value("${queue.name}")
    private String queue;

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(ResponseData responseData){
        log.info("отправлено сообщение: {}", responseData.getLocalTimeMessage() + " количество людей на борту: " +
                responseData.getPeopleCount());

        String response = responseData.getPeopleCount() +" - " + responseData.getLocalTimeMessage() + " - " +
                responseData.getAstronauts();

        rabbitTemplate.convertAndSend(queue, response);
    }
}
