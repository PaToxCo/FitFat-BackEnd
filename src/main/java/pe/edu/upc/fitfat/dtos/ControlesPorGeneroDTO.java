package pe.edu.upc.fitfat.dtos;

public class ControlesPorGeneroDTO {
    private String genero;
    private long totalControles;


    // Getters and setters
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public long getTotalControles() {
        return totalControles;
    }

    public void setTotalControles(long totalControles) {
        this.totalControles = totalControles;
    }
}
