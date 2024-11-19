package pe.edu.upc.fitfat.dtos;

import pe.edu.upc.fitfat.entities.Usuarios;

public class DietaDTO {
    private int idDieta;
    private String nombre;
    private int duracion;
    private Usuarios usuario;

    // Getters and Setters

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
