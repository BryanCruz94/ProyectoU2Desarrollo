package com.espe.model.pending_tasks;

public class view_task_done {
    private String pending_task;
    private String hour_create;
    private String hour_done;
    private String guardCreate;
    private String guardDone;
    private String observations;

    public view_task_done() {
    }

    public view_task_done(String pending_task, String hour_create, String hour_done, String guardCreate, String guardDone, String observations) {
        this.pending_task = pending_task;
        this.hour_create = hour_create;
        this.hour_done = hour_done;
        this.guardCreate = guardCreate;
        this.guardDone = guardDone;
        this.observations = observations;
    }

    public String getPending_task() {
        return pending_task;
    }

    public void setPending_task(String pending_task) {
        this.pending_task = pending_task;
    }

    public String getHour_create() {
        return hour_create;
    }

    public void setHour_create(String hour_create) {
        this.hour_create = hour_create;
    }

    public String getHour_done() {
        return hour_done;
    }

    public void setHour_done(String hour_done) {
        this.hour_done = hour_done;
    }

    public String getGuardCreate() {
        return guardCreate;
    }

    public void setGuardCreate(String guardCreate) {
        this.guardCreate = guardCreate;
    }

    public String getGuardDone() {
        return guardDone;
    }

    public void setGuardDone(String guardDone) {
        this.guardDone = guardDone;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}
