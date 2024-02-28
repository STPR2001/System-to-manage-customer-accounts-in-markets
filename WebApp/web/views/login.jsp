<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/globals.css">
        <link rel="stylesheet" type="text/css" href="css/login.css">
        <title>WebApp - Login</title>
    </head>
    <body>
        <jsp:include page="./components/Navbar.jsp" />
        <section id="login-section">
            <h1>Iniciar sesión</h1>
            <form class="form" action="login" method="POST">
                <div style="display: flex; flex-direction: column; gap: 10px">
                    <label style="padding-left: 15px" for="email">Email</label>
                    <input placeholder="ejemplo@gmail.com" type="text" id="email" name="email" required>
                </div>
                <div style="display: flex; flex-direction: column; gap: 10px">
                    <label style="padding-left: 15px" for="password">Contraseña</label>
                    <input placeholder="Contraseña" type="text" name="password" required>
                </div>
                <a href="/Home/register">
                    ¿No tienes cuenta?
                </a>
                <button type="submit" class="btn">
                    Ingresar
                </button>
                <%
                    String error = (String) request.getAttribute("error");
                    if (error != null) {
                %>
                <span style="color: crimson">
                    <%= error%>
                </span>
                <% }%>
            </form>
        </section>
    </body>
</html>
