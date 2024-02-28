<%@page import="logic.classes.Organization"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/globals.css">
        <link rel="stylesheet" type="text/css" href="css/home.css">
        <title>Gestión de Cuentas Fiadas</title>
    </head>
    <body>
        <jsp:include page="components/Navbar.jsp" />
        <div class="container">            
            <h1>Gestión de Cuentas Fiadas</h1>
            <p>Una solución eficiente para administrar cuentas fiadas en tu negocio.</p>

            <div class="btn-container">
                <a href ="organizations" class="btn">Ver Negocios</a>
                <a href="#" class="btn">Solicitar Software</a>
            </div>
            <h2 style="margin-top: 12px">Negocios nuevos</h2>
            <div class="business-container">
                <%
                    ArrayList<Organization> allOrganizations = (ArrayList) request.getAttribute("allOrganizations");
                    if (allOrganizations != null && !allOrganizations.isEmpty()) {
                        int count = 0;
                        for (Organization organization : allOrganizations) {
                            if (count < 3) { 
                %>
                 <a href="singleOrganization?singleOrganization_id=<%= organization.getId()%>" >
                    <div class="business">
                        <h2> <%= organization.getName()%> </h2>
                        <p> <%= organization.getDescription()%> </p>
                    </div>
                </a>
                <%
                        }
                        count++; 
                    }
                } else {
                %>
                <span>Aún no hay organizaciones</span>    
                <%
                    }
                %>
            </div>
        </div>
    </body>
</html>

<style>
    
.business {
  background-color: #fff;
  border: 1px solid #ddd;
  padding: 20px;
  width: 200px;
  text-align: center;
  border-radius: 5px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  transition: transform 0.2s;
}

.business:hover {
  transform: scale(1.05); 
}

</style>
