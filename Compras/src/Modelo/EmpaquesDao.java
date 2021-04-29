
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class EmpaquesDao
{
    
    Conexion cn=new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        
        public boolean RegistrarEmpaques(Empaques ma)
        {
            String sql="INSERT INTO comprasEmpaques (nombre,siglas,estatus) VALUES(?,?,?)";
            try
            {
                con=cn.getConnection();
                ps=con.prepareStatement(sql);
                ps.setString(1, ma.getNombre());
                ps.setString(2, ma.getSiglas());
                ps.setString(3, ma.getEstatus());
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
        public List ListarEmpaques()
        {
            List<Empaques> ListarEm=new ArrayList();
            String sql="SELECT * FROM comprasEmpaques";
            try
            {
                con=cn.getConnection();
                ps=con.prepareStatement(sql);
                rs=ps.executeQuery();
                while(rs.next())
                {
                    Empaques ma=new Empaques();
                    ma.setId(rs.getInt("idUnidad"));
                    ma.setNombre(rs.getString("nombre"));
                    ma.setSiglas(rs.getString("siglas"));
                    ma.setEstatus(rs.getString("estatus"));
                    ListarEm.add(ma);
                   
                }
                
            }catch(SQLException e)
            {
                
            System.out.println(e.toString());
            }
             
        return ListarEm;
        }
}
