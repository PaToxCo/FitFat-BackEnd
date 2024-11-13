package pe.edu.upc.fitfat.dtos;

public class GrasasByAlimentosDTO {
    private String nombre;
    private Double grasas;

    public Double getGrasas() {
        return grasas;
    }

    public void setGrasas(Double grasas) {
        this.grasas = grasas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
