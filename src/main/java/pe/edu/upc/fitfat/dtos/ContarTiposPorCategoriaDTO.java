package pe.edu.upc.fitfat.dtos;

public class ContarTiposPorCategoriaDTO {

    private String categoria;
    private Long cantidad;

    public ContarTiposPorCategoriaDTO() {}

    public ContarTiposPorCategoriaDTO(String categoria, Long cantidad) {
        this.categoria = categoria;
        this.cantidad = cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
}
