package com.espe.model;

import jakarta.persistence.*;


@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String names;

    @Column
    private String last_names;

    @Column
    private String email;
    @Column
    private String email_verified_at;
    @Column
    private String password;
    @Column
    private String remember_token;
    @Column
    private String identification_card;
    @Column
    private String phone;
    @Column
    private boolean is_admin;
    @Column
    private String blood_type;

    public User() {
    }

    public User(int id, String names, String last_names, String email, String email_verified_at, String password, String remember_token, String identification_card, String phone, boolean is_admin, String blood_type) {
        this.id = id;
        this.names = names;
        this.last_names = last_names;
        this.email = email;
        this.email_verified_at = email_verified_at;
        this.password = password;
        this.remember_token = remember_token;
        this.identification_card = identification_card;
        this.phone = phone;
        this.is_admin = is_admin;
        this.blood_type = blood_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLast_names() {
        return last_names;
    }

    public void setLast_names(String last_names) {
        this.last_names = last_names;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_verified_at() {
        return email_verified_at;
    }

    public void setEmail_verified_at(String email_verified_at) {
        this.email_verified_at = email_verified_at;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemember_token() {
        return remember_token;
    }

    public void setRemember_token(String remember_token) {
        this.remember_token = remember_token;
    }

    public String getIdentification_card() {
        return identification_card;
    }

    public void setIdentification_card(String identification_card) {
        this.identification_card = identification_card;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public String getBlood_type() {
        return blood_type;
    }

    public void setBlood_type(String blood_type) {
        this.blood_type = blood_type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", names='" + names + '\'' +
                ", last_names='" + last_names + '\'' +
                ", email='" + email + '\'' +
                ", email_verified_at='" + email_verified_at + '\'' +
                ", password='" + password + '\'' +
                ", remember_token='" + remember_token + '\'' +
                ", identification_card='" + identification_card + '\'' +
                ", phone='" + phone + '\'' +
                ", is_admin=" + is_admin +
                ", blood_type='" + blood_type + '\'' +
                '}';
    }
}