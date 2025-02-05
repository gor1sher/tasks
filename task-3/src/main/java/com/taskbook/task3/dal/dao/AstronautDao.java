package com.taskbook.task3.dal.dao;

import com.taskbook.task3.dal.entities.Astronaut;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AstronautDao {

    private final SessionFactory sessionFactory;

    public List<Astronaut> findAll(){
        return ;
    }

    public Astronaut findById(){
        return ;
    }

    public void insertData(Astronaut astronaut){

    }

    public void updateData(Astronaut astronaut){

    }
}
