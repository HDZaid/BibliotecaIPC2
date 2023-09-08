/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.sistema.bibliotecas.controlador.servletUsuarioFinal;

import com.mycompany.sistema.bibliotecas.modelo.conexionesBD.ConexionesUsuarioFinal;
import com.mycompany.sistema.bibliotecas.modelo.entidades.Prestamo;
import com.mycompany.sistema.bibliotecas.modelo.entidades.SolicitudPrestamo;
import com.mycompany.sistema.bibliotecas.modelo.entidades.Usuario;
import com.mycompany.sistema.bibliotecas.modelo.entidades.UsuarioFinal;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "ServletOpcionesUsuarioFinal", urlPatterns = {"/ServletOpcionesUsuarioFinal"})
public class ServletOpcionesUsuarioFinal extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String accion = request.getParameter("accion");
        try {
            if (accion != null) {
                switch (accion) {
                    case "perfil":
                        verPerfil(request, response);
                        break;
                    case "guardarPerfil":
                        guardarPerfil(request, response);
                        break;

                    case "recarga":
                        recargarSaldo(request, response);
                        break;

                    case "prestar":
                        prestarLibro(request, response);
                        break;

                    case "prestamosActivos":
                        verPrestamos(request, response);
                        break;

                    default:
                        response.sendRedirect("vistaUsuarioFinal.jsp");

                }
            } else {
                response.sendRedirect("vistaUsuarioFinal.jsp");
            }
        } catch (Exception e) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void verPerfil(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion = request.getSession();
        Usuario user = (Usuario) sesion.getAttribute("usuario");
        int codigoUsuario = user.getCodigoUsuario();
        
        UsuarioFinal usuario = ConexionesUsuarioFinal.obtenerUsuarioFinal(codigoUsuario);
        
        sesion.setAttribute("perfil", usuario);
        
        response.sendRedirect("moduloUsuarioFinal/perfilUsuarioFinal.jsp");
        
    
    }

    private void guardarPerfil(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion = request.getSession();
        Usuario user = (Usuario) sesion.getAttribute("usuario");
        int codigoUsuario = user.getCodigoUsuario();
        
        String nombre = request.getParameter("nombre") ;
        String nombreUsuario = request.getParameter("nombreUsuario");
        String correo  = request.getParameter("correo");
        System.out.println("Nombre "+nombre);
        
        UsuarioFinal usuarioF= new UsuarioFinal(codigoUsuario, nombre, nombreUsuario, correo);
        
        ConexionesUsuarioFinal.editarPerfil(usuarioF);
        response.sendRedirect("vistaUsuarioFinal.jsp");
    }

    private void recargarSaldo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion = request.getSession();
        Usuario user = (Usuario) sesion.getAttribute("usuario");
        int codigoUsuario = user.getCodigoUsuario();
        
        double saldo = Double.parseDouble(request.getParameter("recarga")) ;
        
        
        ConexionesUsuarioFinal.recargarSaldo(saldo, codigoUsuario);
        response.sendRedirect("vistaUsuarioFinal.jsp");
    }

    private void prestarLibro(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion = request.getSession();
        Usuario user = (Usuario) sesion.getAttribute("usuario");
        int codigoUsuario = user.getCodigoUsuario();
        
        int biblioteca = Integer.parseInt(request.getParameter("biblio")) ;
        int isbn = Integer.parseInt(request.getParameter("isbn")) ;
        String tipoEntrega= request.getParameter("tipoEntrega");
        String estado = "PENDIENTE";
        int recepcionista = ConexionesUsuarioFinal.obtenerRecepcionista(biblioteca);
        LocalDate currentDate = LocalDate.now();
        String fecha = currentDate.toString();
        int transportista = ConexionesUsuarioFinal.obtenerTransportista();
        
        SolicitudPrestamo solicitud = new SolicitudPrestamo(codigoUsuario, recepcionista, biblioteca, transportista, isbn, estado, tipoEntrega, fecha);
        ConexionesUsuarioFinal.crearSolicitudPrestamo(solicitud);
        
        response.sendRedirect("vistaUsuarioFinal.jsp");
    }

    private void verPrestamos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion = request.getSession();
        Usuario user = (Usuario) sesion.getAttribute("usuario");
        int codigoUsuario = user.getCodigoUsuario();
        
        
        List<Prestamo> prestamos = ConexionesUsuarioFinal.obtenerSolicitudes(codigoUsuario);
        
        sesion.setAttribute("prestamos", prestamos);
        
        response.sendRedirect("moduloUsuarioFinal/prestamosActivos.jsp");
        
    }

}
