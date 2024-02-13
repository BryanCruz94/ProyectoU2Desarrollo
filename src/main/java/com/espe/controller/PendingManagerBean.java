package com.espe.controller;

import com.espe.model.User;
import com.espe.model.pending_tasks.view_task_done;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import com.espe.dao.PendingDaoImpl;
import com.espe.model.pending_tasks.Pendind_task;
import com.espe.model.pending_tasks.view_pedding_task;
import com.espe.idao.INoveltyDao;
import com.espe.dao.NoveltiesDaoImpl;
import com.espe.model.novelties.Novelties;
import com.espe.idao.IPendingDao;

import java.util.List;
import java.util.Map;

@RequestScoped
@Named(value = "pendingBean")
public class PendingManagerBean {
    IPendingDao pendingDao = new PendingDaoImpl();
    private Pendind_task pendind_task = new Pendind_task();

    public String nuevaConsigna() {
        Pendind_task pendind_task = new Pendind_task();

        //CREAR UNA COLECCIÓN DE TIPO MAP
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("consigna", pendind_task);

        return "/agregarpendings.xhtml";
    }

    public String guardar(Pendind_task pendind_task) {
        pendind_task.setHour_create(java.time.LocalDateTime.now());
        pendind_task.setUserCreate((User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLog"));
        pendingDao.guardar(pendind_task);

        return "/pendings.xhtml";
    }

    public String buscarConsigna(int id) {
        Pendind_task oConsigna = new Pendind_task();
        oConsigna = pendingDao.buscarConsigna(id);

        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

        //Se pasan los parámetros del usuario
        sessionMap.put("consigna", oConsigna);

        return "/editpending.xhtml";
    }

    public String actualizar(Pendind_task pendind_task) {
        pendind_task.setTask_done(true);
        pendind_task.setHour_done(java.time.LocalDateTime.now());
        pendind_task.setUserDone((User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLog"));

        pendingDao.editar(pendind_task);


        //SE CREA UNA NUEVA NOVEDAD
        Novelties novedad = new Novelties();
        INoveltyDao noveltyDao = new NoveltiesDaoImpl();

        novedad.setHour(java.time.LocalDateTime.now());
        novedad.setGuard_id((User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLog"));
        novedad.setNovelty("Se ha completado la consigna: " + pendind_task.getPending_task() + " con las siguientes observaciones: " + pendind_task.getObservations());

        noveltyDao.guardar(novedad);

        return "/pendings.xhtml";
    }

    public List<view_pedding_task> obtenerConsignasPendientes() {
        return pendingDao.obtenerConsignasPendientes();
    }

    public List<view_task_done> obtenerConsignas() {
        return pendingDao.obtenerConsignas();
    }


}
