package com.espe.dao;

import com.espe.idao.IDriverDao;
import com.espe.idao.IUserDao;
import com.espe.model.Driver;
import com.espe.model.JPAUtil;
import com.espe.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import java.util.List;

public class DriverDaoImpl implements IDriverDao {
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();



    @Override
    public void guardar(Driver driver) {
        entityManager.getTransaction().begin();
        entityManager.persist(driver);
        entityManager.getTransaction().commit();
    }

    @Override
    public void editar(Driver driver) {
        entityManager.getTransaction().begin();
        entityManager.merge(driver);
        entityManager.getTransaction().commit();
    }

    @Override
    public Driver buscarDriver(int id) {
        Driver oDriver = new Driver();
        oDriver = entityManager.find(Driver.class, id);
        return oDriver;
    }

    @Override
    public List<Driver> obtenerDriver() {
        List<Driver> listaDriver;
        Query query = entityManager.createQuery("SELECT u FROM Driver u");
        listaDriver = query.getResultList();
        return listaDriver;
    }

    @Override
    public void eliminar(int id) {
        Driver oDriver = new Driver();
        oDriver = entityManager.find(Driver.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(oDriver);
        entityManager.getTransaction().commit();
    }

}
