
package Modelo;


public class Medidas 
{
    private int id;
    private String nombre,salida,estaus;

    public Medidas() {
    }

    public Medidas(int id, String nombre, String salida, String estaus) {
        this.id = id;
        this.nombre = nombre;
        this.salida = salida;
        this.estaus = estaus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getEstaus() {
        return estaus;
    }

    public void setEstaus(String estaus) {
        this.estaus = estaus;
    }
    
    
    
}
