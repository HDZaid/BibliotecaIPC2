
package com.mycompany.sistema.bibliotecas.modelo;

import com.mycompany.sistema.bibliotecas.modelo.entidades.*;
import com.mycompany.sistema.bibliotecas.modelo.leerArchivo.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LeerJSON {
    
    public static void leerArchivo(String nombreArchivo){
        
        JSONParser jsonParser = new JSONParser();

        String sistemaOperativo = System.getProperty("os.name").toLowerCase();
        String rutaTemporal;

        if (sistemaOperativo.contains("win")) {
            rutaTemporal = System.getProperty("java.io.tmpdir");
        } else {
            rutaTemporal = "/tmp";
        }

        String rutaArchivo = rutaTemporal + File.separator + nombreArchivo;


        try (FileReader reader = new FileReader(rutaArchivo)) {
            Object obj = jsonParser.parse(reader);

            leerCategoria((JSONObject) obj);
            leerLibros((JSONObject) obj);
            leerBibliotecas((JSONObject) obj);
            leerAdmins((JSONObject) obj);
            leerRecepcionista((JSONObject) obj);
            leerTransportista((JSONObject) obj);
            leerUsuarioFinal((JSONObject) obj);
            leerSolicitudesPrestamo((JSONObject) obj);
            leerPrestamos((JSONObject) obj);
            leerTransporteB((JSONObject) obj);
            leerTransporteU((JSONObject) obj);
            leerIncidencias((JSONObject) obj);
            leerRevocacion((JSONObject) obj);
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
    }
    
    private static void leerCategoria(JSONObject jsonObject){
        JSONArray categorias = (JSONArray) jsonObject.get("categorias");
        
        for(Object categoria: categorias){
            JSONObject ca = (JSONObject) categoria;
            int codigo = Integer.parseInt(String.valueOf(ca.get("codigo")));
            String nombre = String.valueOf(ca.get("nombre"));
            String descripcion = String.valueOf(ca.get("descripcion"));
            
            Categoria categoria1 = new  Categoria(codigo, nombre, descripcion);
            CrearCategoria.registrarCategoria(categoria1);
        }
    }
    
    private static void leerLibros(JSONObject jsonObject){
        JSONArray libros = (JSONArray) jsonObject.get("libros");
        
        for(Object libro: libros){
            JSONObject lb = (JSONObject) libro;
            int isbn = Integer.parseInt(String.valueOf(lb.get("isbn")));
            String nombre = String.valueOf(lb.get("nombre"));
            double costo = Double.parseDouble(String.valueOf(lb.get("costo")));
            int categoria = Integer.parseInt(String.valueOf(lb.get("categoria")));
            String autor = String.valueOf(lb.get("autor"));
            
            Libro libro1 = new  Libro(isbn, nombre, autor, categoria, costo);
            CrearLibro.registrarLibro(libro1);
        }
    }
    
    private static void leerBibliotecas(JSONObject jsonObject){
        JSONArray bibliotecas = (JSONArray) jsonObject.get("bibliotecas");
        
        for(Object biblioteca: bibliotecas){
            JSONObject b = (JSONObject) biblioteca;
            
            int codigo = Integer.parseInt(String.valueOf(b.get("codigo")));
            String nombre = String.valueOf(b.get("nombre"));
            String direccion = String.valueOf(b.get("direccion"));
            
            Biblioteca biblioteca1 = new Biblioteca(codigo, nombre, direccion);
            boolean realizado = CrearBiblioteca.registrarBiblioteca(biblioteca1);
            
            if (realizado) {

                JSONArray libros = (JSONArray) b.get("libros");
                for (Object libro : libros) {
                    JSONObject p = (JSONObject) libro;
                    int isbn = Integer.parseInt(String.valueOf(p.get("isbn")));
                    int existencias = Integer.parseInt(String.valueOf(p.get("existencias")));
                    
                    LibrosBiblioteca librosBB = new LibrosBiblioteca(codigo, existencias, isbn);
                    CrearBiblioteca.registrarLibroBiblioteca(librosBB);
                    
                }
            }else{
                System.out.println("Error");
            }
            
        }
    }
    
    private static void leerAdmins(JSONObject jsonObject) {
        //JSONArray admins = (JSONArray) jsonObject.get("admin");
        
        //for(Object admin: admins){
            JSONObject ad = (JSONObject) jsonObject.get("admin");
            
            int codigo = Integer.parseInt(String.valueOf(ad.get("codigo")));
            String nombre = String.valueOf(ad.get("nombre"));
            String usuario = String.valueOf(ad.get("username"));
            String contraseña = String.valueOf(ad.get("password"));
            String correo = String.valueOf(ad.get("email"));
            
            UsuarioAdmin admin1 = new UsuarioAdmin(codigo, nombre, usuario, contraseña, correo);
            CrearAdmin.registrarAdmin(admin1);
            
        //}
    }
    
    private static void leerRecepcionista(JSONObject jsonObject) {
        JSONArray recepcion = (JSONArray) jsonObject.get("usuariosRecepcion");
        
        for(Object recepcionista: recepcion){
            JSONObject ad = (JSONObject) recepcionista;
            
            int codigo = Integer.parseInt(String.valueOf(ad.get("codigo")));
            String nombre = String.valueOf(ad.get("nombre"));
            String usuario = String.valueOf(ad.get("username"));
            String contraseña = String.valueOf(ad.get("password"));
            String correo = String.valueOf(ad.get("email"));
            int biblioteca = Integer.parseInt(String.valueOf(ad.get("biblioteca")));
            
            UsuarioRecepcion usuarioR = new UsuarioRecepcion(codigo, nombre, usuario, contraseña, correo, biblioteca);
            CrearRecepcion.registrarRecepcionista(usuarioR);
            
        }
    }
    
    private static void leerTransportista(JSONObject jsonObject) {
        JSONArray transportistas = (JSONArray) jsonObject.get("usuariosTransporte");
        
        for(Object transportista: transportistas){
            JSONObject ad = (JSONObject) transportista;
            
            int codigo = Integer.parseInt(String.valueOf(ad.get("codigo")));
            String nombre = String.valueOf(ad.get("nombre"));
            String usuario = String.valueOf(ad.get("username"));
            String contraseña = String.valueOf(ad.get("password"));
            String correo = String.valueOf(ad.get("email"));
            
            UsuarioTransporte usuarioT = new UsuarioTransporte(codigo, nombre, usuario, contraseña, correo);
            CrearTransportista.registrarTransportista(usuarioT);
            
        }
    }
    
    private static void leerUsuarioFinal(JSONObject jsonObject) {
        JSONArray usuariosF = (JSONArray) jsonObject.get("usuarios");
        
        for(Object usuarioF: usuariosF){
            JSONObject ad = (JSONObject) usuarioF;
            
            int codigo = Integer.parseInt(String.valueOf(ad.get("codigo")));
            String nombre = String.valueOf(ad.get("nombre"));
            String usuario = String.valueOf(ad.get("username"));
            String contraseña = String.valueOf(ad.get("password"));
            String correo = String.valueOf(ad.get("email"));
            double saldo = Double.parseDouble(String.valueOf(ad.get("saldoInicial")));
            
            UsuarioFinal usF = new UsuarioFinal(codigo, nombre, usuario, contraseña, correo, saldo);
            CrearUsuarioFinal.registrarUsuarioFinal(usF);
            
        }
    }
    
    private static void leerSolicitudesPrestamo(JSONObject jsonObject) {
        JSONArray solicitudesP = (JSONArray) jsonObject.get("solicitudesPrestamo");
        
        for(Object solicitudP: solicitudesP){
            JSONObject ad = (JSONObject) solicitudP;
            
            int codigo = Integer.parseInt(String.valueOf(ad.get("codigo")));
            int biblioteca = Integer.parseInt(String.valueOf(ad.get("biblioteca")));
            int recepcionista = Integer.parseInt(String.valueOf(ad.get("recepcionista")));
            int usuario = Integer.parseInt(String.valueOf(ad.get("usuario")));
            int isbn = Integer.parseInt(String.valueOf(ad.get("isbn")));
            String fecha = String.valueOf(ad.get("fecha"));
            String estado = String.valueOf(ad.get("estado"));
            String tipoEntrega = String.valueOf(ad.get("tipoEntrega"));
            int transportista;
            if(tipoEntrega.equals("DOMICILIO")){
                 transportista = Integer.parseInt(String.valueOf(ad.get("transportista")));
            }else{
                transportista = 0;
            }
            
            SolicitudPrestamo sp = new SolicitudPrestamo(codigo, usuario, recepcionista, biblioteca, transportista, isbn, estado, tipoEntrega, fecha);
            CrearUsuarioFinal.registrarSolicitudPrestamo(sp);
            
        }
    }
    
    private static void leerPrestamos(JSONObject jsonObject) {
        JSONArray prestamos = (JSONArray) jsonObject.get("prestamos");
        
        for(Object prestamo: prestamos){
            JSONObject ad = (JSONObject) prestamo;
            int codigo = Integer.parseInt(String.valueOf(ad.get("codigo")));
            int biblioteca = Integer.parseInt(String.valueOf(ad.get("biblioteca")));
            int recepcionista = Integer.parseInt(String.valueOf(ad.get("recepcionista")));
            int usuario = Integer.parseInt(String.valueOf(ad.get("usuario")));
            int isbn = Integer.parseInt(String.valueOf(ad.get("isbn")));
            String fecha = String.valueOf(ad.get("fecha"));
            String estado = String.valueOf(ad.get("estado"));
            double multa = Double.parseDouble(String.valueOf(ad.get("multa")));
            
           Prestamo pm = new Prestamo(codigo, recepcionista, biblioteca, usuario, isbn, estado, multa, fecha);
           CrearRecepcion.registrarPrestamo(pm);
        }
    }
    
    private static void leerTransporteB(JSONObject jsonObject){
        JSONArray transportesB = (JSONArray) jsonObject.get("transportesB");
        
        for(Object transporteB: transportesB){
            JSONObject b = (JSONObject) transporteB;
            
            
            int codigo = Integer.parseInt(String.valueOf(b.get("codigo")));
            int bibliotecaOrigen = Integer.parseInt(String.valueOf(b.get("bibliotecaOrigen")));
            int bibliotecaDestino = Integer.parseInt(String.valueOf(b.get("bibliotecaDestino")));
            int recepcionista = Integer.parseInt(String.valueOf(b.get("recepcionista")));
            int transportista = Integer.parseInt(String.valueOf(b.get("transportista")));
            String fecha = String.valueOf(b.get("fecha"));
            String estado = String.valueOf(b.get("estado"));
            
            TransporteBiblioteca transporte = new TransporteBiblioteca(codigo, recepcionista, bibliotecaOrigen, bibliotecaDestino, transportista, estado, fecha);
            boolean realizado = CrearRecepcion.registrarTransporteB(transporte);
            
            if (realizado) {

                JSONArray libros = (JSONArray) b.get("detalle");
                for (Object libro : libros) {
                    JSONObject p = (JSONObject) libro;
                    int isbn = Integer.parseInt(String.valueOf(p.get("isbn")));
                    int unidades = Integer.parseInt(String.valueOf(p.get("unidades")));
                    
                    LibrosTransporte librosBB = new LibrosTransporte(codigo, isbn, unidades);
                    CrearRecepcion.registrarLibrosT(librosBB);
                    
                }
            }else{
                System.out.println("Error");
            }
            
        }
    }
    
    private static void leerTransporteU(JSONObject jsonObject){
        JSONArray transportesB = (JSONArray) jsonObject.get("transportesU");
        
        for(Object transporteB: transportesB){
            JSONObject b = (JSONObject) transporteB;
            
           
            int codigo = Integer.parseInt(String.valueOf(b.get("codigo")));
            int biblioteca = Integer.parseInt(String.valueOf(b.get("biblioteca")));
            int usuario = Integer.parseInt(String.valueOf(b.get("usuario")));
            int transportista = Integer.parseInt(String.valueOf(b.get("transportista")));
            String fecha = String.valueOf(b.get("fecha"));
            String estado = String.valueOf(b.get("estado"));
            int isbn = Integer.parseInt(String.valueOf(b.get("isbn")));
            
            TransporteUsuarioFinal tu= new TransporteUsuarioFinal(codigo, usuario, transportista, biblioteca, isbn, estado, fecha);
            CrearRecepcion.registrarTransporteU(tu);
        }
    }
    
    private static void leerIncidencias(JSONObject jsonObject){
        JSONArray incidencias = (JSONArray) jsonObject.get("incidencias");
        
        for(Object incidencia: incidencias){
            JSONObject ca = (JSONObject) incidencia;
            
            int codigo = Integer.parseInt(String.valueOf(ca.get("codigo")));
            int prestamo = Integer.parseInt(String.valueOf(ca.get("prestamo")));
            String tipo = String.valueOf(ca.get("tipo"));
            double cantidadPagada = Double.parseDouble(String.valueOf(ca.get("cantidadPagada")));
            
            Incidencia in = new Incidencia(codigo, prestamo, tipo, cantidadPagada);
            CrearRecepcion.registrarIncidencia(in);
            
        }
    }
    
    private static void leerRevocacion(JSONObject jsonObject){
        JSONArray revocaciones = (JSONArray) jsonObject.get("solicitudesRevocacion");
        
        for(Object revocacione: revocaciones){
            JSONObject ca = (JSONObject) revocacione;
            
            int codigo = Integer.parseInt(String.valueOf(ca.get("codigo")));
            int usuario = Integer.parseInt(String.valueOf(ca.get("usuario")));
            String estado = String.valueOf(ca.get("estado"));
            String detalle = String.valueOf(ca.get("detalle"));
            
            Revocacion rv = new Revocacion(codigo, usuario, detalle, estado);
            CrearUsuarioFinal.registrarRevocacion(rv);
            
        }
    }
    
}
