package pe.edu.upc.fitfat.dtos;

public class RecetaCountDTO {
    private String comidaId;
    private Long totalRecetas;

    // Getters y setters
    public String getComidaId() {
        return comidaId;
    }

    public void setComidaId(String comidaId) {
        this.comidaId = comidaId;
    }

    public Long getTotalRecetas() {
        return totalRecetas;
    }

    public void setTotalRecetas(Long totalRecetas) {
        this.totalRecetas = totalRecetas;
    }
}
