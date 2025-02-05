package com.taskbook.task3.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfig {

    @Bean
    public SessionFactory buildSessionFactory(){
        return new org.hibernate.cfg.Configuration()
                .configure()
                .buildSessionFactory();
    }
}
