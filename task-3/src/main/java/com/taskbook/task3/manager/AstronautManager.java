package com.taskbook.task3.manager;

import com.taskbook.task3.dal.dao.AstronautDao;
import com.taskbook.task3.dal.entities.Astronaut;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class AstronautManager {

    private final AstronautDao astronautDao;

    public List<Astronaut> getAstronauts() {
        return astronautDao.findAll();
    }

    public Astronaut astronautById(Long id) {
        return astronautDao.findById(id);
    }

    public List<Astronaut> getAstronautsByPagination(String name,
                                                     String craft,
                                                     LocalDate missionStartDate,
                                                     LocalDate missionEndDate,
                                                     int page,
                                                     int size) {

        return astronautDao.findDataByPagination(name, craft, missionStartDate, missionEndDate, page, size);
    }

    public void addAstronaut(Astronaut astronaut) {
        astronautDao.insertData(astronaut);
    }

    public void updateData(Astronaut astronaut) {
        astronautDao.updateData(astronaut);
    }

    public void deleteData(Long id) {
        astronautDao.deleteData(id);
    }
}
