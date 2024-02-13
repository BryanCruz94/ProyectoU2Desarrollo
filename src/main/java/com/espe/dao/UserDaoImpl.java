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
    public User login(User usuario) {
        User user = new User();
        String query = "SELECT u FROM User u WHERE u.email = :email AND u.password = :password";
        try {
            user = (User) entityManager.createQuery(query)
                    .setParameter("email", usuario.getEmail())
                    .setParameter("password", usuario.getPassword())
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
