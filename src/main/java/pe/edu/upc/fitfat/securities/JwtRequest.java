package pe.edu.upc.fitfat.securities;

import java.io.Serializable;

public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String usuario; // Corresponde al campo 'usuario' en la entidad Usuarios
    private String contrasena; // Corresponde al campo 'contrasena' en la entidad Usuarios

    public JwtRequest() {
        super();
    }

    public JwtRequest(String usuario, String contrasena) {
        super();
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
