package pe.edu.upc.fitfat.dtos;

public class ContarUsuariosActivosInactivosDTO {

    private String estadoUsuario;  // "Activo" o "Inactivo"
    private Long cantidad;         // Cantidad de usuarios en ese estado

    public ContarUsuariosActivosInactivosDTO(String estadoUsuario, Long cantidad) {
        this.estadoUsuario = estadoUsuario;
        this.cantidad = cantidad;
    }

    // Getters y setters
    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
}
