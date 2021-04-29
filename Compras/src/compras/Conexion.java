
package compras;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion 
{
     public static String url="jdbc:sqlserver://RINGOLL:1433;databaseName=ERP2021;";
    public static String usuario="userSQL";
    public static String contraseña ="123";
    public static String clase ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static Connection conectar(){
     Connection conexion =null;
     try{
         Class.forName(clase);
         conexion = (Connection) DriverManager.getConnection(url,usuario,contraseña);
         System.out.println("Conectado");
     }catch(ClassNotFoundException | SQLException e){
         System.out.println(e);
     }
     return conexion;
    }

    static class Login {

        public Login() {
        }
    }
}
