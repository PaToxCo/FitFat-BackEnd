package pe.edu.upc.fitfat.dtos;

public class ComidaFavoritaPorTipoDTO {

    private String nombreTipoComida;
    private int cantidadComidasFavoritas;

    // Getters y Setters
    public String getNombreTipoComida() {
        return nombreTipoComida;
    }

    public void setNombreTipoComida(String nombreTipoComida) {
        this.nombreTipoComida = nombreTipoComida;
    }

    public int getCantidadComidasFavoritas() {
        return cantidadComidasFavoritas;
    }

    public void setCantidadComidasFavoritas(int cantidadComidasFavoritas) {
        this.cantidadComidasFavoritas = cantidadComidasFavoritas;
    }
}

