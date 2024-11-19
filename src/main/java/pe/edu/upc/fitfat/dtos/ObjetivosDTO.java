package pe.edu.upc.fitfat.dtos;

import pe.edu.upc.fitfat.entities.Usuarios;

import java.time.LocalDate;

public class ObjetivosDTO {

    private int idObjetivos;

    private String descripcion;

    private String tipo_objetivo;

    private LocalDate fecha_inicio;

    private LocalDate fecha_fin;

    private String estado;

    private Usuarios user;

    public int getIdObjetivos() {
        return idObjetivos;
    }

    public void setIdObjetivos(int idObjetivos) {
        this.idObjetivos = idObjetivos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo_objetivo() {
        return tipo_objetivo;
    }

    public void setTipo_objetivo(String tipo_objetivo) {
        this.tipo_objetivo = tipo_objetivo;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuarios getUser() {
        return user;
    }

    public void setUser(Usuarios user) {
        this.user = user;
    }
}
