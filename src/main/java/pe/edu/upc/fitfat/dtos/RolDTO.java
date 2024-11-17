package pe.edu.upc.fitfat.dtos;

import pe.edu.upc.fitfat.entities.Usuarios;

public class RolDTO {
    private Integer idRol;
    private String descripcion;
    private Usuarios usuario;

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
