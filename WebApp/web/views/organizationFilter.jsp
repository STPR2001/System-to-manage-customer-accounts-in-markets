<%@page import="logic.classes.Organization"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
   String ciudad = (String) request.getAttribute("ciudad"); 
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/globals.css" type="text/css" />
        <link rel="stylesheet" href="css/organizations.css" type="text/css" />
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="components/Navbar.jsp" />
        <h1 style="text-align:center; margin: 10px">Negocios en <%= ciudad %></h1>
        <div class="container">
                <%
                        ArrayList<Organization> filteredOrganizations = (ArrayList) request.getAttribute("filteredOrganizations");
                        if (filteredOrganizations != null) {
                            for (Organization Organization : filteredOrganizations) {
                            
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
                        if (filteredOrganizations.size() == 0) {
                    %>
                    <span>Aún no hay organizaciones</span>
                    <% }%>
                </div>
    </body>
</html>

