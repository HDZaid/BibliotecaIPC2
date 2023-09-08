
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil de usuario</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    </head>
    <body>
        <div class="container mt-5">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <h1 class="text-center"><i class="fas fa-user-circle"></i>Perfil de Usuario</h1>
                <div class="card">
                    <div class="card-body">
                        <form action="${pageContext.request.contextPath}/ServletOpcionesUsuarioFinal?accion=guardarPerfil" method="POST">
                            <div class="mb-3">
                                <label for="nombre" class="form-label">Nombre:</label>
                                <input type="text" class="form-control" id="nombre" name="nombre" value="${perfil.nombre}">
                            </div>
                            <div class="mb-3">
                                <label for="nombreUsuario" class="form-label">Nombre de Usuario:</label>
                                <input type="text" class="form-control" id="nombreUsuario" name="nombreUsuario" value="${perfil.nombreUsuario}">
                            </div>
                            <div class="mb-3">
                                <label for="correo" class="form-label">Correo Electrónico:</label>
                                <input type="email" class="form-control" id="correo" name="correo" value="${perfil.correo}">
                            </div>
                            <div class="mb-3">
                                <label for="saldo" class="form-label">Saldo:</label>
                                <input type="number" class="form-control" id="saldo" name="saldo" value="${perfil.saldo}" readonly>
                            </div>
                            <button type="submit" class="btn btn-primary">Guardar Cambios</button>
                        </form>
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
