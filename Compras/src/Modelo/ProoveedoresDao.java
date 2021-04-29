
package Modelo;


import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;



public class ProoveedoresDao 
{
    Conexion cn=new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
       
        public boolean RegistrarProveedores(Prooveedores pa)
        {
            String sql="INSERT INTO Prooveedores(nombre,telefono,email,direccion,colonia,codigopostal,idciudad) VALUES(?,?,?,?,?,?,?)";
            try
            {
                con=cn.getConnection();
                ps=con.prepareStatement(sql);
                
                ps.setString(1, pa.getNombre());
                ps.setInt(2, pa.getTelefono());
                ps.setString(3, pa.getEmail());
                ps.setString(4, pa.getDireccion());
                ps.setString(5,pa.getColonia());
                ps.setString(6, pa.getCodigo());
                ps.setInt(7, pa.getCiudad());
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
}
