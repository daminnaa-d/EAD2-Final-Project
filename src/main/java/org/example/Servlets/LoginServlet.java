package org.example.Servlets;

import org.example.entity.Account;
import org.example.entity.FitnessClub;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name="login",
        urlPatterns = "/login"
)

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();

        req.getRequestDispatcher("link.jsp").include(req, resp);

        String email = req.getParameter("email");
        String pswd = req.getParameter("pswd");


        if(!FitnessClub.getFitnessClub().getAccounts().isEmpty()){
            for(Account account: FitnessClub.getFitnessClub().getAccounts()){
                if (account.getEmail().equals(email)  && account.getPassword().equals(pswd)){
                    String name = account.getFirstName();
                    out.print("You are successfully logged in!");
                    out.print("<br>Welcome, " + name);
                    Cookie ck = new Cookie("name",name);
                    resp.addCookie(ck);

                    HttpSession session=req.getSession();
                    session.setAttribute("name",name);
                }else{
                    out.print("Error, email or password incorrect!");
                    req.getRequestDispatcher("login.jsp").include(req, resp);
                }
            }
        }else{
            out.println("You are not registered yet!");
            out.println("<a href=\"registration.jsp\"> Register</a>");
        }
        out.close();
    }

}

