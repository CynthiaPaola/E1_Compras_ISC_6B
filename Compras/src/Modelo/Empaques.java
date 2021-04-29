
package Modelo;


public class Empaques
{
    private int id;
    private String nombre,siglas,estatus;
    
    public Empaques()
    {
        
    }

    public Empaques(int id, String nombre, String siglas, String estatus) 
    {
        this.id = id;
        this.nombre = nombre;
        this.siglas = siglas;
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

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
    
    
}
