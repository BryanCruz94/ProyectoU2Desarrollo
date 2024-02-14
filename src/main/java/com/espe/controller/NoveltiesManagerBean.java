package com.espe.controller;

import com.espe.model.User;
import com.espe.model.novelties.Novelties;
import com.espe.model.novelties.view_novelties;
import com.espe.model.pending_tasks.Pendind_task;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.List;
import java.util.Map;
import com.espe.dao.NoveltiesDaoImpl;
import com.espe.idao.INoveltyDao;

@RequestScoped
@Named(value = "noveltyBean")

public class NoveltiesManagerBean {

    INoveltyDao noveltyDao = new NoveltiesDaoImpl();


    public String nuevaNovedad() {
        Novelties novelty = new Novelties();

        //CREAR UNA COLECCIÓN DE TIPO MAP
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("novedad", novelty);

        if(isLogged()){
            // Si existe, redirigir a agregaradminuser.xhtml
            return "/agregarnovedad.xhtml";
        } else {
            // Si no existe, redirigir a login.xhtml
            return "/login.xhtml";
        }


    }



    public List<view_novelties> listarNovedades() {

        return noveltyDao.verNovedades();
    }

    public String guardar(Novelties novelty) {
        novelty.setHour(java.time.LocalDateTime.now());
        novelty.setGuard_id((User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLog"));

        noveltyDao.guardar(novelty);


        if(isLogged()){
            // Si existe, redirigir a agregaradminuser.xhtml
            return "/index2.xhtml";
        } else {
            // Si no existe, redirigir a login.xhtml
            return "/login.xhtml";
        }

    }

    public Boolean isLogged() {
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        return sessionMap.containsKey("usuarioLog");
    }

}
