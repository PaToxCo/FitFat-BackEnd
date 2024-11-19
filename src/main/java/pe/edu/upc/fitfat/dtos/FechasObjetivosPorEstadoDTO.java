package pe.edu.upc.fitfat.dtos;

import java.time.LocalDate;

public class FechasObjetivosPorEstadoDTO {
    private String estado;
    private LocalDate fecha_inicio_min;
    private LocalDate fecha_inicio_max;

    public FechasObjetivosPorEstadoDTO() {}

    public FechasObjetivosPorEstadoDTO(String estado, LocalDate fecha_inicio_min, LocalDate fecha_inicio_max) {
        this.estado = estado;
        this.fecha_inicio_min = fecha_inicio_min;
        this.fecha_inicio_max = fecha_inicio_max;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFecha_inicio_min() {
        return fecha_inicio_min;
    }

    public void setFecha_inicio_min(LocalDate fecha_inicio_min) {
        this.fecha_inicio_min = fecha_inicio_min;
    }

    public LocalDate getFecha_inicio_max() {
        return fecha_inicio_max;
    }

    public void setFecha_inicio_max(LocalDate fecha_inicio_max) {
        this.fecha_inicio_max = fecha_inicio_max;
    }
}
