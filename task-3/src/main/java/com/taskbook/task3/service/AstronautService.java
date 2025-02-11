package com.taskbook.task3.service;

import com.taskbook.task3.dal.entities.Astronaut;
import com.taskbook.task3.manager.AstronautManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AstronautService {

    private final AstronautManager astronautManager;

    public List<Astronaut> getAstronauts() {
        return astronautManager.getAstronauts();
    }

    public Astronaut getAstronautById(Long id) {
        return astronautManager.astronautById(id);
    }

    public List<Astronaut> getAstronautsByPagination(String name,
                                                     String craft,
                                                     LocalDate missionStartDate,
                                                     LocalDate missionEndDate,
                                                     int page,
                                                     int size) {

        return astronautManager.getAstronautsByPagination(name, craft, missionStartDate, missionEndDate, page, size);
    }

    public void addAstronaut(Astronaut astronaut) {
        astronautManager.addAstronaut(astronaut);
    }

    public void updateData(Astronaut astronaut) {
        astronautManager.updateData(astronaut);
    }

    public void deleteData(Long id) {
        astronautManager.deleteData(id);
    }
}
