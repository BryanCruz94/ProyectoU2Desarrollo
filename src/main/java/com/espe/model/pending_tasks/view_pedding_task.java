package com.espe.model.pending_tasks;

import java.time.LocalDateTime;


public class view_pedding_task {
    private int id;
    private String hour_create;
    private String pending_task;
    private String guardCreate;

    public view_pedding_task() {
    }

    public view_pedding_task(int id, String hour_create, String pending_task, String guardCreate) {
        this.id = id;
        this.hour_create = hour_create;
        this.pending_task = pending_task;
        this.guardCreate = guardCreate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHour_create() {
        return hour_create;
    }

    public void setHour_create(String hour_create) {
        this.hour_create = hour_create;
    }

    public String getPending_task() {
        return pending_task;
    }

    public void setPending_task(String pending_task) {
        this.pending_task = pending_task;
    }

    public String getGuardCreate() {
        return guardCreate;
    }

    public void setGuardCreate(String guardCreate) {
        this.guardCreate = guardCreate;
    }
}
