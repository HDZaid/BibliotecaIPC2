
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prestamos Activos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    </head>
    <body>
         <div class="container mt-5">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="card">
                                        <div class="card-header">
                                            <h4>Prestamos Activos</h4>
                                        </div>
                                        <table class="table table-striped">
                                            <thead class="thead-dark">
                                                <tr>
                                                    <th>#</th>
                                                    <th>Biblioteca</th>
                                                    <th>Recepcionista</th>
                                                    <th>Usuario</th>
                                                    <th>ISBN</th>
                                                    <th>Fecha Prestamo</th>
                                                    <th>Fecha Devolucion</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <!-- Iteramos cada elemento de la lista de productos -->
                                            <c:forEach var="prestamos" items="${prestamos}" varStatus="status" >
                                                <tr>
                                                    <td>${status.count}</td>
                                                    <td>${prestamos.bibloteca}</td>
                                                    <td>${prestamos.recepcionista}</td>
                                                    <td>${prestamos.usuario}</td>
                                                    <td>${prestamos.isbn}</td>
                                                    <td>${prestamos.fechaPrestamo}</td>
                                                    <td>${prestamos.fechaDevolucion}</td>
                                                    
                                                </tr>
                                            </c:forEach>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                            </div>

                        </div>
</div>
        
        <div class="col-md-3 justify-content-md-end">
            <a href="${pageContext.request.contextPath}/vistaUsuarioFinal.jsp" class="btn btn-danger btn-block">
                Regresar
            </a>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

    </body>
</html>
