package pe.edu.upc.fitfat.dtos;

public class TotalAlimentosDTO {
    private String dieta;
    private Long totalAlimentos;

    // Getters y setters
    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }

    public Long getTotalAlimentos() {
        return totalAlimentos;
    }

    public void setTotalAlimentos(Long totalAlimentos) {
        this.totalAlimentos = totalAlimentos;
    }
}
