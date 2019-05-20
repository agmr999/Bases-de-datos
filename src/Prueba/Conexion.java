package Prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String passwrd = "rootpasswordgiven";
    private static final String url = "jdbc:mysql://localhost:3306/Prueba";

    public Conexion(){
        conn = null;
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url,user,passwrd);
                if(conn != null){
                    System.out.println("Conexion establecida");
                }
            } catch (ClassNotFoundException | SQLException e){
                System.out.println("Error al conectar" +e);
            }
    }

    public Connection getConnection(){
        return conn;
    }

    public  void desconectar(){
        conn = null;
        if(conn == null){
            System.out.println("Conexion terminada...");
        }
    }
}
