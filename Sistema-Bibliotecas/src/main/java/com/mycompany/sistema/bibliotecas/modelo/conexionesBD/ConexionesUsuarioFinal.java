
package com.mycompany.sistema.bibliotecas.modelo.conexionesBD;

import com.mycompany.sistema.bibliotecas.modelo.Conexion;
import com.mycompany.sistema.bibliotecas.modelo.entidades.LibrosTotal;
import com.mycompany.sistema.bibliotecas.modelo.entidades.Prestamo;
import com.mycompany.sistema.bibliotecas.modelo.entidades.SolicitudPrestamo;
import com.mycompany.sistema.bibliotecas.modelo.entidades.UsuarioFinal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConexionesUsuarioFinal {
    
    private static Connection conexion;
    
    public static UsuarioFinal obtenerUsuarioFinal(int codigoUsuario){
        conexion = Conexion.getConnection();
        UsuarioFinal usuario = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = conexion.prepareStatement("SELECT nombre, nombre_usuario, correo, saldo FROM usuario_final "
                    + "WHERE codigo_usuario_final = ?");
            ps.setInt(1, codigoUsuario);
            rs = ps.executeQuery();
            
            while(rs.next()){
                usuario = new UsuarioFinal(rs.getString("nombre"), rs.getString("nombre_usuario"), rs.getString("correo"), rs.getDouble("saldo"));

            }
            
            
        } catch (Exception e) {
            System.err.println(e);
            
        }
        return usuario;
    }
    
     public static void editarPerfil(UsuarioFinal usuario){
        Connection conexion = Conexion.getConnection();
        PreparedStatement ps = null;
        
        String query = "UPDATE usuario_final SET nombre = ?, nombre_usuario = ?, correo = ? WHERE codigo_usuario_final = ?";
        try {
            ps = conexion.prepareStatement(query);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getNombreUsuario());
            ps.setString(3, usuario.getCorreo());
            ps.setInt(4, usuario.getCodigoUsuarioFinal());
            
            int resultado = ps.executeUpdate();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
     
      public static void recargarSaldo(double saldo, int codigoUsuario){
        Connection conexion = Conexion.getConnection();
        PreparedStatement ps = null;
        
        String query = "UPDATE usuario_final SET saldo = saldo + ? WHERE codigo_usuario_final=?";
        try {
            ps = conexion.prepareStatement(query);
            ps.setDouble(1,saldo);
            ps.setInt(2, codigoUsuario);
            
            int resultado = ps.executeUpdate();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
      }
      
      
      
      public static List<LibrosTotal> obtenerLibros(){
        conexion = Conexion.getConnection();
        List<LibrosTotal> libros = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = conexion.prepareStatement("SELECT lb.biblioteca, lb.isbn, lb.existencias, l.nombre AS nombre_libro, l.autor, c.descripcion AS descripcion_categoria "
                    + "FROM libros_biblioteca lb "
                    + "INNER JOIN libro l ON lb.isbn = l.isbn "
                    + "INNER JOIN categoria c ON l.categoria = c.codigo_categoria "
                    + "ORDER BY lb.biblioteca;");
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                int biblioteca = rs.getInt("biblioteca");
                int isbn = rs.getInt("isbn");
                int existencias = rs.getInt("existencias");
                String nombreLibro = rs.getString("nombre_libro");
                String autor = rs.getString("autor");
                String descripcionCategoria = rs.getString("descripcion_categoria");
                
                LibrosTotal lb = new LibrosTotal(biblioteca, isbn, existencias, nombreLibro, autor, descripcionCategoria);
                libros.add(lb);
                
            }
            
            
        } catch (Exception e) {
            System.err.println(e);
            
        }
        return libros;
    }
      
    public static int obtenerRecepcionista(int biblioteca) {
        conexion = Conexion.getConnection();
        int usuario = -1;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareStatement("SELECT codigo_usuario_recepcion FROM usuario_recepcion "
                    + "WHERE biblioteca = ?");
            ps.setInt(1, biblioteca);
            rs = ps.executeQuery();

            while (rs.next()) {
                usuario = rs.getInt("codigo_usuario_recepcion");
            }

        } catch (Exception e) {
            System.err.println(e);

        }
        return usuario;
    }
    
    
    public static int obtenerTransportista() {
        conexion = Conexion.getConnection();
        int usuario = -1;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareStatement("SELECT transportista, COUNT(*) AS total_inserciones "
                    + "FROM transporte_usuario_final "
                    + "GROUP BY transportista "
                    + "ORDER BY total_inserciones ASC "
                    + "LIMIT 1;");
            rs = ps.executeQuery();

            while (rs.next()) {
                usuario = rs.getInt("transportista");
            }

        } catch (Exception e) {
            System.err.println(e);

        }
        return usuario;
    }
    
    public static void crearSolicitudPrestamo(SolicitudPrestamo usuario){
        
        PreparedStatement ps = null;
        String query;
        String query1 = "INSERT INTO solicitud_prestamo(usuario,recepcionista,biblioteca"
                + ", isbn, estado, tipo_entrega, fecha) VALUES (?,?,?,?,?,?,?)";
        String query2 = "INSERT INTO solicitud_prestamo(usuario,recepcionista,biblioteca"
                + ", isbn, estado, tipo_entrega, fecha, transportista) VALUES (?,?,?,?,?,?,?,?)";
        
        if(usuario.getTipo_entrega().equals("RECEPCION")){
            query = query1;
        }else{
            query = query2;
        }
        
        try {
            Connection conexion = Conexion.getConnection();
            ps = conexion.prepareStatement(query);
            ps.setInt(1, usuario.getUsuario());
            ps.setInt(2, usuario.getRecepcionista());
            ps.setInt(3, usuario.getBiblioteca());
            ps.setInt(4, usuario.getIsbn());
            ps.setString(5, usuario.getEstado());
            ps.setString(6, usuario.getTipo_entrega());
            ps.setString(7, usuario.getFecha());
            
            if (usuario.getTipo_entrega().equals("DOMICILIO")) {
                ps.setInt(8, usuario.getTransportista());
            }
            
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static List<Prestamo> obtenerSolicitudes(int usuario){
        Connection conexion = Conexion.getConnection();
        List<Prestamo> solicitudes = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = conexion.prepareStatement("SELECT * FROM prestamo "
           + "WHERE usuario = ? "
           + "AND estado = 'ACTIVO'");
            
            ps.setInt(1, usuario);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                int biblioteca = rs.getInt("bibloteca");
                int recepcionista = rs.getInt("recepcionista");
                int isbn = rs.getInt("isbn");
                String fechaPrestamo = rs.getString("fecha_prestamo");
               
                LocalDate fechaPrestamoLocalDate = LocalDate.parse(fechaPrestamo);
                LocalDate fechaOchoDiasDespues = fechaPrestamoLocalDate.plusDays(8);
                String fechaDevolucion = fechaOchoDiasDespues.toString();

                Prestamo sp = new Prestamo(recepcionista, biblioteca, usuario, isbn, fechaPrestamo, fechaDevolucion);
                solicitudes.add(sp);
                
            }
            
            
        } catch (Exception e) {
            System.err.println(e);
            
        }
        return solicitudes;
    }
}
