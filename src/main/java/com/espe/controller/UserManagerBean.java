package com.espe.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import com.espe.dao.UserDaoImpl;
import com.espe.idao.IUserDao;
import com.espe.model.User;

import java.util.List;
import java.util.Map;

@RequestScoped
@Named(value = "usuarioBean")
public class UserManagerBean {
    private String email;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    IUserDao usuarioDao = new UserDaoImpl();

    //PARA LISTAR TODOS LOS USUARIOS
    public List<User> obtenerUsuarios(){
        System.out.println("obteniendo");
        return usuarioDao.obtenerUsuarios();
    }


    //PARA ABRIR PÁGINA PARA CREAR UN USUARIO
    public String nuevo(){
        User oUsuario = new User();
        //CREAR UNA COLECCIÓN DE TIPO MAP
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("usuario", oUsuario);
        return "/agregaradminuser.xhtml";
    }

    //PARA GUARDAR UN USUARIO
    public String guardar(User usuario){
        usuarioDao.guardar(usuario);
        return "/adminUsers.xhtml";
    }


    // PARA ABRIR UNA PÁGINA PARA EDITAR UN USUARIO
    public String editar(int id){
        User oUsuario = new User();
        oUsuario = usuarioDao.buscarUsuario(id);
        //CREAR UNA COLECCIÓN DE TIPO MAP
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

        //Se pasan los parámetros del usuario
        sessionMap.put("usuario", oUsuario);

        return "/editadminuser.xhtml";
    }


    //PARA REALIZAR EL UPDATE AL USARIO
    public String actualizar(User usuario){
        usuarioDao.editar(usuario);
        return "/adminUsers.xhtml";
    }

    //PARA ELIMINAR UN USUARIO
    public String eliminar(int id){
        usuarioDao.eliminar(id);
        System.out.println("Usuario eliminado");
        return "/adminUsers.xhtml";
    }


    /************************************************************/
    /*          PARA EL LOGIN DE USUARIOS                       */
    /************************************************************/

    public void seleccionarUsuario(int id){
        User oUsuario = new User();
        oUsuario = usuarioDao.buscarUsuario(id);
        //CREAR UNA COLECCIÓN DE TIPO MAP
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

        //Se pasan los parámetros del usuario
        sessionMap.put("usuarioLog", oUsuario);

    }

    public void seleccionarUsuario2(User user){
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("usuarioLog", user);

    }






}
