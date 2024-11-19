package pe.edu.upc.fitfat.dtos;

public class DescripcionLengthDTO {
    private String comidaId;
    private Long totalDescripcionLength;

    // Getters y setters
    public String getComidaId() {
        return comidaId;
    }

    public void setComidaId(String comidaId) {
        this.comidaId = comidaId;
    }

    public Long getTotalDescripcionLength() {
        return totalDescripcionLength;
    }

    public void setTotalDescripcionLength(Long totalDescripcionLength) {
        this.totalDescripcionLength = totalDescripcionLength;
    }
}
