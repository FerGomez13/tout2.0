package com.tout.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.swing.*;

@Entity
@Table(name = "users")
public class usersEntity {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String a_Paterno;
    private String a_Materno;
    private String contrasena;

    public usersEntity() {
    }

    public usersEntity(int id, String nombre, String a_Paterno, String a_Materno, String contrasena) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.a_Materno = a_Materno;
        this.a_Paterno = a_Paterno;
        this.contrasena = contrasena;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaPaterno() {
        return a_Paterno;
    }

    public void setaPaterno(String aPaterno) {
        this.a_Paterno = aPaterno;
    }

    public String getaMaterno() {
        return a_Materno;
    }

    public void setaMaterno(String aMaterno) {
        this.a_Materno = aMaterno;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
