package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.factories.Factory;
import logic.classes.Account;
import logic.classes.Debt;
import logic.classes.Organization;
import logic.interfaces.IAccountController;
import logic.interfaces.IOrganizationController;
import logic.interfaces.ITransactionController;

@WebServlet(name = "account", urlPatterns = {"/account"})
public class account extends HttpServlet {

    IAccountController IAccount = Factory.getInstance().getAccountController();
    IOrganizationController IOrganization = Factory.getInstance().getOrganizationController();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet account</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet account at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("email") == null) {
            response.sendRedirect("login");
            return;
        }

        String accountId = request.getParameter("account_id");

        if (accountId == null) {
            response.sendRedirect("404");
            return;
        }

        Account account = this.IAccount.getAccountById(accountId);
        Organization organization = this.IOrganization.getOrganizationByAccountId(accountId);
        ArrayList<Debt> debtTransactions = this.IAccount.getAccountDebtTransactions(accountId);

        request.setAttribute("organizationInformation", organization);
        request.setAttribute("debtTransactions", debtTransactions);
        request.setAttribute("accountInformation", account);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/account.jsp");
        dispatcher.forward(request, response);

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
