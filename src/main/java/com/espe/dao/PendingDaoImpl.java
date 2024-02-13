package com.espe.dao;

import com.espe.model.JPAUtil;
import com.espe.model.pending_tasks.Pendind_task;
import com.espe.model.pending_tasks.view_pedding_task;
import com.espe.idao.IPendingDao;
import com.espe.model.pending_tasks.view_task_done;
import jakarta.persistence.EntityManager;
import java.sql.Timestamp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import java.util.ArrayList;
import java.util.List;

public class PendingDaoImpl implements IPendingDao{
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @Override
    public void guardar(Pendind_task pendind_task) {
        entityManager.getTransaction().begin();
        entityManager.persist(pendind_task);
        entityManager.getTransaction().commit();
    }

    @Override
    public void editar(Pendind_task pendind_task) {

        entityManager.getTransaction().begin();
        entityManager.merge(pendind_task);
        entityManager.getTransaction().commit();
    }

    @Override
    public Pendind_task buscarConsigna(int id) {
        Pendind_task oConsigna = new Pendind_task();
        oConsigna = entityManager.find(Pendind_task.class, id);
        return oConsigna;
    }

    @Override
    public List<view_pedding_task> obtenerConsignasPendientes() {

        List<Object[]> results = entityManager.createNativeQuery("SELECT id, hour_create, pending_task, guardCreate FROM view_pedding_task").getResultList();
        List<view_pedding_task> resultList = new ArrayList<>();
        for (Object[] result : results) {
            int id = (int) result[0];

            // Convertir el java.sql.Timestamp a java.time.LocalDateTime
            Timestamp timestamp = (Timestamp) result[1];
            LocalDateTime hour_create = timestamp.toLocalDateTime();

            String pending_task = (String) result[2];
            String guardCreate = (String) result[3];


            String hourString = hour_create.format(formatter);

            view_pedding_task dto = new view_pedding_task(id, hourString, pending_task, guardCreate);
            resultList.add(dto);
        }

        return resultList;
    }

    @Override
    public List<view_task_done> obtenerConsignas() {
        List <Object[]> results = entityManager.createNativeQuery(
                "SELECT pending_task, hour_create, hour_done, guardCreate, guardDone, observations FROM view_task_done").getResultList();
        List<view_task_done> resultList = new ArrayList<>();

        for (Object[] result : results) {
            String pending_task = (String) result[0];
            Timestamp timestamp = (Timestamp) result[1];
            LocalDateTime hour_create = timestamp.toLocalDateTime();
            Timestamp timestamp2 = (Timestamp) result[2];
            LocalDateTime hour_done = timestamp2.toLocalDateTime();
            String guardCreate = (String) result[3];
            String guardDone = (String) result[4];
            String observations = (String) result[5];


            String hourString = hour_create.format(formatter);
            String hourString2 = hour_done.format(formatter);

            view_task_done dto = new view_task_done(pending_task, hourString, hourString2, guardCreate, guardDone, observations);
            resultList.add(dto);
        }

        return resultList;
    }
}
