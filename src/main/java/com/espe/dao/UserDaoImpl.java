package com.espe.dao;

import com.espe.model.JPAUtil;
import com.espe.model.User;
import com.espe.idao.IUserDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class UserDaoImpl implements  IUserDao{
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public void guardar(User user) {
        // TODO Auto-generated method stub
    }

    @Override
    public void editar(User user) {
        // TODO Auto-generated method stub
    }

    @Override
    public User buscarUsuario(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> obtenerUsuarios() {
        List<User> listaUsuarios;
        Query query = entityManager.createQuery("SELECT u FROM User u");
        listaUsuarios = query.getResultList();
        return listaUsuarios;
    }

    @Override
    public void eliminar(int id) {
        // TODO Auto-generated method stub
    }
}
