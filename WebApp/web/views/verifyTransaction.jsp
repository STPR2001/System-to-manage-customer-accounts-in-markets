<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/globals.css" />
        <title>Confirmar transacción</title>
    </head>
    <body>
        <section>
            <jsp:include page="components/Navbar.jsp" />
            <header>
                <h1>Confirmar</h1>
            </header>
            <div id="transaction-details">
                <%
                    String transactionId = (String) request.getParameter("transaction_id");
                    String businessName = (String) request.getAttribute("businessName");
                    Float totalAmount = (Float) request.getAttribute("totalAmount");
                %> 
                <span><%= businessName%></span>
                <span>Transacción #<%= transactionId%></span>
                <div id="total-amount-box">
                    <span>Ver detalles</span>
                    <span>$<%= totalAmount%></span>
                </div>
            </div>
            <form action="transaction" method="POST">
                <% if (session == null) { %>
                <div>
                    <label for="email">Email</label>
                    <input placeholder="ejemplo@gmail.com" type="text" id="email" name="email" required>
                </div>
                <% } %>
                <div>
                    <label for="password">Contraseña de cuenta</label>
                    <input placeholder="Contraseña de cuenta" type="text" name="accountPassword" required>
                </div>
                <input type="hidden" name="transactionId" value="<%= transactionId %>">
                <button type="submit" class="btn">
                    Confirmar
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

<style>
    #total-amount-box {
        width: 100%;
        margin-top: 12px;
        display: flex;
        align-items: center;
        justify-content: space-between;
    }

    #total-amount-box > span:nth-child(1) {
        color: var(--primary);
    }

    #total-amount-box > span:nth-child(2) {
        font-size: 22px;
        font-weight: 600;
    }

    #transaction-details {
        display: flex;
        flex-direction: column;
        gap: 5px;
        margin: 40px 0px;
        border: 2px dashed var(--transparent-texts);
        border-radius: 10px;
        width: 20rem;
        padding: 30px;
    }

    #transaction-details > span:nth-child(1) {
        font-weight: 600;
    }

    form {
        margin-top: 20px;
        display: flex;
        flex-direction: column;
        width: 20rem;
        gap: 15px;
    }

    form > div {
        display: flex;
        flex-direction: column;
        gap: 10px
    }

    form > div > label {
        padding-left: 15px;
    }

    header {
        margin-top: 40px;
    }

    section {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }
</style>
