package pe.edu.upc.fitfat.dtos;

public class DietasPorUsuarioDTO {
    public int idUsuario;
    public int cantidad_dietas;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getCantidad_dietas() {
        return cantidad_dietas;
    }

    public void setCantidad_dietas(int cantidad_dietas) {
        this.cantidad_dietas = cantidad_dietas;
    }
}