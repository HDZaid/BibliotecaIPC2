
package com.mycompany.sistema.bibliotecas.modelo.leerArchivo;

import com.mycompany.sistema.bibliotecas.modelo.Conexion;
import com.mycompany.sistema.bibliotecas.modelo.entidades.Incidencia;
import com.mycompany.sistema.bibliotecas.modelo.entidades.LibrosTransporte;
import com.mycompany.sistema.bibliotecas.modelo.entidades.Prestamo;
import com.mycompany.sistema.bibliotecas.modelo.entidades.TransporteBiblioteca;
import com.mycompany.sistema.bibliotecas.modelo.entidades.TransporteUsuarioFinal;
import com.mycompany.sistema.bibliotecas.modelo.entidades.UsuarioRecepcion;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CrearRecepcion {
    
    public static void registrarRecepcionista(UsuarioRecepcion usuario){
        
        PreparedStatement ps = null;
        String query = "INSERT INTO usuario_recepcion(codigo_usuario_recepcion,nombre,usuario,constrasenia, correo, biblioteca) VALUES (?,?,?,?,?,?)";
        
        try {
            Connection conexion = Conexion.getConnection();
            ps = conexion.prepareStatement(query);
            ps.setInt(1, usuario.getCodigoUsuarioRecepcion());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getUsuario());
            ps.setString(4, usuario.getConstrasenia());
            ps.setString(5, usuario.getCorreo());
            ps.setInt(6, usuario.getBiblioteca());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void registrarPrestamo(Prestamo usuario){
        
        PreparedStatement ps = null;
        String query = "INSERT INTO prestamo(codigo_prestamo,recepcionista,bibloteca"
                + ",usuario, isbn, estado, multa, fecha_prestamo) VALUES (?,?,?,?,?,?,?,?)";
        
        try {
            Connection conexion = Conexion.getConnection();
            ps = conexion.prepareStatement(query);
            ps.setInt(1, usuario.getCodigoPrestamo());
            ps.setInt(2, usuario.getRecepcionista());
            ps.setInt(3, usuario.getBibloteca());
            ps.setInt(4, usuario.getUsuario());
            ps.setInt(5, usuario.getIsbn());
            ps.setString(6, usuario.getEstado());
            ps.setDouble(7, usuario.getMulta());
            ps.setString(8, usuario.getFechaPrestamo());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static boolean registrarTransporteB(TransporteBiblioteca usuario){
        
        PreparedStatement ps = null;
        String query = "INSERT INTO transporte_biblioteca(codigo_transporte_biblioteca,recepcionista,biblioteca_origen"
                + ",biblioteca_destino, transportista, estado, fecha) VALUES (?,?,?,?,?,?,?)";
        
        try {
            Connection conexion = Conexion.getConnection();
            ps = conexion.prepareStatement(query);
            ps.setInt(1, usuario.getCodigoTransporteBi());
            ps.setInt(2, usuario.getRecepcionista());
            ps.setInt(3, usuario.getBibliotecaOrigen());
            ps.setInt(4, usuario.getBibliotecaDestino());
            ps.setInt(5, usuario.getTransportista());
            ps.setString(6, usuario.getEstado());
            ps.setString(7, usuario.getFecha());
            ps.executeUpdate();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void registrarLibrosT(LibrosTransporte bb){
        
        PreparedStatement ps = null;
        String query = "INSERT INTO libros_transporte (codigo_transporteBiblio, isbn, unidades) values (?,?,?)";
        
        try {
            Connection conexion = Conexion.getConnection();
            ps = conexion.prepareStatement(query);
            ps.setInt(1, bb.getCodigoTransporteBiblio());
            ps.setInt(2, bb.getIsbn());
            ps.setInt(3, bb.getUnidades());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    public static void registrarTransporteU(TransporteUsuarioFinal usuario){
        
        PreparedStatement ps = null;
        String query = "INSERT INTO transporte_usuario_final(cdogio_transporte_final,usuario,transportista"
                + ",biblioteca, isbn, estado, fecha) VALUES (?,?,?,?,?,?,?)";
        
        try {
            Connection conexion = Conexion.getConnection();
            ps = conexion.prepareStatement(query);
            ps.setInt(1, usuario.getCodigoTransporteFinal());
            ps.setInt(2, usuario.getUsuario());
            ps.setInt(3, usuario.getTransportista());
            ps.setInt(4, usuario.getBiblioteca());
            ps.setInt(5, usuario.getIsbn());
            ps.setString(6, usuario.getEstado());
            ps.setString(7, usuario.getFecha());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void registrarIncidencia(Incidencia usuario){
        
        PreparedStatement ps = null;
        String query = "INSERT INTO incidencia(codigo_incidencia,prestamo,tipo_incidencia"
                + ",cantidad_pagada) VALUES (?,?,?,?)";
        
        try {
            Connection conexion = Conexion.getConnection();
            ps = conexion.prepareStatement(query);
            ps.setInt(1, usuario.getCodigoIncidencia());
            ps.setInt(2, usuario.getPrestamo());
            ps.setString(3, usuario.getTipoIncidencia());
            ps.setDouble(4, usuario.getCantidadPagada());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
