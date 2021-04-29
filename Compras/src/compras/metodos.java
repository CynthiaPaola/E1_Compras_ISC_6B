/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author HP
 */
public class metodos {
    public static Conexion conexion = new Conexion();

    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static String sql;
    public static int resultado_numero = 0;
   public int guardarProveedor(String IdProveedor, String nombre, String telefono, String email, String direccion, String colonia,String CodigoPostal,String idCiudad) {
        int resultado = 0;
        Connection conexion1 = null;
        String sentencia_guardar = ("INSERT INTO Proveedores (idProveedor,nombre,telefono,email,direccion,colonia,CodigoPostal,idCiudad) VALUES(?,?,?,?,?,?,?,?)");
        try {
            conexion1 = Conexion.conectar();

            sentencia_preparada = conexion1.prepareStatement(sentencia_guardar);
            sentencia_preparada.setString(1, IdProveedor);
            sentencia_preparada.setString(2, nombre);
            sentencia_preparada.setString(3, telefono);
            sentencia_preparada.setString(4, email);
            sentencia_preparada.setString(5, direccion);
            sentencia_preparada.setString(6, colonia);
            sentencia_preparada.setString(7, CodigoPostal);
            sentencia_preparada.setString(8, idCiudad);

            resultado = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();

            conexion1.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;
    } 
}
