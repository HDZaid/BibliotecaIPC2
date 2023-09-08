/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.sistema.bibliotecas.controlador.servletUsuarioRecepcionista;

import com.mycompany.sistema.bibliotecas.modelo.conexionesBD.ConexionesRecepcionista;
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

@WebServlet(name = "ServletOpcionesRecepcion", urlPatterns = {"/ServletOpcionesRecepcion"})
public class ServletOpcionesRecepcion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String accion = request.getParameter("accion");
        try {
            if (accion != null) {
                switch (accion) {
                    case "crearUsuario":
                        crearUsuario(request, response);
                        break;
                    case "prestar":
                        realizarPrestamo(request, response);
                        break;

                    case "solicitud":
                        solicitudPrestamo(request, response);
                        break;

                    case "aceptar":
                        aceptarPrestamo(request, response);
                        break;

                    case "reportes":
                        //iniciarReportes(request, response);
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

    private void crearUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion = request.getSession();
        Usuario user = (Usuario) sesion.getAttribute("usuario");
        int codigoUsuario = user.getCodigoUsuario();
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        String nombre = request.getParameter("nombre") ;
        String nombreUsuario = request.getParameter("nombreUsuario");
        String contraseña = request.getParameter("contraseña");
        String correo  = request.getParameter("correo");
        
        UsuarioFinal usuarioF= new UsuarioFinal(idUsuario, nombre, nombreUsuario, contraseña, correo, 0, 0);
        
        ConexionesRecepcionista.registrarUsuarioFinal(usuarioF);
        
        response.sendRedirect("vistaUsuarioRecepcion.jsp");
    }

    private void realizarPrestamo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion = request.getSession();
        Usuario user = (Usuario) sesion.getAttribute("usuario");
        int codigoUsuario = user.getCodigoUsuario();
        int biblioteca = user.getBiblioteca();
        
        int isbn = Integer.parseInt(request.getParameter("isbn")) ;
        int usuario = Integer.parseInt(request.getParameter("usuario")) ;
        String estado = "ACTIVO";
        
        LocalDate currentDate = LocalDate.now();
        String fechaPrestamo = currentDate.toString();
        LocalDate fechaFutura = currentDate.plusDays(8);
        String fechaDevolucion = fechaFutura.toString();
        
        Prestamo pr = new Prestamo(codigoUsuario, biblioteca, usuario, isbn, estado, 0, fechaPrestamo, fechaDevolucion);
        ConexionesRecepcionista.registrarPrestamo(pr);
        response.sendRedirect("vistaUsuarioRecepcion.jsp");
    }

    private void solicitudPrestamo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion = request.getSession();
        Usuario user = (Usuario) sesion.getAttribute("usuario");
        int codigoUsuario = user.getCodigoUsuario();
        int biblioteca = user.getBiblioteca();
        
        List<SolicitudPrestamo> prestamos = ConexionesRecepcionista.obtenerSolicitudes(biblioteca);
        
        sesion.setAttribute("prestamos", prestamos);
        
        response.sendRedirect("moduloRecepcion/solicitudPrestamo.jsp");
        
    }

    private void aceptarPrestamo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion = request.getSession();
        Usuario user = (Usuario) sesion.getAttribute("usuario");
        int codigoUsuario = user.getCodigoUsuario();
        int biblioteca = user.getBiblioteca();
        
        int codigoSolicitud= Integer.parseInt(request.getParameter("codigo"));
        int usuario = Integer.parseInt(request.getParameter("usuario"));
        int isbn = Integer.parseInt(request.getParameter("isbn")) ;
        String estado = "ACTIVO";
        
        LocalDate currentDate = LocalDate.now();
        String fechaPrestamo = currentDate.toString();
        LocalDate fechaFutura = currentDate.plusDays(8);
        String fechaDevolucion = fechaFutura.toString();
        
        Prestamo pr = new Prestamo(codigoUsuario, biblioteca, usuario, isbn, estado, 0, fechaPrestamo, fechaDevolucion);
        ConexionesRecepcionista.registrarPrestamo(pr);
        ConexionesRecepcionista.editarSolicitud(codigoSolicitud);
        response.sendRedirect("vistaUsuarioRecepcion.jsp");
    }

}
