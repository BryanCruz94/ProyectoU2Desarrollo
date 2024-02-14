package com.espe.model;

import jakarta.persistence.*;

@Entity
@Table(name="Driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String identificationCard;

    @Column
    private String names;

    @Column(name="last_names")
    private String lastNames;

    @Column
    private String phone;

    @Column(name="blood_type")
    private String bloodType;

    @Column(name="license_type")
    private String licenseType;

    public Driver() {
    }

    public Driver(Integer id, String identificationCard, String names, String lastNames, String phone, String bloodType, String licenseType) {
        this.id = id;
        this.identificationCard = identificationCard;
        this.names = names;
        this.lastNames = lastNames;
        this.phone = phone;
        this.bloodType = bloodType;
        this.licenseType = licenseType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public void setIdentificationCard(String identificationCard) {
        this.identificationCard = identificationCard;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    @Override
    public String toString() {
        return "driver{" +
                "id=" + id +
                ", identificationCard='" + identificationCard + '\'' +
                ", names='" + names + '\'' +
                ", lastNames='" + lastNames + '\'' +
                ", phone='" + phone + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", licenseType='" + licenseType + '\'' +
                '}';
    }
}
