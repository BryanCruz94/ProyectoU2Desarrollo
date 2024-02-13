package com.espe.dao;

import com.espe.model.JPAUtil;
import com.espe.model.User;
import com.espe.idao.IUserDao;
import com.espe.model.pending_tasks.view_pedding_task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements  IUserDao{
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();



    @Override
    public void guardar(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void editar(User user) {
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public User buscarUsuario(int id) {
        User oUsuario = new User();
        oUsuario = entityManager.find(User.class, id);
        return oUsuario;
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
        User oUsuario = new User();
        oUsuario = entityManager.find(User.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(oUsuario);
        entityManager.getTransaction().commit();
    }

    @Override
    public User buscarPorEmail(String email) {
        try {
            Query query = entityManager.createNativeQuery(
                    "SELECT * FROM users WHERE email = :email", User.class);
            query.setParameter("email", email);
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
