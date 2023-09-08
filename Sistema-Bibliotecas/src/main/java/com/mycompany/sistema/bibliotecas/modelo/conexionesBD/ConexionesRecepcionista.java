
package com.mycompany.sistema.bibliotecas.modelo.conexionesBD;

import com.mycompany.sistema.bibliotecas.modelo.Conexion;
import com.mycompany.sistema.bibliotecas.modelo.entidades.LibrosTotal;
import com.mycompany.sistema.bibliotecas.modelo.entidades.Prestamo;
import com.mycompany.sistema.bibliotecas.modelo.entidades.SolicitudPrestamo;
import com.mycompany.sistema.bibliotecas.modelo.entidades.UsuarioFinal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConexionesRecepcionista {
    
    public static void registrarUsuarioFinal(UsuarioFinal usuario){
        
        PreparedStatement ps = null;
        String query = "INSERT INTO usuario_final(codigo_usuario_final,nombre,nombre_usuario,contrasenia, correo, saldo) VALUES (?,?,?,?,?,?)";
        
        try {
            Connection conexion = Conexion.getConnection();
            ps = conexion.prepareStatement(query);
            ps.setInt(1, usuario.getCodigoUsuarioFinal());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getNombreUsuario());
            ps.setString(4, usuario.getContrasenia());
            ps.setString(5, usuario.getCorreo());
            ps.setDouble(6, usuario.getSaldo());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static List<LibrosTotal> obtenerLibros(int biblioteca){
        Connection conexion = Conexion.getConnection();
        List<LibrosTotal> libros = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = conexion.prepareStatement("SELECT lb.isbn, lb.existencias, l.nombre AS nombre_libro, l.autor, c.descripcion AS descripcion_categoria "
                    + "FROM libros_biblioteca lb "
                    + "INNER JOIN libro l ON lb.isbn = l.isbn "
                    + "INNER JOIN categoria c ON l.categoria = c.codigo_categoria "
                    + "WHERE lb.biblioteca = ?");
            
            ps.setInt(1, biblioteca);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
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
    
    public static void registrarPrestamo(Prestamo usuario){
        
        PreparedStatement ps = null;
        String query = "INSERT INTO prestamo(recepcionista,bibloteca"
                + ",usuario, isbn, estado, multa, fecha_prestamo,fecha_devolucion) VALUES (?,?,?,?,?,?,?,?)";
        
        try {
            Connection conexion = Conexion.getConnection();
            ps = conexion.prepareStatement(query);
            ps.setInt(1, usuario.getRecepcionista());
            ps.setInt(2, usuario.getBibloteca());
            ps.setInt(3, usuario.getUsuario());
            ps.setInt(4, usuario.getIsbn());
            ps.setString(5, usuario.getEstado());
            ps.setDouble(6, usuario.getMulta());
            ps.setString(7, usuario.getFechaPrestamo());
            ps.setString(8, usuario.getFechaDevolucion());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public static List<SolicitudPrestamo> obtenerSolicitudes(int biblioteca){
        Connection conexion = Conexion.getConnection();
        List<SolicitudPrestamo> solicitudes = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = conexion.prepareStatement("SELECT * FROM solicitud_prestamo "
           + "WHERE biblioteca = ? "
           + "AND estado = 'PENDIENTE' "
           + "AND tipo_entrega = 'RECEPCION'");
            
            ps.setInt(1, biblioteca);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                int codigoSolicitud = rs.getInt("codigo_solicitud_prestamo");
                int usuario = rs.getInt("usuario");
                int recepcionista = rs.getInt("recepcionista");
                int isbn = rs.getInt("isbn");
                String fecha = rs.getString("fecha");

                SolicitudPrestamo sp = new SolicitudPrestamo(codigoSolicitud, usuario, recepcionista, biblioteca, isbn, fecha);
                solicitudes.add(sp);
                
            }
            
            
        } catch (Exception e) {
            System.err.println(e);
            
        }
        return solicitudes;
    }
    
    public static void editarSolicitud(int  codigo){
        Connection conexion = Conexion.getConnection();
        PreparedStatement ps = null;
        
        String query = "UPDATE solicitud_prestamo SET estado = ? WHERE codigo_solicitud_prestamo = ?";
        try {
            ps = conexion.prepareStatement(query);
            ps.setString(1, "FINALIZADA");
            ps.setInt(2, codigo);
            
            int resultado = ps.executeUpdate();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
}
