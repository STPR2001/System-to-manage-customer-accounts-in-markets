<%@page import="logic.classes.FullAccount"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/globals.css" type="text/css" />
        <title>WebApp1 - Dashboard</title>
    </head>
    <body>
        <jsp:include page="components/Navbar.jsp" />
        <main>
            <header>
                <h1>Dashboard</h1>
            </header>
            <section style="margin-top: 12px">
                <h2>Tus cuentas</h2>
                <div id="accounts-container">
                    <%
                        ArrayList<FullAccount> accounts = (ArrayList) request.getAttribute("accounts");
                        if (accounts != null) {
                            for (FullAccount account : accounts) {
                    %>
                    <a href="account?account_id=<%= account.getAttributes().getId()%>">
                        <div>
                            <span>
                                <%= account.getOrganizationName()%>
                            </span>
                            <div style="display: flex; align-items: center; gap: 10px;">
                                <span>
                                    $<%= account.getTotal()%>
                                </span>
                                <span style="color: var(--transparent-texts)">
                                    / <%= account.getLimit()%>
                                </span>
                            </div>
                        </div>
                    </a>
                    <% }
                    } else { %>
                    <span>Aún no tienes cuentas</span>    
                    <% }%>
                    <%
                        if (accounts.size() == 0) {
                    %>
                    <span>Aún no tienes cuentas</span>
                    <% }%>
                </div>
            </section>
        </main>
    </body>
</html>


<style>
    #accounts-container {
        display: grid;
        grid-template-columns: repeat(3, 1fr);
        flex-wrap: wrap;
        gap: 12px;
        margin-top: 40px;
    }

    #accounts-container > a > div {
        border-radius: 5px;
        padding: 12px;
        background-color: var(--almost-bg);
        display: flex;
        align-items: center;
        justify-content: space-between;
        cursor: pointer;
        border: 2px solid transparent;
        transition: 0.2s;
    }

    #accounts-container > a > div:hover {
        border: 2px solid var(--primary);
        transition: 0.2s;
    }

    #accounts-container > a > div > span:nth-child(1) {
        font-size: 20px;
    }
</style>