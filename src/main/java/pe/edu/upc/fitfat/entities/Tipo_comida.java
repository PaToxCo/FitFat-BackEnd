package pe.edu.upc.fitfat.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Tipo_comida")
public class Tipo_comida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipComi;

    @Column(name = "descripcion", length = 100)
    private String descripcion;

    @Column(name = "tipo", nullable = false, length = 100)
    private String tipo;

    @Column(name = "categoria", length = 30)
    private String categoria;

    public Tipo_comida() {}

    public Tipo_comida(int idTipComi, String descripcion, String tipo, String categoria) {
        this.idTipComi = idTipComi;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public int getIdTipComi() {
        return idTipComi;
    }

    public void setIdTipComi(int idTipComi) {
        this.idTipComi = idTipComi;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
