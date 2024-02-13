package com.espe.dao;

import com.espe.model.JPAUtil;
import com.espe.model.novelties.Novelties;
import com.espe.model.novelties.view_novelties;
import com.espe.idao.INoveltyDao;
import com.espe.model.pending_tasks.view_pedding_task;
import jakarta.persistence.EntityManager;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class NoveltiesDaoImpl implements INoveltyDao {

    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @Override
    public void guardar(Novelties novelties) {
        entityManager.getTransaction().begin();
        entityManager.persist(novelties);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<view_novelties> verNovedades() {
        List<Object[]> results = entityManager.createNativeQuery("SELECT novelty, hour, guard FROM view_novelties").getResultList();
        List<view_novelties> resultList = new ArrayList<>();
        for (Object[] result : results) {
            String novelty = (String) result[0];

            // Convertir el java.sql.Timestamp a java.time.LocalDateTime
            Timestamp timestamp = (Timestamp) result[1];
            LocalDateTime hour_create = timestamp.toLocalDateTime();

            String guard = (String) result[2];


            String hourString = hour_create.format(formatter);

            view_novelties dto = new view_novelties(novelty, hourString, guard);
            resultList.add(dto);
        }

        return resultList;
    }

}
