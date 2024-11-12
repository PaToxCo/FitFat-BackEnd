package pe.edu.upc.fitfat.dtos;

import pe.edu.upc.fitfat.entities.Tipo_comida;
import pe.edu.upc.fitfat.entities.Usuarios;

public class ComidaDTO {
    private int idComida;
    private String nombre;
    private Integer calorias;
    private Integer proteinas;
    private Integer carbohidratos;
    private Integer grasas;
    private String descripcion;
    private Boolean comiFavo;
    private Usuarios usuario;
    private Tipo_comida tipoComida;

    // Getters and Setters
    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
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

    public Integer getProteinas() {
        return proteinas;
    }

    public void setProteinas(Integer proteinas) {
        this.proteinas = proteinas;
    }

    public Integer getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(Integer carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    public Integer getGrasas() {
        return grasas;
    }

    public void setGrasas(Integer grasas) {
        this.grasas = grasas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getComiFavo() {
        return comiFavo;
    }

    public void setComiFavo(Boolean comiFavo) {
        this.comiFavo = comiFavo;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Tipo_comida getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(Tipo_comida tipoComida) {
        this.tipoComida = tipoComida;
    }
}
