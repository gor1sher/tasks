package com.taskbook.task3.controller;

import com.taskbook.task3.dal.entities.Astronaut;
import com.taskbook.task3.service.AstronautService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/astronauts")
public class AstronautController {

    private final AstronautService astronautService;

    @GetMapping
    public ResponseEntity<List<Astronaut>> getAstronauts(){
        log.info("получение списка астронавтов");

        return ResponseEntity.ok(astronautService.getAstronauts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Astronaut> getAstronautById(@PathVariable(name = "id") Long id){
        log.info("получение астронавта по идентификатору id: {}", id);

        return astronautService.astronautById();
    }

    @PostMapping
    public void addAstronaut(@RequestBody Astronaut astronaut){
        log.info("добавление нового астронавта");

        astronautService.addAstronaut(astronaut);
    }

    @PutMapping
    public void updateAstronautData(@RequestBody Astronaut astronaut){
        log.info("обновление данных астронавта id: {}", astronaut.getId());

        astronautService.updateData(astronaut);
    }

    @DeleteMapping("/{id}")
    public void deleteAstronautData(@PathVariable(name = "id") Long id){
        log.info("удаление данных астронавта id: {}", id);

        astronautService.deleteData(id);
    }
}
