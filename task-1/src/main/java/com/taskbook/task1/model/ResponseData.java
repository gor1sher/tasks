package com.taskbook.task1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseData {
    private String client;
    private Long executionTime;
    private String response;
}
