
package Modelo;


public class Laboratorios
{
    private int id;
    private String nombre, origen,estatus;
    
    public Laboratorios()
    {
        
    }

    public Laboratorios(int id, String nombre, String origen, String estatus)
   {
        this.id = id;
        this.nombre = nombre;
        this.origen = origen;
        this.estatus = estatus;
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

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
    
}
