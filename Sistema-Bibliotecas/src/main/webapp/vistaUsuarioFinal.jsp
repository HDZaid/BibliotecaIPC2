
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Usuario Final</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    </head>
    <body>
       
        <div class="navbar navbar-expand-lg navbar-light bg-light">
            
            
            <button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasScrolling" aria-controls="offcanvasScrolling">Opciones</button>

            <!-- Contenido principal -->
            <div class="container mt-5">
                <!-- Agrega la imagen de libros -->
                <h1>Usuario Final</h1>

            </div>
        </div>
        

        <div class="offcanvas offcanvas-start" data-bs-scroll="true" data-bs-backdrop="false" tabindex="-1" id="offcanvasScrolling" aria-labelledby="offcanvasScrollingLabel">
            <div class="offcanvas-header">
                <h5 class="offcanvas-title" id="offcanvasScrollingLabel">Menu</h5>
                <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <div class="offcanvas-body">
                <ul class="list-group">
                    <li class="list-group-item"><a href="${pageContext.request.contextPath}/ServletOpcionesUsuarioFinal?accion=perfil">Perfil</a></li>
                    <li class="list-group-item"><a href="${pageContext.request.contextPath}/moduloUsuarioFinal/recargarSaldo.jsp">Saldo</a></li>                   
                    <li class="list-group-item"><a href="${pageContext.request.contextPath}/ServletOpcionesUsuarioFinal?accion=prestamosActivos">Prestamos activos</a></li>
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
                                                    <th>Biblioteca</th>
                                                    <th>ISBN</th>
                                                    <th>Existencias</th>
                                                    <th>Nombre</th>
                                                    <th>Autor</th>
                                                    <th>Descripcion</th>
                                                    <th>Tipo Entrega</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <!-- Iteramos cada elemento de la lista de productos -->
                                            <c:forEach var="libros" items="${libros}" varStatus="status" >
                                                <tr>
                                                    <td>${status.count}</td>
                                                    <td>${libros.biblioteca}</td>
                                                    <td>${libros.isbn}</td>
                                                    <td>${libros.existencias}</td>
                                                    <td>${libros.nombreLibro}</td>
                                                    <td>${libros.autor}</td>
                                                    <td>${libros.descripcion}</td>
                                                    <td>
                                                        <select name="tipoEntrega" id="tipoEntrega${status.index}">
                                                            <option value="DOMICILIO">Domicilio</option>
                                                            <option value="RECEPCION">Recepción</option>
                                                        </select>
                                                    </td>
                                                    <td>
                                                        <a href="#" onclick="prestarLibro('${libros.biblioteca}', '${libros.isbn}', '${status.index}')" class="btn btn-secondary">
                                                            <i class="fas fa-angle-double-right"></i> Prestar Libro
                                                        </a>
                                                    </td>
                                                </tr>
                                            </c:forEach>

                                            <script>
function prestarLibro(biblioteca, isbn, index) {
var tipoEntrega = document.getElementById('tipoEntrega' + index).value;
var url = '${pageContext.request.contextPath}/ServletOpcionesUsuarioFinal?accion=prestar&biblio=' + biblioteca + '&isbn=' + isbn + '&tipoEntrega=' + tipoEntrega;
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
