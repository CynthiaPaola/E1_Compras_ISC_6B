
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class LaboratoriosDao
{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarLaboratorios(Laboratorios la)
    {
        String sql="INSERT INTO Laboratorios (nombre, origen, estatus) VALUES(?,?,?)";
        try
        {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            
            ps.setString(1, la.getNombre());
            ps.setString(2, la.getOrigen());
            ps.setString(3, la.getEstatus());
            ps.execute();
            return true;
        }catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,"no esta bien");
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
    public List ListarLaboratorios()
    {
        List<Laboratorios> ListaLa=new ArrayList();
        String slq="SELECT * FROM Laboratorios";
        try
        {
            con=cn.getConnection();
            ps=con.prepareStatement(slq);
            rs=ps.executeQuery();
            while(rs.next())
            {
                Laboratorios la=new Laboratorios();
                la.setId(rs.getInt("idLaboratorio"));
                la.setNombre(rs.getString("nombre"));
                la.setOrigen(rs.getString("origen"));
                la.setEstatus(rs.getString("estatus"));
                ListaLa.add(la);
            }
        }
        catch(SQLException e)
            {
                System.out.println(e.toString());
            }
            return ListaLa;
    }
    public boolean EliminarLaboratorios(int id)
    {
        String sql="DELETE FROM Laboratorios WHERE idLaboratorio=?";
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
    public boolean ModificarLaboratorios(Laboratorios la)
    {
        String sql="UPDATE Laboratorios SET nombre=?,origen=?,estatus=? WHERE idLaboratorio=?";
        try
        {
            ps=con.prepareStatement(sql);
            ps.setString(1, la.getNombre());
            ps.setString(2, la.getOrigen());
            ps.setString(3, la.getEstatus());
            ps.setInt(4, la.getId());
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
    public Laboratorios BuscarLaboratorios(String nombre)
    {
        Laboratorios obc=new Laboratorios();
        String sql="SELECT * FROM Laboratorios WHERE nombre=?";
        
        try
        {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs=ps.executeQuery();
            if(rs.next())
            {
                obc.setId(rs.getInt("idLaboratorio"));
                obc.setNombre(rs.getString("nombre"));
                obc.setOrigen(rs.getString("origen"));
                obc.setEstatus(rs.getString("estatus"));
            }
        }catch(SQLException e)
            {
                System.out.println(e.toString());
                
            }
            return obc;
    }
}
