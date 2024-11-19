package pe.edu.upc.fitfat.dtos;

public class ControlesPorDietaDTO {
    private int idDieta;
    private long totalControles;


    // Getters and setters
    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public long getTotalControles() {
        return totalControles;
    }

    public void setTotalControles(long totalControles) {
        this.totalControles = totalControles;
    }
}
