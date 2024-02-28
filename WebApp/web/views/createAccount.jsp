    <%-- 
   int organizationId, int userId, String limit_amount, String password
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/globals.css" type="text/css" />
        <title>WebApp - Crear Cuenta</title>
    </head>
    <body>
        <jsp:include page="components/Navbar.jsp" />
        <h1 style="margin: 20px">Crear nueva cuenta</h1>
        <form action="createAccount" method="POST">
            
        <label for="orgIdLabel">Ingrese el id de organización:</label><%-- Ésto hay que calcularlo automáticamente, basado en qué organización se seleccionó --%>
        <input type="text" id="orgId" name="orgId" required><br><br>
        
        <label for="userIdLabel">Ingrese el id del usuario:</label><%-- Ésto hay que calcularlo automáticamente, basado en qué organización se seleccionó --%>
        <input type="text" id="userId" name="userId" required><br><br>

        <label for="Label">Ingrese el límite de la cuenta: $</label><%-- Ésto hay que calcularlo automáticamente, basado en qué organización se seleccionó --%>
        <input type="text" id="limitAmount" name="limitAmount" required><br><br>
        
        <label for="pwd">Ingrese una contraseña:</label>
        <input type="password" id="contrasena" name="contrasena" required><br><br>

        <label for="pwd_confirm">Confirmar Contraseña:</label>
        <input type="password" id="confirmar_contrasena" name="confirmar_contrasena" required><br><br>

        <div id="error_contrasena" style="color: red; display: none;">Las contraseñas no coinciden.</div>

        <input type="submit" value="Crear cuenta">
    </form>
    </body>
</html>

<style>
    
    
    form{
        margin: 20px;
    }
</style>
