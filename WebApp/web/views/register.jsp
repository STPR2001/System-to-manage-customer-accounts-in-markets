<%-- 
    Document   : register
    Created on : 11 oct. 2023, 19:02:10
    Author     : marty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="css/globals.css" type="text/css" />
<head>
    <title>WebApp - Registrarse</title>
</head>
<body>
    <jsp:include page="components/Navbar.jsp" />
    <h1 style="margin: 20px">Registrarse en Web App</h1>
    <form action="register" method="POST">
        <label for="mail">Ingrese su mail:</label>
        <input type="text" id="correo" name="correo" required><br><br>

        <label for="name">Ingrese su nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br><br>

        <label for="address">Ingrese su dirección:</label>
        <input type="text" id="direccion" name="direccion" required><br><br>

        
        <label for="pwd">Ingrese una contraseña:</label>
        <input type="password" id="contrasena" name="contrasena" required><br><br>

        <label for="pwd_confirm">Confirmar Contraseña:</label>
        <input type="password" id="confirmar_contrasena" name="confirmar_contrasena" required><br><br>

        <div id="error_contrasena" style="color: red; display: none;">Las contraseñas no coinciden.</div>

        <input type="submit" value="Registrarse">
    </form>

</body>
</html>

<style>
    
    
    form{
        margin: 20px;
    }
</style>






<!--
    <script>
        document.querySelector("form").addEventListener("submit", function(event) {
            var contrasena = document.getElementById("pwd").value;
            var confirmarContrasena = document.getElementById("pwd_confirm").value;

            if (contrasena !== confirmarContrasena) {
                document.getElementById("error_contrasena").style.display = "block";
                event.preventDefault();
            }
            
            
            
            
        });
    </script>
    -->
    