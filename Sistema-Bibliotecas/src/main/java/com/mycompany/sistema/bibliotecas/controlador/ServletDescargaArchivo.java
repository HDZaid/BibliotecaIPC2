
package com.mycompany.sistema.bibliotecas.controlador;

import com.mycompany.sistema.bibliotecas.modelo.LeerJSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@WebServlet(name = "ServletDescargaArchivo", urlPatterns = {"/ServletDescargaArchivo"})
@MultipartConfig
public class ServletDescargaArchivo extends HttpServlet {

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Part filePart = request.getPart("archivo");
        String inputFileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        guardarArchivo(filePart, inputFileName);
        
        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    private void guardarArchivo(Part filePart, String nombreArchivo){
        String sistemaOperativo = System.getProperty("os.name").toLowerCase();
        String rutaTemporal;

        if (sistemaOperativo.contains("win")) {
            rutaTemporal = System.getProperty("java.io.tmpdir");
        } else {
            rutaTemporal = "/tmp";
        }

        File ruta = new File(rutaTemporal);
        File file = new File(ruta, nombreArchivo);

        try (InputStream input = filePart.getInputStream()) {
            Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            LeerJSON.leerArchivo(nombreArchivo);
            
            System.out.println("Archivo " + nombreArchivo + " guardado en " + ruta.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

}
