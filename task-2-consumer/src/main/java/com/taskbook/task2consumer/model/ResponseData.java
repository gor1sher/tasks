package com.taskbook.task2consumer.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ResponseData {
    private LocalDateTime localTimeMessage;
    private String peopleCount;
    private List<Astronauts> astronauts;
}
