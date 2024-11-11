package pe.edu.upc.fitfat.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Alimentos")
public class Alimentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlimentos;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "calorias", nullable = false)
    private Integer calorias;

    @Column(name = "proteinas", nullable = false)
    private Double proteinas;

    @Column(name = "carbohidratos", nullable = false)
    private Double carbohidratos;

    @Column(name = "grasas", nullable = false)
    private Double grasas;

    @ManyToOne
    @JoinColumn(name = "Dieta_idDieta", nullable = false)
    private Dieta dieta;

    @ManyToOne
    @JoinColumn(name = "Receta_idReceta", nullable = false)
    private Receta receta;

    // Constructor vacío
    public Alimentos() {}

    // Constructor con parámetros
    public Alimentos(int idAlimentos, String nombre, Integer calorias, Double proteinas, Double carbohidratos, Double grasas, Dieta dieta, Receta receta) {
        this.idAlimentos = idAlimentos;
        this.nombre = nombre;
        this.calorias = calorias;
        this.proteinas = proteinas;
        this.carbohidratos = carbohidratos;
        this.grasas = grasas;
        this.dieta = dieta;
        this.receta = receta;
    }

    // Getters y Setters
    public int getIdAlimentos() {
        return idAlimentos;
    }

    public void setIdAlimentos(int idAlimentos) {
        this.idAlimentos = idAlimentos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCalorias() {
        return calorias;
    }

    public void setCalorias(Integer calorias) {
        this.calorias = calorias;
    }

    public Double getProteinas() {
        return proteinas;
    }

    public void setProteinas(Double proteinas) {
        this.proteinas = proteinas;
    }

    public Double getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(Double carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    public Double getGrasas() {
        return grasas;
    }

    public void setGrasas(Double grasas) {
        this.grasas = grasas;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }
}
