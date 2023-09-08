
<nav class="navbar bg-primary" data-bs-theme="dark">
    <div class="container">
        <h3>Bienvenido ${usuario.nombre}</h3>
            
        <nav class="navbar">
            <div class="container-fluid">
                <div class="justify-content-end">
                    <a class="navbar-brand btn btn-outline-success" href="${pageContext.request.contextPath}/ServletLoginUsuario?accion=cerrar">Cerrar Sesion</a>
                </div>
            </div>
        </nav>
    </div>
</nav>
