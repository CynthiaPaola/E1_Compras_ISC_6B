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
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Tony
 */
public class MedidasDao 
{
    Conexion cn=new Conexion();
    Connection con;
   PreparedStatement ps;
   ResultSet rs;
    
    public boolean RegistrarMedidas(Medidas me)
    {
      String sql="INSERT INTO Medidas (nombre,salida,estatus) VALUES(?,?,?)";
      try
      {
          con=(Connection) cn.getConnection();
          ps=con.prepareStatement(sql);
          ps.setString(1, me.getNombre());
          ps.setString(2, me.getSalida());
          ps.setString(3, me.getEstaus());
          ps.execute();
                  return true;
          
      }catch(SQLException e)
      {
           JOptionPane.showMessageDialog(null,"no esta bien");
        return false;
      }finally{
            try{
                con.close();
            }catch(Exception e)
            {
                System.out.println(e.toString());
            }
      }
    }
    public List ListarMedidas()
    {
        List<Medidas> ListaMa=new ArrayList();
        String sql="SELECT * FROM Medidas";
        try
        {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
            {
                Medidas ma=new Medidas();
                ma.setId(rs.getInt("idUnidad"));
                ma.setNombre(rs.getString("nombre"));
                ma.setSalida(rs.getString("salida"));
                ma.setEstaus(rs.getString("estatus"));
                ListaMa.add(ma);
            }
        }catch(SQLException e)
        {
            System.out.println(e.toString());
        }
        return ListaMa;
              
    }
    public boolean EliminarMedidas(int id)
    {
        String sql="DELETE FROM Medidas WHERE idUnidad=?";
        try
        {
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        }catch(SQLException e)
        {
            System.out.println(e.toString());
                return false;
        }finally{
            try{
                con.close();
            }catch(Exception e)
            {
                System.out.println(e.toString());
            }
    }
    }
    public boolean ModificarMedidas(Medidas me)
    {
        String sql="UPDATE Medidas SET nombre=?,salida=?,estatus=? WHERE idUnidad=?";
        try
        {
            ps=con.prepareStatement(sql);
            ps.setString(1, me.getNombre());
            ps.setString(2, me.getSalida());
            ps.setString(3, me.getEstaus());
            ps.setInt(4, me.getId());
            ps.execute();
            return true;
        }catch(SQLException e)
        {
            System.out.println(e.toString());
                return false;
        }finally{
            try{
                con.close();
            }catch(Exception e)
            {
                System.out.println(e.toString());
            }
    }
    }
    public Medidas BuscarMedidas(String nombre)
    {
        Medidas obc=new Medidas();
        String sql="SELECT * FROM Medidas WHERE nombre=?";
        try
        {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs=ps.executeQuery();
            if(rs.next())
            {
                obc.setId(rs.getInt("idUnidad"));
                obc.setNombre(rs.getString("nombre"));
                obc.setSalida(rs.getString("salida"));
                obc.setEstaus(rs.getString("estatus"));
            }
        }catch(SQLException e)
            {
                System.out.println(e.toString());
                
            }
            return obc;
    }
}
