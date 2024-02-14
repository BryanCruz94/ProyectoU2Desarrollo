package com.espe.controller;

import com.espe.dao.VehiculoDaoImpl;
import com.espe.idao.IVehiculoDao;
import com.espe.model.Vehiculo;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.List;
import java.util.Map;

@RequestScoped
@Named(value = "vehiculoBean")
public class VehiculoManagerBean {

    /************************************************************/
    /*          PARA VEHICULOS                      */
    /************************************************************/


    IVehiculoDao vehiculoDao = new VehiculoDaoImpl();

    private final VehiculoDaoImpl vehiculoDaoImpl = new VehiculoDaoImpl();


    //PARA LISTAR TODOS LOS VEHICULOS
    public List<Vehiculo> obtenerVehiculo(){
        System.out.println("obteniendo");
        return vehiculoDao.obtenerVehiculo();
    }


    //PARA ABRIR PÁGINA PARA CREAR UN VEHICULO
    public String nuevoVei(){
        Vehiculo oVehiculo = new Vehiculo();
        //CREAR UNA COLECCIÓN DE TIPO MAP
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("vehiculo", oVehiculo);
        return "/agregaradminvehicle.xhtml";
    }

    //PARA GUARDAR UN VEHICULO
    public String guardarVei(Vehiculo vehiculo) {
        vehiculoDao.guardar(vehiculo);
        return "/adminVehicles.xhtml";
    }


    // PARA ABRIR UNA PÁGINA PARA EDITAR UN VEHICULO
    public String editarVei(int id){
        Vehiculo oVehiculo = new Vehiculo();
        oVehiculo = vehiculoDao.buscarVehiculo(id);
        //CREAR UNA COLECCIÓN DE TIPO MAP
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

        //Se pasan los parámetros del usuario
        sessionMap.put("vehiculo", oVehiculo);

        return "/editadminvehicle.xhtml";
    }


    //PARA REALIZAR EL UPDATE AL USARIO
    public String actualizarVei(Vehiculo vehiculo){
        vehiculoDao.editar(vehiculo);
        return "/adminVehicles.xhtml";
    }

    //PARA ELIMINAR UN USUARIO
    public String eliminarVei(int id){
        vehiculoDao.eliminar(id);
        System.out.println("Usuario eliminado");
        return "/adminVehicles.xhtml";
    }
}
