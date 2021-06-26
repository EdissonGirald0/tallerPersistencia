
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
   private static Connection conn;
   private static final String driver = "com.mysql.cj.jdbc.Driver";
   private static final String user = "root";
   private static final String Pasw = "#654Base#";
   private static final String url = "jdbc:mysql://localhost:3306/prueva";
   // construye la coneccion con la base de datos
    public Conector() {
        conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user,Pasw);
            if (conn != null) {
                System.out.println("Conecion Establecida..");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Conecion  No Establecida..");
        }
    }
   // retorna la coneccion
    public  Connection getConnection(){
    return conn;
    }
    // desconectar de la base de datos 
    public void desconectar(){
    conn = null;
        if (conn == null) {
            System.out.println("desconectado");
        }
    }

    Connection getConexion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
