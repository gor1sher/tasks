package com.taskbook.task3.dal.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("mission_start_date")
    private LocalDate missionStartDate;

    @JsonProperty("mission_end_date")
    private LocalDate missionEndDate;
}
