package com.espe.idao.pending_task;

import com.espe.model.pending_tasks.Pendind_task;
import com.espe.model.pending_tasks.view_pedding_task;
import com.espe.model.pending_tasks.view_task_done;

public interface IPendingDao {
    public void guardar(Pendind_task pendind_task);
    public void editar(Pendind_task pendind_task);
    public Pendind_task buscarConsigna(int id);
    public java.util.List<view_pedding_task> obtenerConsignasPendientes();
    public java.util.List<view_task_done> obtenerConsignas();

}
