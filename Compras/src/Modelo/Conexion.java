
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;

public class Conexion 
{
    String url="jdbc:sqlserver://PANCHO\\SQLEXPRESS:1433;databaseName=ERP2021";
    String usuario="sa";
    String contraseña="1234";
    String clase="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    Connection con;
    public Connection getConnection()
    {
        try
        {
            con=DriverManager.getConnection(url,usuario,contraseña);
            return con;
        }catch(SQLException e)
        {
            System.out.println(e.toString());
        }
        return null;
    }
    
}
