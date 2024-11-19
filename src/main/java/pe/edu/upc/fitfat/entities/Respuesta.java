package pe.edu.upc.fitfat.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Respuesta")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRespuesta;
    @Column(name = "asunto", nullable = false, length = 100)
    private String asunto;
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;
    @Column(name = "fechaRespuesta", nullable = false)
    private LocalDate fechaRespuesta;
    @ManyToOne
    @JoinColumn(name = "consulta_id")
    private Consulta consulta;

    public Respuesta() {
    }

    public Respuesta(int idRespuesta, String asunto, String descripcion, LocalDate fechaRespuesta, Consulta consulta) {
        this.idRespuesta = idRespuesta;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.fechaRespuesta = fechaRespuesta;
        this.consulta = consulta;
    }

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(LocalDate fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}