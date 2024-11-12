package pe.edu.upc.fitfat.dtos;

public class SumaCaloriasPorUsuarioDTO {

    private String nombreUsuario;
    private double sumaCalorias;

    // Getters y Setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public double getSumaCalorias() {
        return sumaCalorias;
    }

    public void setSumaCalorias(double sumaCalorias) {
        this.sumaCalorias = sumaCalorias;
    }
}
