<%@page import="logic.classes.Organization"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
  Organization business = (Organization) request.getAttribute("business");
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/globals.css" type="text/css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <title>WebApp1 - Business</title>
</head>
<body>
    <header>
        <jsp:include page="components/Navbar.jsp" />
    </header>

    <main>
        <section class="business-section">
            <a class="whatsapp-button" href="https://api.whatsapp.com/send?phone=TUNUMERODETELEFONO">
                <i class="fab fa-whatsapp fa-2x"></i>
            </a>
            <div class="business-details">
                <h1><%= business.getName() %></h1>
                <p class="description"><%= business.getDescription() %></p>
                <p class="description"><%= business.getCity() %></p>
                <p class="address"><%= business.getAddress() %></p>
            </div>
        </section>

        <section class="cta-section">
            <a class="create-account-button" href="createAccount">Crear cuenta</a>
        </section>
                
       <section class="cta-section">
              <a class="contact-button" href="createAccount">Contactar negocio</a>
      </section>
            
            
    </main>
</body>
</html>



<style>
        .business-details {
            margin: 12px;
        }

        h1 {
            font-size: 28px;
            margin-bottom: 10px;
        }

        p.description {
            font-size: 16px;
            margin-bottom: 10px;
        }

        p.address {
            font-size: 16px;
        }

        .whatsapp-button {
            position: fixed;
            bottom: 20px;
            right: 20px;
            z-index: 999;
            width: 60px;
            height: 60px;
            background-color: #25d366;
            color: #fff;
            text-align: center;
            border-radius: 50%;
            text-decoration: none;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .create-account-button {
            position: absolute;
            top: 21%;
            right: 20px;
            transform: translateY(-50%);
            background-color: #007BFF;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            text-decoration: none;
        }

        .create-account-button:hover {
            background-color: #333333;
            color: white;
        }
        
        .contact-button {
            position: absolute;
            top: 80%;
            left: 20px;
            transform: translateY(-50%);
            background-color: #007BFF;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            text-decoration: none;
        }

        .contact-button :hover {
            background-color: #333333;
            color: white;
        }
        

</style>