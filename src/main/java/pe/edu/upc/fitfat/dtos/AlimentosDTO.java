package pe.edu.upc.fitfat.dtos;

import pe.edu.upc.fitfat.entities.Dieta;
import pe.edu.upc.fitfat.entities.Receta;

public class AlimentosDTO {
    private int idAlimentos;
    private String nombre;
    private Integer calorias;
    private Double proteinas;
    private Double carbohidratos;
    private Double grasas;
    private Dieta dieta;
    private Receta receta;

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
