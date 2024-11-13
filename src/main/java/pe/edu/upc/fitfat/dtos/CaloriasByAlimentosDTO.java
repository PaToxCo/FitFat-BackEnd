package pe.edu.upc.fitfat.dtos;

public class CaloriasByAlimentosDTO {
    private String nombre;
    private Integer calorias;

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
}
