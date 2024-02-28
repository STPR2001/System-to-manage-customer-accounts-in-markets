package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.classes.Debt;
import logic.classes.Organization;
import logic.classes.Account;
import logic.factories.Factory;
import logic.interfaces.IAccountController;
import logic.interfaces.IOrganizationController;
import logic.interfaces.ITransactionController;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet(name = "transaction", urlPatterns = {"/transaction"})
public class transaction extends HttpServlet {

    ITransactionController ITransaction = Factory.getInstance().getTransactionController();
    IOrganizationController IOrganization = Factory.getInstance().getOrganizationController();
    IAccountController IAccount = Factory.getInstance().getAccountController();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet transaction</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet transaction at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Debt transaction = null;
        Organization organization = null;

        String transactionId = request.getParameter("transaction_id");

        if (transactionId == null) {
            request.setAttribute("message404", "No se encontró la transacción");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/404.jsp");
            dispatcher.forward(request, response);

            return;
        } else {
            transaction = this.ITransaction.getDebtById(Integer.parseInt(transactionId));
            organization = this.IOrganization.getOrganizationByDebtTransactionId(transactionId);

            // Si ya está confirmada también 404
            if (organization == null || transaction == null || transaction.getConfirmed()) {
                request.setAttribute("message404", "No se encontró la transacción");

                RequestDispatcher dispatcher = request.getRequestDispatcher("/views/404.jsp");
                dispatcher.forward(request, response);

                return;
            }

            request.setAttribute("businessName", organization.getName());
            request.setAttribute("totalAmount", transaction.getTotalAmount());
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/verifyTransaction.jsp");
        dispatcher.forward(request, response);

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String accountPassword = request.getParameter("accountPassword");
        String transactionId = request.getParameter("transactionId");

        Debt transaction = this.ITransaction.getDebtById(Integer.parseInt(transactionId));

        if (transaction.getConfirmed()) {
            processRequest(request, response);
            return;
        }

        Account account = this.IAccount.getAccountById(transaction.getAccountId());
        // TODO: Log in if not logged

        Boolean passwordCheckResult = BCrypt.checkpw(accountPassword, account.getPassword());

        if (!passwordCheckResult) {
            request.setAttribute("error", "Credenciales incorrectas");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/verifyTransaction.jsp");
            dispatcher.forward(request, response);

            return;
        }

        Boolean result = this.ITransaction.confirmDebtTransaction(transactionId);

        if (!result) {
            request.setAttribute("error", "Algo salió mal al confirmar la transacción, intenta de nuevo más tarde");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/verifyTransaction.jsp");
            dispatcher.forward(request, response);

            return;
        }

        request.setAttribute("successMessage", "Transacción confirmada");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/success.jsp");
        dispatcher.forward(request, response);

        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
