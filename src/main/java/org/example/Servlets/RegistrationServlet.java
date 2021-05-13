package org.example.Servlets;

import org.example.dao.AccountDao;
import org.example.entity.Account;
import org.example.entity.FitnessClub;
import org.example.exception.PasswordException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name="registration",
        urlPatterns = "/registration"
)

public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AccountDao accountDao;

    public void init() {
        accountDao = new AccountDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String pswd = request.getParameter("pswd");

        Account account = null;
        try {
            account = new Account(firstname,lastname,email,pswd);
        } catch (PasswordException e) {
            out.print(e.getMessage());
        }

        FitnessClub fitnessClub = FitnessClub.getFitnessClub();
        fitnessClub.getAccounts().add(account);
        Cookie cookie = new Cookie("name", firstname);
        response.addCookie(cookie);

        try {
            accountDao.registerAccount(account);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        response.sendRedirect("registrationDetails.jsp");
        out.close();
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//
//        String firstname = req.getParameter("firstname");
//        String lastname = req.getParameter("lastname");
//        String email = req.getParameter("email");
//        String pswd = req.getParameter("pswd");
//        Account account = new Account(firstname,lastname,email,pswd);
//        FitnessClub fitnessClub = FitnessClub.getFitnessClub();
//        fitnessClub.getAccounts().add(account);
//        Cookie cookie = new Cookie("name", firstname);
//        resp.addCookie(cookie);
//
//        out.println("First name: " + account.getFirstName() + "<br>");
//        out.println("Last name: " +account.getLastName()+ "<br>");
//        out.println("Email: " +account.getEmail()+ "<br>");
//        out.println("Password: " +account.getPassword()+ "<br>");
//        out.close();
//    }
}
