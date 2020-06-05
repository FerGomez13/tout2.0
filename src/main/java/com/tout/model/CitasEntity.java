package com.tout.model;

import javax.persistence.Entity;
import org.springframework.data.annotation.Id;
import javax.persistence.Table;
import java.util.Arrays;

@Entity
@Table(name = "cita")
public class CitasEntity {

    @javax.persistence.Id
    @Id
    private String id;
    private String nombreSocio;
    private int hora;
    private int fecha;

    public CitasEntity() {

    }

    public CitasEntity(String id, String nombreSocio, int hora, int fecha){
        super();
        this.id = id;
        this.nombreSocio = nombreSocio;
        this.hora = hora;
        this.fecha = fecha;
    }

    public String getId() { return id; }

    public String getNombreSocio() { return nombreSocio; }

    public int getHora() { return hora; }

    public int getFecha() { return fecha; }

    public void setId(String id) { this.id = id; }

    public void setNombreSocio(String nombreSocio) { this.nombreSocio = nombreSocio; }

    public void setHora(int hora) { this.hora = hora; }

    public void setFecha(int fecha) { this.fecha = fecha; }

    @Override
    public String toString() {
        return "CitasEntity{" +
                "id=" + id +
                ", nombreSocio=" + nombreSocio +
                ", hora=" + hora +
                ", fecha=" + fecha +
                '}';
    }
}
