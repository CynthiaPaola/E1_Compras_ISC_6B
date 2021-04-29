/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author frank
 */
public class ProductosProveedor {
    private int idProveedor, idPresentacion, diasRetardo, cantMinPedir, cantMaxPedir;
    private float precioEstandar, precioUltimaCompra;
    
    public ProductosProveedor(){
        
    }
    
    public ProductosProveedor(int idProveedor, int idPresentacion, int diasRetardo, float precioEstandar, float precioUltimaCompra, int cantMinPedir, int cantMaxPedir){
        this.idProveedor = idProveedor;
        this.idPresentacion = idPresentacion;
        this.diasRetardo = diasRetardo;
        this.precioEstandar = precioEstandar;
        this.precioUltimaCompra = precioUltimaCompra;
        this.cantMinPedir = cantMinPedir;
        this.cantMaxPedir = cantMaxPedir;    
    }
    
   public int getIdproveedor(){
       return idProveedor;
   }
    public void setIdproveedor(int idProveedor){
        this.idProveedor = idProveedor;
    }
    
    public int getIdpresentacion(){
        return idPresentacion;
    }
    
    public void setIdpresentacion(int idPresentacion){
        this.idPresentacion = idPresentacion;
    }
    
    public int getDiasretardo(){
        return diasRetardo;
    }
    
    public void setDiasretardo(int diasRetardo){
        this.diasRetardo = diasRetardo;
    }
    
    public float getPrecioestandar(){
        return precioEstandar;
    }
    
    public void setPrecioestandar(float precioEstandar){
        this.precioEstandar = precioEstandar;
    }
    
    public float getPrecioultimacompra(){
        return precioUltimaCompra;
    }
    
    public void setPrecioultimacompra(float precioUltimaCompra){
        this.precioUltimaCompra = precioUltimaCompra;
    }
    
    public int getCantminpedir(){
        return cantMinPedir;
    }
    
    public void setCantminpedir(int cantMinPedir){
        this.cantMinPedir = cantMinPedir;
    }
    
    public int getCantmaxpedir(){
        return cantMaxPedir;
    }
    
    public void setCantmaxpedir(int cantMaxPedir){
        this.cantMaxPedir = cantMaxPedir; 
    }


    

    
    
}
