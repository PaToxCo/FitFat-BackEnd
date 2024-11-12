package pe.edu.upc.fitfat.dtos;

public class TotalCaloriasDTO {
    private String dieta;
    private Long totalCalorias;

    // Getters y setters
    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }

    public Long getTotalCalorias() {
        return totalCalorias;
    }

    public void setTotalCalorias(Long totalCalorias) {
        this.totalCalorias = totalCalorias;
    }
}
