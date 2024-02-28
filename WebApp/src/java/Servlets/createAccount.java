/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.factories.Factory;
import logic.interfaces.IAccountController;

/**
 *
 * @author marty
 */
@WebServlet(name = "createAccount", urlPatterns = {"/createAccount"})
public class createAccount extends HttpServlet {
    private IAccountController ICA;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet createAccount</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet createAccount at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/createAccount.jsp");
        dispatcher.forward(request, response);
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        this.ICA = Factory.getInstance().getAccountController();
        
        Integer orgId = Integer.valueOf(request.getParameter("orgId"));
        Integer userId = Integer.valueOf(request.getParameter("userId"));
        String limitAmount = request.getParameter("limitAmount");
        String contrasena = request.getParameter("contrasena");
      
        this.ICA.createAccount(orgId, userId, limitAmount, contrasena);
        
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
