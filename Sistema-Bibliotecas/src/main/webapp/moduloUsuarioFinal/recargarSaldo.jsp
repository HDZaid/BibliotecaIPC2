
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recargar Saldo</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

    </head>
    <body>
        <header id="main-header" class="py-2 bg-primary text-white">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <h1>Recargar Saldo</h1>
                    </div>
                </div>
            </div>
        </header>
        
        <div class="container my-5">

            <form action="${pageContext.request.contextPath}/ServletOpcionesUsuarioFinal?accion=recarga" method="POST"">

                <div class="input-group flex-nowrap mt-3">
                    <span class="input-group-text" id="addon-wrapping">Saldo a Recargar</span>
                    <input type="number" name="recarga" class="form-control" placeholder="0.00" aria-label="Username" aria-describedby="addon-wrapping"
                           requerid>
                </div>

                <div class="d-grid gap-2 d-md-flex justify-content-md-end mt-3">
                    <button class="btn btn-primary" type="submit" >Realizar recarga</button>
                </div>

            </form>

        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

    </body>
</html>
