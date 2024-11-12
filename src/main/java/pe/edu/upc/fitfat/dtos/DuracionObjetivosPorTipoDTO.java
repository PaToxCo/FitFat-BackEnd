package pe.edu.upc.fitfat.dtos;

public class DuracionObjetivosPorTipoDTO {
    private String tipo_objetivo;
    private Long duracion_total;

    public DuracionObjetivosPorTipoDTO() {}

    public DuracionObjetivosPorTipoDTO(String tipo_objetivo, Long duracion_total) {
        this.tipo_objetivo = tipo_objetivo;
        this.duracion_total = duracion_total;
    }

    public String getTipo_objetivo() {
        return tipo_objetivo;
    }

    public void setTipo_objetivo(String tipo_objetivo) {
        this.tipo_objetivo = tipo_objetivo;
    }

    public Long getDuracion_total() {
        return duracion_total;
    }

    public void setDuracion_total(Long duracion_total) {
        this.duracion_total = duracion_total;
    }
}
