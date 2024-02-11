package com.espe.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import com.espe.dao.UserDaoImpl;
import com.espe.idao.IUserDao;
import com.espe.model.User;

import java.util.List;

@RequestScoped
@Named(value = "usuarioBean")
public class UserManagerBean {
    IUserDao usuarioDao = new UserDaoImpl();

    public List<User> obtenerUsuarios(){
        System.out.println("obteniendo");
        return usuarioDao.obtenerUsuarios();
    }

}
