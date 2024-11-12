package pe.edu.upc.fitfat.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Objetivos")
public class Objetivos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idObjetivos;

    @Column(name = "descripcion", length = 100, nullable = false)
    private String descripcion;

    @Column(name = "tipo_objetivo", length = 100, nullable = false)
    private String tipo_objetivo;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fecha_inicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fecha_fin;

    @Column(name = "estado", length = 100, nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "Usuarios_id")
    private Usuarios user;

    public Objetivos() {
    }

    public Objetivos(int idObjetivos, String descripcion, String tipo_objetivo, LocalDate fecha_inicio, LocalDate fecha_fin, String estado, Usuarios user) {
        this.idObjetivos = idObjetivos;
        this.descripcion = descripcion;
        this.tipo_objetivo = tipo_objetivo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
        this.user = user;
    }

    public int getIdObjetivos() {
        return idObjetivos;
    }

    public void setIdObjetivos(int idObjetivos) {
        this.idObjetivos = idObjetivos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo_objetivo() {
        return tipo_objetivo;
    }

    public void setTipo_objetivo(String tipo_objetivo) {
        this.tipo_objetivo = tipo_objetivo;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuarios getUser() {
        return user;
    }

    public void setUser(Usuarios user) {
        this.user = user;
    }
}
