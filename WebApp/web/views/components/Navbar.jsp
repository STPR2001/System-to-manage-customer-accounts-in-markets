<html>
    <head>
        <link rel="stylesheet" href="css/navbar.css" />
    </head>
    <nav>
        <% String email = (String) session.getAttribute("email");%>
        <% if (email != null) {%>
        <div style="display: flex; align-items: center; gap: 10px">
            <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-user" width="25" height="25" 
                 viewBox="0 0 24 24" stroke-width="1.5" stroke="var(--texts)" fill="none" stroke-linecap="round" stroke-linejoin="round">
                <path stroke="none" d="M0 0h24v24H0z" fill="none"/>
                <path d="M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0" />
                <path d="M6 21v-2a4 4 0 0 1 4 -4h4a4 4 0 0 1 4 4v2" />
            </svg>
            <span><%= email%></span>
        </div>   
        <% } %>

        <% if (email != null) { %>
        <style>
            nav {
                justify-content: space-between;
            }
        </style>
        <% } else { %>
        <style>
            nav {
                justify-content: center;
            }
        </style>
        <% } %>
        <ul>
            <li>
                <a href="/Home/">
                    Inicio
                </a>
            </li>
            <li>
                <a href="/Home/about">
                    Sobre nosotros
                </a>
            </li>
            <li>
                <a href="/Home/contact">
                    Contacto
                </a>
            </li>
            <li>
                <% if (email != null) { %>
                <a href="/Home/logout">
                    Cerrar sesión
                </a>    
                <% } else { %>
                <a href="/Home/login">
                    Iniciar sesión
                </a>
                <% }%>
            </li>
        </ul>
    </nav>
</html>