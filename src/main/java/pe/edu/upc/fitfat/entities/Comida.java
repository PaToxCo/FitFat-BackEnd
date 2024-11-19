package pe.edu.upc.fitfat.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Comida")
public class Comida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComida;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "calorias")
    private Integer calorias;

    @Column(name = "proteinas")
    private Integer proteinas;

    @Column(name = "carbohidratos")
    private Integer carbohidratos;

    @Column(name = "grasas")
    private Integer grasas;

    @Column(name = "descripcion", length = 100)
    private String descripcion;

    @Column(name = "comiFavo")
    private Boolean comiFavo;

    @ManyToOne
    @JoinColumn(name = "idUsuario") // Clave foránea para la tabla de usuarios
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "id_tip_comi") // Clave foránea para la tabla de Tipo_comida
    private Tipo_comida tipoComida;

    // Getters y Setters

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
