package com.espe.model.pending_tasks;

import com.espe.model.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="Pending_Tasks")
public class Pendind_task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String pending_task;
    @Column
    private String observations;
    @Column
    private boolean task_done;
    @Column
    private LocalDateTime hour_create;
    @Column
    private LocalDateTime hour_done;
    @ManyToOne
    private User userCreate;
    @ManyToOne
    private User userDone;


    public Pendind_task() {
    }

    public Pendind_task(int id, String pendind_task, String observations, boolean task_done, LocalDateTime hour_create, LocalDateTime hour_done) {
        this.id = id;
        this.pending_task = pendind_task;
        this.observations = observations;
        this.task_done = task_done;
        this.hour_create = hour_create;
        this.hour_done = hour_done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPending_task() {
        return pending_task;
    }

    public void setPending_task(String pendind_task) {
        this.pending_task = pendind_task;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public boolean isTask_done() {
        return task_done;
    }

    public void setTask_done(boolean task_done) {
        this.task_done = task_done;
    }


    public LocalDateTime getHour_create() {
        return hour_create;
    }

    public void setHour_create(LocalDateTime hour_create) {
        this.hour_create = hour_create;
    }

    public LocalDateTime getHour_done() {
        return hour_done;
    }

    public void setHour_done(LocalDateTime hour_done) {
        this.hour_done = hour_done;
    }


    @Override
    public String toString() {
        return "Pendind_task{" +
                "id=" + id +
                ", pendind_task='" + pending_task + '\'' +
                ", observations='" + observations + '\'' +
                ", task_done=" + task_done +
                ", hour_create='" + hour_create + '\'' +
                ", hour_done='" + hour_done + '\'' +
                '}';
    }

    public User getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(User userCreate) {
        this.userCreate = userCreate;
    }


    public User getUserDone() {
        return userDone;
    }

    public void setUserDone(User userDone) {
        this.userDone = userDone;
    }
}
