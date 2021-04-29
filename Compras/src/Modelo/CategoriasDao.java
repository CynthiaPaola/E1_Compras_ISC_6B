
package Modelo;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;



public class CategoriasDao 
{
        Conexion cn=new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        
        public boolean RegistrarCategorias(Categorias ca)
        {
            String sql="INSERT INTO categoriass (nombre,estatus) VALUES (?,?)";
            try
            {
                con=cn.getConnection();
                ps=con.prepareStatement(sql);
               
                ps.setString(1, ca.getNombre());
                ps.setString(2, ca.getEstatus());
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
        public List ListarCategorias()
        {
            List<Categorias> ListaCa=new ArrayList();
            String sql="SELECT * FROM categoriass   WHERE estatus='a'   ORDER BY id DESC  ";//ORDER BY id DESC 
            try
            {
                con=cn.getConnection();
                ps=con.prepareStatement(sql);
                rs=ps.executeQuery();
                while(rs.next())
                {
                    Categorias ca=new Categorias();
                    ca.setIdCategoria(rs.getInt("id"));
                    ca.setNombre(rs.getString("nombre"));
                    ca.setEstatus(rs.getString("estatus"));
                    ListaCa.add(ca);
                    
                }
            }catch(SQLException e)
            {
                System.out.println(e.toString());
            }
            return ListaCa;
                  
        }
        public boolean EliminarCategorias(Categorias ca)
        {
            String sql="UPDATE categoriass SET estatus=? WHERE id=?";
            try
            {
                ps=con.prepareStatement(sql);
                ps.setString(1, "i" );
                ps.setInt(2,ca.getIdCategoria());
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
        public boolean ModificarCategorias(Categorias ca)
        {
            String sql="UPDATE categoriass SET nombre=? WHERE id=?";
            try
            {
                ps=con.prepareStatement(sql);
                
                ps.setString(1, ca.getNombre());
                
                ps.setInt(2, ca.getIdCategoria());
                
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
        public Categorias BuscarCategorias(String nombre)
        {
            Categorias obc=new Categorias();
            String sql="SELECT * FROM categoriassWHERE nombre=? ";
            
            try
            {
                con=cn.getConnection();
                ps=con.prepareStatement(sql);
                ps.setString(1, nombre);
                rs=ps.executeQuery();
                if(rs.next())
                {
                   obc.setIdCategoria(rs.getInt("id"));
                   obc.setNombre(rs.getString("nombre"));
                   obc.setEstatus(rs.getString("estatus"));
                }
            }catch(SQLException e)
            {
                System.out.println(e.toString());
                
            }
            return obc;
        }
}
