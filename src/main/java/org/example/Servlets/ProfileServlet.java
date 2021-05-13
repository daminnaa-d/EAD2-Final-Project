package org.example.Servlets;

import org.example.entity.Account;
import org.example.entity.FitnessClub;
import org.example.entity.Request;
import org.example.entity.Schedule;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name="profile",
        urlPatterns = "/profile"
)
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();

        req.getRequestDispatcher("link.jsp").include(req, resp);

        HttpSession session=req.getSession();
        if(session.getAttribute("name")!=null){
            String name=(String)session.getAttribute("name");
            for(Account account: FitnessClub.getFitnessClub().getAccounts()) {
                if (account.getFirstName().equalsIgnoreCase(name)) {
                    out.print("Welcome "+ account.getFirstName() + " " + account.getLastName() + "<br>" +
                            "" + account.getEmail() + "<br>");
                    out.println("Your questions are left on website: <br>");
                    for (Request request : account.getRequests()){
                        out.print(request.getQuestion() + "<br> ");
                    }
                    out.println("Programmes you are signed on: <br>");
                    for (Schedule schedule: account.getSchedules()){
                        out.println("Programme: " + schedule.getProgramme()+ "<br>" +
                                "Time: " + schedule.getTime() + "<br>" +
                                "Trainer: " + schedule.getTrainer() + "<br>");
                    }
                }
            }
        }
        else{
            out.print("Please login first");
            out.println("<a href=\"login.jsp\"> Login </a>");
        }
    }
}
