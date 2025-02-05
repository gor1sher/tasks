package com.taskbook.task3.manager;

import com.taskbook.task3.dal.dao.AstronautDao;
import com.taskbook.task3.dal.entities.Astronaut;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class AstronautManager {

    private final AstronautDao astronautDao;

    public List<Astronaut> getAstronauts() {
        astronautDao.
    }

    public Astronaut astronautById() {

    }

    public void addAstronaut() {

    }

    public void updateData() {

    }

    public void deleteData() {

    }
}
