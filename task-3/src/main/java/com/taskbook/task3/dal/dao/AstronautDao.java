package com.taskbook.task3.dal.dao;

import com.taskbook.task3.dal.entities.Astronaut;
import com.taskbook.task3.exception.AstronautNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class AstronautDao {


    private Configuration configuration;
    private SessionFactory sessionFactory;

    public AstronautDao() {
        configuration = new Configuration();
        configuration.configure();
        this.sessionFactory = configuration.buildSessionFactory();
    }

    public List<Astronaut> findAll() {
        try (var session = sessionFactory.openSession()) {
            return session.createQuery("FROM Astronaut", Astronaut.class).list();
        }
    }

    public Astronaut findById(Long id) {
        try (var session = sessionFactory.openSession()) {
            return session.get(Astronaut.class, id);
        }
    }

    public void insertData(Astronaut astronaut) {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            try {
                session.save(astronaut);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                throw new RuntimeException(ex.getMessage());
            }
        }
    }

    public void updateData(Astronaut astronaut) {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            try {
                session.update(astronaut);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                throw new RuntimeException(ex.getMessage());
            }
        }
    }

    public void deleteData(Long id) {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            try {
                var astronaut = session.get(Astronaut.class, id);
                if (astronaut == null){
                    throw new AstronautNotFoundException("такого объекта нет");
                }
                session.delete(astronaut);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                throw new RuntimeException(ex.getMessage());
            }
        }
    }
}
