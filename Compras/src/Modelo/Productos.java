
package Modelo;



public class Productos 
{
    private int idproducto,idlaboratorio,idcategoria;
    private String nombre,descripcion,ingredienteactivo,bandatoxicologica,aplicacion,uso,estatus;
    
    public Productos()
    {
        
    }

    public Productos(int idproducto, int idlaboratorio, int idcategoria, String nombre, String descripcion, String ingredienteactivo, String bandatoxicologica, String aplicacion, String uso, String estatus) {
        this.idproducto = idproducto;
        this.idlaboratorio = idlaboratorio;
        this.idcategoria = idcategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ingredienteactivo = ingredienteactivo;
        this.bandatoxicologica = bandatoxicologica;
        this.aplicacion = aplicacion;
        this.uso = uso;
        this.estatus = estatus;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getIdlaboratorio() {
        return idlaboratorio;
    }

    public void setIdlaboratorio(int idlaboratorio) {
        this.idlaboratorio = idlaboratorio;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIngredienteactivo() {
        return ingredienteactivo;
    }

    public void setIngredienteactivo(String ingredienteactivo) {
        this.ingredienteactivo = ingredienteactivo;
    }

    public String getBandatoxicologica() {
        return bandatoxicologica;
    }

    public void setBandatoxicologica(String bandatoxicologica) {
        this.bandatoxicologica = bandatoxicologica;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    
    

   
    

   
    
}
