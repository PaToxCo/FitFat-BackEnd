package pe.edu.upc.fitfat.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "Control")
public class Control {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idControl")
    private int idControl;

    @Column(name = "peso", nullable = false, precision = 5, scale = 2)
    private BigDecimal peso;

    @Column(name = "talla", nullable = false, precision = 4, scale = 2)
    private BigDecimal talla;

    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name = "genero", nullable = false, length = 10)
    private String genero;

    @ManyToOne
    @JoinColumn(name = "Dieta_idDieta", nullable = false)
    private Dieta dieta;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuarios usuario;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    public Control() {}

    public Control(int idControl, BigDecimal peso, BigDecimal talla, int edad, String genero, Dieta dieta, Usuarios usuario, Date fecha) {
        this.idControl = idControl;
        this.peso = peso;
        this.talla = talla;
        this.edad = edad;
        this.genero = genero;
        this.dieta = dieta;
        this.usuario = usuario;
        this.fecha = fecha;
    }

    public int getIdControl() {
        return idControl;
    }

    public void setIdControl(int idControl) {
        this.idControl = idControl;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getTalla() {
        return talla;
    }

    public void setTalla(BigDecimal talla) {
        this.talla = talla;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
