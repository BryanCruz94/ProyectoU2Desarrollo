package com.espe.model.novelties;

import com.espe.model.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="Novelties")
public class Novelties {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String novelty;
    @Column
    private LocalDateTime hour;
    @ManyToOne
    private User guard;

    public Novelties() {
    }

    public Novelties(int id, String novelty, LocalDateTime hour) {
        this.id = id;
        this.novelty = novelty;
        this.hour = hour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNovelty() {
        return novelty;
    }

    public void setNovelty(String novelty) {
        this.novelty = novelty;
    }

    public LocalDateTime getHour() {
        return hour;
    }

    public void setHour(LocalDateTime hour) {
        this.hour = hour;
    }

    public User getGuard_id() {
        return guard;
    }

    public void setGuard_id(User guard_id) {
        guard = guard_id;
    }
}
