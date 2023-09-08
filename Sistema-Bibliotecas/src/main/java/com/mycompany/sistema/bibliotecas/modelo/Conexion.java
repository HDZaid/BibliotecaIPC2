
package com.mycompany.sistema.bibliotecas.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    public static Connection conexion;

    public static final String URL = "jdbc:mysql://localhost:3306/sistema_bibliotecas?autoReconnect=true&useSSL=false";
    public static final String usuario = "rootdba";
    public static final String contraseña = "11111";

    public static Connection getConnection() {

        try {
            if (conexion == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection(URL, usuario, contraseña);
            }
            

        } catch (Exception e) {
            System.err.println(e);
        }

        return conexion;
    }
    
    public static void cerrarConexion(){
        if (conexion != null) {
            try {
                conexion.close();
                conexion = null;
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                System.out.println("No se pudo cerrar la conexión");
                e.printStackTrace();
            }
        }
    }
    
}
