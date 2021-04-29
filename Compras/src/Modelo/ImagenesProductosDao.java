/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author Tony
 */
public class ImagenesProductosDao 
{
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public void RegistrarImagenesProductos(ImagenesProductos img)
    {
        String sql="INSERT INTO ImagenesProductos(nombreImagen,principal,idProducto,imagen) VALUES(?,?,?,?)";
        try
        {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, img.getNombre());
            ps.setString(2, img.getPrincipal());
            ps.setInt(3, img.getIdProducto());
            ps.setBytes(4, img.getImagen());
            ps.executeUpdate();
            
        }catch(SQLException e)
        {
            System.out.println(e.toString());
            
        }
        finally{
            try{
                con.close();
            }catch(Exception e)
            {
                System.out.println(e.toString());
            }
        }
    }
    public void ConsultarImagenesProductos(JComboBox productos)
    {
        String sql="SELECT idProducto FROM Productos";
        try
        {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.execute();
            rs=ps.executeQuery();
            while(rs.next())
            {
                productos.addItem(rs.getInt("idProducto"));
            }
        }catch(SQLException e)
        {
            System.out.println(e.toString());
           
        }
    }
     public ArrayList<ImagenesProductos> ListarImagenesProductos()
     {
          ArrayList<ImagenesProductos> list = new ArrayList<ImagenesProductos>();
        Conexion conec = new Conexion();
        String sql = "SELECT * FROM ImagenesProductos ORDER BY idImagen DESC ";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                ImagenesProductos vo = new ImagenesProductos();
                vo.setIdImagen(rs.getInt(1));
                vo.setNombre(rs.getString(2));
                
                vo.setPrincipal(rs.getString(3));
                vo.setIdProducto(rs.getInt(4));
                vo.setImagen(rs.getBytes(5));
                list.add(vo);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                
            }catch(Exception ex){}
        }
        return list;
     }
     public void ModificarImagenesProductos(ImagenesProductos vo)
     {
        // cn
        String sql = "UPDATE ImagenesProductos SET nombreImagen = ?, principal = ?, idProducto = ?, imagen = ? WHERE idImagen = ?";
        PreparedStatement ps=null;
        try
        {
            ps=cn.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getNombre());
            ps.setString(2, vo.getPrincipal());
            ps.setInt(3, vo.getIdProducto());
            ps.setBytes(4, vo.getImagen());
            ps.setInt(5, vo.getIdImagen());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                
            }catch(Exception ex){}
        }
     }
     public void ModificarImagenesProductosv2(ImagenesProductos vo)
     {
        // cn
        String sql = "UPDATE ImagenesProductos SET nombreImagen = ?, principal = ?, idProducto = ? WHERE idImagen = ?";
        PreparedStatement ps=null;
        try
        {
            ps=cn.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getNombre());
            ps.setString(2, vo.getPrincipal());
            ps.setInt(3, vo.getIdProducto());
            
            ps.setInt(4, vo.getIdImagen());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                
            }catch(Exception ex){}
        }
     }
     public void EliminarImagenesProductos(ImagenesProductos vo)
     {
         String sql = "DELETE FROM ImagenesProductos  WHERE idImagen = ?;";
        PreparedStatement ps = null;
        try{
            ps = cn.getConnection().prepareStatement(sql);
            ps.setInt(1, vo.getIdImagen());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
               
            }catch(Exception ex){}
        }
     }

     public ImagenesProductos BuscarImagenesProductos(String nombre)
     {
         ImagenesProductos obc=new ImagenesProductos();
         String sql="SELECT * FROM ImagenesProductos WHERE nombreImagen=?";
                 try
                 {
                     con=cn.getConnection();
                     ps=con.prepareStatement(sql);
                     ps.setString(1, nombre);
                     rs=ps.executeQuery();
                     if(rs.next())
                     {
                         obc.setIdImagen(rs.getInt("idImagen"));
                         obc.setNombre(rs.getString("nombreImagen"));
                          obc.setPrincipal(rs.getString("principal"));
                           obc.setIdProducto(rs.getInt("idProducto"));
                           obc.setImagen(rs.getBytes("imagen"));
                     }
                 }catch(SQLException e)
            {
                System.out.println(e.toString());
                
            }
            return obc;
     }

}


