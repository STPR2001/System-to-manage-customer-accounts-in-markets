<%@page import="logic.classes.Organization"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/globals.css" type="text/css" />
         <link rel="stylesheet" href="css/organizations.css" type="text/css" />
        <title>WebApp1 - Organizations</title>
    </head>
    <jsp:include page="components/Navbar.jsp" />
    <body>
        <main>
            <header>
                <h1>Negocios</h1>
            </header>
            <form style="margin-bottom: 10px" action="organizationFilter" method="get">
                <select name="ciudad" id="ciudad">
                    <option value="todas">Todas las ciudades</option>
                    <option value="Artigas">Artigas</option>
                    <option value="Canelones">Canelones</option>
                    <option value="Cerro Largo">Cerro Largo</option>
                    <option value="Colonia">Colonia</option>
                    <option value="Durazno">Durazno</option>
                    <option value="Flores">Flores</option>
                    <option value="Florida">Florida</option>
                    <option value="Lavalleja">Lavalleja</option>
                    <option value="Maldonado">Maldonado</option>
                    <option value="Montevideo">Montevideo</option>
                    <option value="Paysandú">Paysandú</option>
                    <option value="Río Negro">Río Negro</option>
                    <option value="Rivera">Rivera</option>
                    <option value="Rocha">Rocha</option>
                    <option value="Salto">Salto</option>
                    <option value="San José">San José</option>
                    <option value="Soriano">Soriano</option>
                    <option value="Tacuarembó">Tacuarembó</option>
                    <option value="Treinta y Tres">Treinta y Tres</option>
                </select>
                <button type="submit">Filtrar</button>
            </form>
            <div class="container">
                <%
                        ArrayList<Organization> allOrganizations = (ArrayList) request.getAttribute("allOrganizations");
                        if (allOrganizations != null) {
                            for (Organization Organization : allOrganizations) {
                            
                    %>

                    <div class="business-container">
                        <a href="singleOrganization?singleOrganization_id=<%= Organization.getId()%>" >
                            <div class="business">
                                <h2> <%= Organization.getName()%> </h2>
                                <p><%= Organization.getDescription()%></p>
                            </div>
                        </a>
                    </div>
               
 
                    <% }
                    } else { %>
                    <span>Aún no hay organizaciones</span>    
                    <% }%>
                    <%
                        if (allOrganizations.size() == 0) {
                    %>
                    <span>Aún no hay organizaciones</span>
                    <% }%>
                </div>
            </section>
        </main>
    </body>
</html>

<style>
    
 
form {
    text-align: right;
}


select {
    padding: 5px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 3px;
}


button {
    padding: 5px 10px;
    font-size: 16px;
    background-color: #007BFF;
    color: #fff;
    border: none;
    border-radius: 3px;
    cursor: pointer;
}


select option {
    font-size: 14px;
}


h2 {
    font-size: 18px;
    margin-top: 10px;
    margin-bottom: 5px;
}


</style>