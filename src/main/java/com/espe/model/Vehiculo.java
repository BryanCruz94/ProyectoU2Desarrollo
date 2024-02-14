package com.espe.model;

import jakarta.persistence.*;

@Entity
@Table(name="Vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String plate;

    @Column
    private String description;

    @Column
    private Boolean in_university;

    @Column
    private String img_url;

    public Vehiculo() {
    }

    public Vehiculo(Integer id, String plate, String description, Boolean in_university, String img_url) {
        this.id = id;
        this.plate = plate;
        this.description = description;
        this.in_university = in_university;
        this.img_url = img_url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIn_university() {
        return in_university;
    }

    public void setIn_university(Boolean in_university) {
        this.in_university = in_university;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
