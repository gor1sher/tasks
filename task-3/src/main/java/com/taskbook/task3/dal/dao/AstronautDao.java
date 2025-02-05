package com.taskbook.task3.dal.dao;

import com.taskbook.task3.dal.entities.Astronaut;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        return null;
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

    }

    public void deleteData(Long id) {

    }
}
