package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.classes.User;
import logic.factories.Factory;
import logic.interfaces.IAuthController;
import logic.interfaces.IUserController;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    IAuthController IAuth;
    IUserController IUser;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/login.jsp");
        dispatcher.forward(request, response);
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session;
        this.IAuth = Factory.getInstance().getAuthController();
        this.IUser = Factory.getInstance().getUserController();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email.equals("") || password.equals("")) {
            System.out.println("Invalid credentials");

            request.setAttribute("error", "Credenciales incorrectas");
            request.getRequestDispatcher("/views/login.jsp")
                    .forward(request, response);
            return;
        }

        String authResult = IAuth.handleLogIn(email, password);

        if (authResult.equals("ok")) {
            session = request.getSession();

            User user = this.IUser.getUserByIdOrEmail(null, email);

            session.setAttribute("userId", user.getAttributes().getId());
            session.setAttribute("email", email);

            response.sendRedirect("dashboard");
        } else {
            request.setAttribute("error", authResult);
            request.getRequestDispatcher("/views/login.jsp")
                    .forward(request, response);
        }

        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
