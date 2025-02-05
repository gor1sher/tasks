package com.taskbook.task3.service;

import com.taskbook.task3.dal.entities.Astronaut;
import com.taskbook.task3.manager.AstronautManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AstronautService {

    private final AstronautManager astronautManager;

    public List<Astronaut> getAstronauts() {
        astronautManager.getAstronauts();
    }

    public Astronaut astronautById() {
        return astronautManager.astronautById();
    }

    public void addAstronaut(Astronaut astronaut) {
        astronautManager.addAstronaut();
    }

    public void updateData(Astronaut astronaut) {
        astronautManager.updateData();
    }

    public void deleteData(Long id) {
        astronautManager.deleteData();
    }
}
