package com.taskbook.task3.dal.dao;

import com.taskbook.task3.dal.entities.Astronaut;
import com.taskbook.task3.exception.AstronautNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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

    public List<Astronaut> findDataByPagination(String name,
                                                String craft,
                                                LocalDate missionStartDate,
                                                LocalDate missionEndDate,
                                                int page,
                                                int size) {

        try (var session = sessionFactory.openSession()){
            String hql = "FROM Astronaut a WHERE " +
                    "(:name IS NULL OR a.name LIKE :name) AND " +
                    "(:craft IS NULL OR a.craft LIKE :craft) AND " +
                    "(:missionStartDate IS NULL OR (a.missionStartDate >= :missionStartDate))";

            Query<Astronaut> query = session.createQuery(hql, Astronaut.class);
            query.setParameter("name", name != null ? "%" + name + "%" : null);
            query.setParameter("craft", craft !=null ? "%" + craft + "%" : null);
            query.setParameter("missionStartDate", missionStartDate);
            //query.setParameter("missionEndDate", missionEndDate);

            query.setFirstResult(page*size);
            query.setMaxResults(size);

            return query.getResultList();
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
