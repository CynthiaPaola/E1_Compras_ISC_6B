
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDao 
{
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn=new Conexion();
    
    public login log(String usuario,String contraseña)
    {
        login l=new login();
        String sql="SELECT * FROM Registrarse WHERE usuario=? AND contraseña=? ";
        try
        {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contraseña);
            rs=ps.executeQuery();
            if(rs.next())
            {
                l.setId(rs.getInt("idRegistrarse"));
                l.setUsuario(rs.getString("usuario"));
                l.setContraseña(rs.getString("contraseña"));
            }
        }catch(SQLException e)
        {
            System.out.println(e.toString());
        }
        return l;
        
    }
    public boolean Registrar(login reg)
    {
        String sql="INSERT INTO Registrarse(apellido_paterno,apellido_materno,nombre,usuario,contraseña) VALUES(?,?,?,?,?)";
        try
        {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, reg.getApellidop());
            ps.setString(2, reg.getApellidom());
            ps.setString(3, reg.getNombre());
            ps.setString(4, reg.getUsuario());
            ps.setString(5, reg.getContraseña());
            ps.execute();
            return true;
        }catch (SQLException e) {
            System.out.println(e.toString());
            return false; 
        }
    }
}
