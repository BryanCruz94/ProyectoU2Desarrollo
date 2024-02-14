package com.espe.dao;

import com.espe.idao.IVehiculoDao;
import com.espe.model.JPAUtil;
import com.espe.model.Vehiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class VehiculoDaoImpl implements IVehiculoDao {
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();



    @Override
    public void guardar(Vehiculo vehiculo) {
        entityManager.getTransaction().begin();
        entityManager.persist(vehiculo);
        entityManager.getTransaction().commit();
    }

    @Override
    public void editar(Vehiculo vehiculo) {
        entityManager.getTransaction().begin();
        entityManager.merge(vehiculo);
        entityManager.getTransaction().commit();
    }

    @Override
    public Vehiculo buscarVehiculo(int id) {
        Vehiculo oVehiculo = new Vehiculo();
        oVehiculo = entityManager.find(Vehiculo.class, id);
        return oVehiculo;
    }

    @Override
    public List<Vehiculo> obtenerVehiculo() {
        List<Vehiculo> listaVehiculo;
        Query query = entityManager.createQuery("SELECT u FROM Vehiculo u");
        listaVehiculo = query.getResultList();
        return listaVehiculo;
    }

    @Override
    public void eliminar(int id) {
        Vehiculo oVehiculo = new Vehiculo();
        oVehiculo = entityManager.find(Vehiculo.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(oVehiculo);
        entityManager.getTransaction().commit();
    }

}
