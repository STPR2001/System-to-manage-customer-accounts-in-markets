<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/globals.css" type="text/css" />
        <title>404 Not found</title>
    </head>
    <body>
        <section>
            <%
                String message = (String) request.getAttribute("message404");
                if (message != null) {
            %>
            <h1><%= message%></h1>
            <% } else { %>
            <h1>404 | No se encontró</h1>
            <% }%>
            <a href="/Home">
                Volver
            </a>
        </section>
    </body>
</html>

<style>
    section {
        width: 100%;
        height: 100vh;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }
    
    section > h1 {
        font-size: 25px;
        font-weight: 600;
    }
    
    section a {
        text-decoration: none;
        color: black;
        margin-top: 12px;
    }
</style>
