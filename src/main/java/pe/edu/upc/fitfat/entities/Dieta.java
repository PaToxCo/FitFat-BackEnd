package pe.edu.upc.fitfat.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Dieta")
public class Dieta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDieta")
    private int idDieta;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "duracion", nullable = false)
    private int duracion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuarios usuario;

    public Dieta() {}

    public Dieta(int idDieta, String nombre, int duracion, Usuarios usuario) {
        this.idDieta = idDieta;
        this.nombre = nombre;
        this.duracion = duracion;
        this.usuario = usuario;
    }

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
