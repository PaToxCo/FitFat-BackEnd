package pe.edu.upc.fitfat.dtos;

public class Tipo_comidaDTO {
    private int idTipComi;
    private String descripcion;
    private String tipo;
    private String categoria;

    // Getters y Setters
    public int getIdTipComi() {
        return idTipComi;
    }

    public void setIdTipComi(int idTipComi) {
        this.idTipComi = idTipComi;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
