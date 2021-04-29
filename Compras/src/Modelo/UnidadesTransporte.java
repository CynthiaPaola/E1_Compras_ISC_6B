/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class UnidadesTransporte {
     private int id,anio,capacidad;
    private String placas, marca,modelo,tipo;


    public UnidadesTransporte(int id, String placas, String marca,String modelo, String tipo, int anio, int capacidad) {
        this.id = id;
        this.anio=anio;
        this.capacidad=capacidad;
        this.marca=marca;
        this.modelo=modelo;
        this.tipo=tipo;
        this.placas=placas;
        
    }

    public UnidadesTransporte() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
  public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
}

