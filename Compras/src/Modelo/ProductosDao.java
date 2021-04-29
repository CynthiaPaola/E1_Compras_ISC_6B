
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;


public class ProductosDao 
{
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    public boolean RegistrarProductos(Productos pro)
    {
        String sql="INSERT INTO Productos(nombre,descripcion,ingredienteActivo,bandaToxicologica,aplicacion,uso,estatus,idLaboratorio,id) VALUES(?,?,?,?,?,?,?,?,?)";
        try
        {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getDescripcion());
            ps.setString(3, pro.getIngredienteactivo());
            ps.setString(4, pro.getBandatoxicologica());
            ps.setString(5, pro.getAplicacion());
            ps.setString(6, pro.getUso());
            ps.setString(7, pro.getEstatus());
           ps.setInt(8, pro.getIdlaboratorio());
            ps.setInt(9, pro.getIdcategoria());
            
            ps.execute();
            return true;
        }catch(SQLException e)
        {
            System.out.println(e.toString());
            return false;
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

    public void ConsultarLaboratorios(JComboBox Laboratorios)
    {
        String sql="SELECT idLaboratorio FROM Laboratorios";
        try
        {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.execute();
            rs=ps.executeQuery();
            while(rs.next())
            {
                Laboratorios.addItem(rs.getInt("idLaboratorio"));
            }
        }catch(SQLException e)
        {
            System.out.println(e.toString());
           
        }
    }
    public void ConsultarCategorias(JComboBox categorias)
    {
         String sql="SELECT id FROM categoriass";
        try
        {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.execute();
            rs=ps.executeQuery();
            while(rs.next())
            {
               categorias.addItem(rs.getInt("id"));
            }
        }catch(SQLException e)
        {
            System.out.println(e.toString());
           
        }
    }
    public List ListarProductos()
    {
        List<Productos> ListaPro=new ArrayList();
        String sql="SELECT * FROM Productos WHERE estatus='a' ORDER BY idProducto DESC ";
        try
        {
             con=cn.getConnection();
                ps=con.prepareStatement(sql);
                rs=ps.executeQuery();
                while(rs.next())
                {
                    Productos po=new Productos();
                    po.setIdproducto(rs.getInt("idProducto"));
                    po.setNombre(rs.getString("nombre"));
                    po.setDescripcion(rs.getString("descripcion"));
                    po.setIngredienteactivo(rs.getString("ingredienteActivo"));
                    po.setBandatoxicologica(rs.getString("bandaToxicologica"));
                    po.setAplicacion(rs.getString("aplicacion"));
                    po.setUso(rs.getString("uso"));
                    po.setEstatus(rs.getString("estatus"));
                    po.setIdlaboratorio(rs.getInt("idLaboratorio"));
                    po.setIdcategoria(rs.getInt("id"));
                    ListaPro.add(po);
                }
        }catch(SQLException e)
            {
                System.out.println(e.toString());
            }
            return ListaPro;
    }
    public boolean EliminarProductos(Productos po)
    {
        String sql="UPDATE Productos SET estatus=?  WHERE idProducto=?";
        try
        {
            ps=con.prepareStatement(sql);
            ps.setString(1, "i");
            ps.setInt(2, po.getIdproducto());
           
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
    public boolean ModificarProductos(Productos po)
    {
        String sql="UPDATE Productos SET nombre=?, descripcion=?, ingredienteActivo=?, bandaToxicologica=?, aplicacion=?, uso=?, estatus=?, idLaboratorio=?,id=? WHERE idProducto=?";
        try 
        {
            ps=con.prepareStatement(sql);
            ps.setString(1, po.getNombre());
            ps.setString(2, po.getDescripcion());
            ps.setString(3, po.getIngredienteactivo());
            ps.setString(4, po.getBandatoxicologica());
            ps.setString(5, po.getAplicacion());
            ps.setString(6, po.getUso());
            ps.setString(7, po.getEstatus());
            ps.setInt(8, po.getIdlaboratorio());
            ps.setInt(9, po.getIdcategoria());
            ps.setInt(10, po.getIdproducto());
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
    public Productos BuscarProductos(String nombre)
    {
        Productos obc=new Productos();
        String sql="SELECT * FROM Productos WHERE nombre=? ";
        try
        {
             con=cn.getConnection();
                ps=con.prepareStatement(sql);
                ps.setString(1, nombre);
                rs=ps.executeQuery();
                while(rs.next())
                {
                    Productos po=new Productos();
                    obc.setIdproducto(rs.getInt("idProducto"));
                  obc.setNombre(rs.getString("nombre"));
                    obc.setDescripcion(rs.getString("descripcion"));
                   obc.setIngredienteactivo(rs.getString("ingredienteActivo"));
                    obc.setBandatoxicologica(rs.getString("bandaToxicologica"));
                    obc.setAplicacion(rs.getString("aplicacion"));
                    obc.setUso(rs.getString("uso"));
                   obc.setEstatus(rs.getString("estatus"));
                   obc.setIdlaboratorio(rs.getInt("idLaboratorio"));
                    obc.setIdcategoria(rs.getInt("id"));
                    
                }
        }catch(SQLException e)
            {
                System.out.println(e.toString());
            }
            return obc;
    }

}
