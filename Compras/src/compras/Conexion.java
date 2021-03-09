
package compras;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion 
{
    public static Connection getConexion()     
       {
        String conexion="jdbc:sqlserver://localhost:1433;"
                +"database=Compras;"
                +"user=sa;"
                +"password=1234;"
                +"loginTimeout=30;";
        try
            {
                Connection con=DriverManager.getConnection(conexion);
                return con;
            }catch(SQLException ex){
                System.out.println(ex.toString());
                return null;
            }
                
       }     
}
