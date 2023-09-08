
package com.mycompany.sistema.bibliotecas.controlador;

import com.mycompany.sistema.bibliotecas.modelo.ValidarUsuario;
import com.mycompany.sistema.bibliotecas.modelo.conexionesBD.ConexionesRecepcionista;
import com.mycompany.sistema.bibliotecas.modelo.conexionesBD.ConexionesUsuarioFinal;
import com.mycompany.sistema.bibliotecas.modelo.entidades.LibrosTotal;
import com.mycompany.sistema.bibliotecas.modelo.entidades.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletLoginUsuario", urlPatterns = {"/ServletLoginUsuario"})
public class ServletLoginUsuario extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String accion = request.getParameter("accion");
        
        try {
            if(accion!=null){
                switch(accion){
                    case "verificar":
                        verificar(request, response);
                        break;
                    case "cerrar":
                        cerrarSesion(request, response);
                    default:
                        response.sendRedirect("index.jsp");
                        
                }
            }else{
                response.sendRedirect("index.jsp");
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
    
     private void verificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion;
        ValidarUsuario validacion = new ValidarUsuario();
        Usuario usuario;
        
        //String contraseñaCifrada = CifrarContraseña.hash(request.getParameter("contraseña"));
        
        usuario = validacion.validarUsuario(request.getParameter("usuario"), request.getParameter("contraseña") );
        
        if(usuario != null && usuario.getCargo().equals("ADMIN")){
            sesion = request.getSession();
            sesion.setAttribute("usuario", usuario);
            response.sendRedirect("vistaUsuarioAdmin.jsp");
            
        }else if(usuario != null && usuario.getCargo().equals("RECEPCION")){
            sesion = request.getSession();
            sesion.setAttribute("usuario", usuario);
            //AGREGAR LIBROS DE LA BIBLIOTECA
            List<LibrosTotal> libros = ConexionesRecepcionista.obtenerLibros(usuario.getBiblioteca());
            sesion.setAttribute("librosB", libros);
            response.sendRedirect("vistaUsuarioRecepcion.jsp");
            
        }else if(usuario != null && usuario.getCargo().equals("FINAL")){
            sesion = request.getSession();
            sesion.setAttribute("usuario", usuario);
            //AGREGAR LOS LIBROS
            List<LibrosTotal> libros = ConexionesUsuarioFinal.obtenerLibros();
            sesion.setAttribute("libros", libros);
            response.sendRedirect("vistaUsuarioFinal.jsp");
        }else if(usuario != null && usuario.getCargo().equals("TRANSPORTE")){
            sesion = request.getSession();
            sesion.setAttribute("usuario", usuario);
            response.sendRedirect("vistaUsuarioTransporte.jsp");
            
        }else{
            request.setAttribute("error", "No se pudo iniciar sesion");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
    }

    private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuario", null);
        sesion.invalidate();
        response.sendRedirect("index.jsp");
    }

}
