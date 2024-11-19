package pe.edu.upc.fitfat.dtos;

import pe.edu.upc.fitfat.entities.Usuarios;

public class RolDTO {
    private long idRol;
    private String descripcion;
    private Usuarios usuario;

    public long getIdRol() {
        return idRol;
    }

    public void setIdRol(long idRol) {
        this.idRol = idRol;
    }

    public String getdescripcion() {
        return descripcion;
    }

    public void setdescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
