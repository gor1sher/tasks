package com.taskbook.task1.service;

import com.taskbook.task1.model.ResponseData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class TimeWatcherClientService implements ClientService {

    private ClientService delegate;

    @Override
    public ResponseData fetchData() {
        long startTime = System.currentTimeMillis();

        var response = delegate.fetchData();

        long endTime = System.currentTimeMillis();
        response.setExecutionTime(endTime - startTime);

        log.info("{}, ms", endTime - startTime);

        return response;
    }
}
