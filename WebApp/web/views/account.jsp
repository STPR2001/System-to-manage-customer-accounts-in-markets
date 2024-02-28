<%@page import="logic.classes.Debt"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logic.classes.Account"%>
<%@page import="logic.classes.Organization"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/globals.css" type="text/css" />
        <title>Cuenta</title>
    </head>
    <body>
        <jsp:include page="components/Navbar.jsp" />
        <main>
            <header style="display: flex; flex-direction: column">
                <%
                    Account account = (Account) request.getAttribute("accountInformation");
                    Organization organization = (Organization) request.getAttribute("organizationInformation");
                    ArrayList<Debt> debtTransactions = (ArrayList<Debt>) request.getAttribute("debtTransactions");

                    String businessName = organization.getName();
                %>
                <h1><%= businessName%></h1>
                <a style="font-size: 15px; color: var(--primary)"
                   href="organizations?organization_id=<%= organization.getId()%>">
                    Ver negocio
                </a>
            </header>
            <section style="margin-top: 12px">
                <div id="account-information-container">
                    <div style="display: flex; align-items: center; gap: 5px">
                        <span style="font-weight: 600; font-size: 35px">
                            $<%= account.getTotal()%>
                        </span>
                        <span style="color: var(--transparent-texts); font-size: 35px">
                            / <%= account.getLimit()%>
                        </span>
                    </div>
                    <div style="margin-top: 40px; display: flex; flex-direction: column; gap: 12px">
                        <button class="btn">
                            Pagar
                        </button>
                        <button style="display: inline-block;
                                background-color: var(--almost-bg);
                                color: var(--primary);
                                cursor: pointer;
                                text-decoration: none;
                                font-size: 18px;
                                width: 100%;
                                padding: 10px 20px;
                                border-radius: 50px;
                                border: none;">
                            Agregar correo
                        </button>
                        <button style="display: inline-block;
                                background-color: var(--almost-bg);
                                color: var(--primary);
                                cursor: pointer;
                                text-decoration: none;
                                font-size: 18px;
                                width: 100%;
                                padding: 10px 20px;
                                border-radius: 50px;
                                border: none;">
                            Configuración
                        </button>
                    </div>
                </div>
                <div id="transactions-container">
                    <span>Transacciones</span>
                    <div id="table-header" style="font-size: 15px; color: var(--transparent-texts); display: grid; grid-template-columns: repeat(4, 1fr)">
                        <span>Hora</span>
                        <span>Detalle</span>
                        <span>Pago inicial</span>
                        <span style="text-align: right">Total</span>
                    </div>
                    <div>
                        <%
                            for (Debt debt : debtTransactions) {
                        %>
                        <div class="transaction-details-box">
                            <div style="display: flex; align-items: center; gap: 15px">
                                <% if (debt.getConfirmed()) { %>
                                <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-circle-filled" width="12" height="12" viewBox="0 0 24 24" stroke-width="1.5" stroke="#34D399" fill="none" stroke-linecap="round" stroke-linejoin="round">
                                <path stroke="none" d="M0 0h24v24H0z" fill="none"/>
                                <path d="M7 3.34a10 10 0 1 1 -4.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 4.995 -8.336z" stroke-width="0" fill="#34D399" />
                                </svg>
                                <% } else { %>
                                <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-circle-filled" width="12" height="12" viewBox="0 0 24 24" stroke-width="1.5" stroke="#F87171" fill="none" stroke-linecap="round" stroke-linejoin="round">
                                <path stroke="none" d="M0 0h24v24H0z" fill="none"/>
                                <path d="M7 3.34a10 10 0 1 1 -4.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 4.995 -8.336z" stroke-width="0" fill="#FBBF24" />
                                </svg>
                                <% }%>
                                <span><%= debt.getAttributes().getCreated_at()%></span>
                            </div>
                            <span><%= debt.getDetail()%></span>
                            <span><%= debt.getInitialPayment()%></span>
                            <span style="text-align: right">$<%= debt.getTotalAmount()%></span>
                        </div>
                        <% }%>
                    </div>
                </div>
            </section>
        </main>
    </body>
</html>

<style>
    section {
        display: flex;
    }

    #account-information-container {
        padding-right: 40px;
        width: 35%;
        display: flex;
        flex-direction: column;
        gap: 12px;
    }

    #transactions-container {
        width: 65%;
        display: flex;
        flex-direction: column;
        gap: 8px;
    }

    #transactions-container > span {
        color: var(--primary);
        font-size: 16px;
    }

    #transactions-container > div:nth-child(2) {
        margin-top: 20px;
        display: flex;
        flex-direction: column;
    }

    .transaction-details-box {
        display: grid;
        grid-template-columns: repeat(4, 1fr);
        border-bottom: 1px dashed var(--almost-bg);
        padding: 20px 0px;
        cursor: pointer;
        transition: 0.2s;
    }

    .transaction-details-box:hover {
        background: var(--almost-bg);
        transition: 0.2s;
    }
</style>