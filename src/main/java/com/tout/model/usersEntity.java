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
    private String aPaterno;
    private String aMaterno;
    private String contrasena;
//hola pero este no es el peiro#2?
    //esta bien ...jajajaja = kakaka en kataka jajajajaj ya me voy entonces? pues siii bai.
    public usersEntity() {
    }

    public usersEntity(int id, String nombre, String aPaterno, String aMaterno, String contrasena ) {
        super();
        this.id=id;
        this.nombre=nombre;
        this.aMaterno=aMaterno;
        this.aPaterno=aPaterno;
        this.contrasena=contrasena;
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
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contraseña) {
        this.contrasena = contrasena;
    }
}
