package org.example.Servlets;

import org.example.entity.Account;
import org.example.entity.FitnessClub;
import org.example.entity.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name="request",
        urlPatterns = "/request"
)
public class RequestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        req.getRequestDispatcher("link.jsp").include(req, resp);

        String name = req.getParameter("name");
        long phoneNumber = Long.parseLong(req.getParameter("phoneNumber"));
        String question = req.getParameter("question");


        HttpSession session = req.getSession();
        if (session.getAttribute("name") != null) {
            for (Account account : FitnessClub.getFitnessClub().getAccounts()) {
                if (account.getFirstName().equalsIgnoreCase((String) session.getAttribute("name"))) {
                    Request request = new Request(name, phoneNumber, question);
                    account.getRequests().add(request);
                    out.println(account.getFirstName() + account.getLastName() + ", your request was successfully sent!");
                } else {
                    out.println("Account are not found!");
                }
            }
        }else{
            out.print("Please login first");
            req.getRequestDispatcher("login.jsp").include(req, resp);
        }
    }
}

