

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Usuario Recepcionista</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    </head>
    <body>
       
        <div class="navbar navbar-expand-lg navbar-light bg-light">
            
            
            <button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasScrolling" aria-controls="offcanvasScrolling">Opciones</button>

            <!-- Contenido principal -->
            <div class="container mt-5">
                <!-- Agrega la imagen de libros -->
                <h1>Usuario Recepcionista</h1>

            </div>
        </div>

        <div class="offcanvas offcanvas-start" data-bs-scroll="true" data-bs-backdrop="false" tabindex="-1" id="offcanvasScrolling" aria-labelledby="offcanvasScrollingLabel">
            <div class="offcanvas-header">
                <h5 class="offcanvas-title" id="offcanvasScrollingLabel">Menu</h5>
                <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <div class="offcanvas-body">
                <ul class="list-group">
                    <li class="list-group-item"><a href="${pageContext.request.contextPath}/moduloRecepcion/crearUsuario.jsp">Crear Usuario</a></li>
                    <li class="list-group-item"><a href="${pageContext.request.contextPath}/ServletOpcionesRecepcion?accion=solicitud">Solicitud de Prestamo</a></li>
                    <li class="list-group-item"><a href="${pageContext.request.contextPath}/ServletLoginUsuario?accion=cerrar">Cerrar cesion</a></li>
                </ul>
            </div>
        </div>

                    <div class="container mt-5">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="card">
                                        <div class="card-header">
                                            <h4>Listado de libros</h4>
                                        </div>
                                        <table class="table table-striped">
                                            <thead class="thead-dark">
                                                <tr>
                                                    <th>#</th>
                                                    <th>ISBN</th>
                                                    <th>Existencias</th>
                                                    <th>Nombre</th>
                                                    <th>Autor</th>
                                                    <th>Descripcion</th>
                                                    <th>Usuario a Prestar</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <!-- Iteramos cada elemento de la lista de productos -->
                                            <c:forEach var="librosB" items="${librosB}" varStatus="status" >
                                                <tr>
                                                    <td>${status.count}</td>
                                                    <td>${librosB.isbn}</td>
                                                    <td>${librosB.existencias}</td>
                                                    <td>${librosB.nombreLibro}</td>
                                                    <td>${librosB.autor}</td>
                                                    <td>${librosB.descripcion}</td>
                                                    <td>
                                                        <!-- Agrega un input numérico para ingresar el ID del usuario a prestar -->
                                                        <input type="number" id="usuarioAPrestar${status.index}" name="usuarioAPrestar" min="1" required>
                                                    </td>
                                                    <td>
                                                        <a href="#" onclick="prestarLibro('${librosB.isbn}', '${status.index}')" class="btn btn-secondary">
                                                            <i class="fas fa-angle-double-right"></i> Realizar Prestamo
                                                        </a>
                                                    </td>
                                                </tr>
                                            </c:forEach>

                                            <script>
function prestarLibro(isbn, index) {
var usuarioPrestamo = document.getElementById('usuarioAPrestar' + index).value;
var url = '${pageContext.request.contextPath}/ServletOpcionesRecepcion?accion=prestar&isbn=' + isbn + '&usuario=' + usuarioPrestamo;
window.location.href = url;
}
                                            </script>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                            </div>

                        </div>
</div>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

    </body>
</html>