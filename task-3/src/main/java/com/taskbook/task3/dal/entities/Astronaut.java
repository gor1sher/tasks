package com.taskbook.task3.dal.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "astronauts")
public class Astronaut {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String craft;
    private LocalDate missionStartDate;
    private LocalDate missionEndDate;
}
