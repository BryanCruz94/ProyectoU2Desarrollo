package com.espe.controller;

import com.espe.dao.DriverDaoImpl;
import com.espe.dao.UserDaoImpl;
import com.espe.idao.IDriverDao;
import com.espe.idao.IUserDao;
import com.espe.model.Driver;
import com.espe.model.User;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.List;
import java.util.Map;

@RequestScoped
@Named(value = "driverBean")
public class DriverManagerBean {

    IDriverDao driverDao = new DriverDaoImpl();

    private final DriverDaoImpl driverDaoImpl = new DriverDaoImpl();

    //PARA LISTAR TODOS LOS USUARIOS
    public List<Driver> obtenerDriver(){
        System.out.println("obteniendo");
        return driverDao.obtenerDriver();
    }


    //PARA ABRIR PÁGINA PARA CREAR UN USUARIO
    public String nuevoDri(){
        Driver oDriver = new Driver();
        //CREAR UNA COLECCIÓN DE TIPO MAP
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("driver", oDriver);
        return "/agregaradmindrivers.xhtml";
    }

    //PARA GUARDAR UN USUARIO
    public String guardarDri(Driver driver){
        driverDao.guardar(driver);
        return "/adminDrivers.xhtml";
    }


    // PARA ABRIR UNA PÁGINA PARA EDITAR UN USUARIO
    public String editarDri(int id){
        Driver oDriver = new Driver();
        oDriver = driverDao.buscarDriver(id);
        //CREAR UNA COLECCIÓN DE TIPO MAP
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

        //Se pasan los parámetros del usuario
        sessionMap.put("driver", oDriver);

        return "/editadmindrivers.xhtml";
    }


    //PARA REALIZAR EL UPDATE AL USARIO
    public String actualizarDri(Driver driver){
        driverDao.editar(driver);
        return "/adminDrivers.xhtml";
    }

    //PARA ELIMINAR UN USUARIO
    public String eliminarDri(int id){
        driverDao.eliminar(id);
        System.out.println("Usuario eliminado");
        return "/adminDrivers.xhtml";
    }


}
