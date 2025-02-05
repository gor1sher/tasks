package com.taskbook.task3;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Task3Application {

    public static void main(String[] args){
        SpringApplication.run(Task3Application.class, args);
    }

    @PostConstruct
    public void startSession(){
        Configuration configuration = new Configuration();
        configuration.configure();
        try (var sessionFactory = configuration.buildSessionFactory();
             var session = sessionFactory.openSession()) {

            log.info("ok");
        }
    }
}
