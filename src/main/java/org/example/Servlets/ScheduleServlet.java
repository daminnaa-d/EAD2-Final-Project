package org.example.Servlets;

import org.example.entity.Account;
import org.example.entity.FitnessClub;
import org.example.entity.Schedule;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name="schedule",
        urlPatterns = "/schedule"
)
public class ScheduleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();

        req.getRequestDispatcher("link.jsp").include(req, resp);

        String programme = req.getParameter("schedule");
        FitnessClub fitnessClub = FitnessClub.getFitnessClub();

        HttpSession session = req.getSession();
        if (session.getAttribute("name") != null) {
            for (Account account : FitnessClub.getFitnessClub().getAccounts()) {
                if (account.getFirstName().equalsIgnoreCase((String) session.getAttribute("name"))) {
                    for(Schedule schedule: fitnessClub.getSchedules()){
                        if(programme.equalsIgnoreCase(schedule.getProgramme())){
                           account.getSchedules().add(schedule);
                           out.println("You are signed for the " + programme);
                           break;
                        }
                    }
                } else {
                    out.println("Account are not found!");
                }
            }
        }else{
            out.print("Please login first");
            req.getRequestDispatcher("login.jsp").include(req, resp);
        }



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fitness_db","root","password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM schedule;");
            List<Schedule> schedules = new ArrayList<>();
            while(resultSet.next()){
                String programme = resultSet.getString("programme");
                String times = resultSet.getString("times");
                double price = resultSet.getDouble("price");
                String trainer = resultSet.getString("trainer");
                Schedule schedule = new Schedule(programme, times, price, trainer);
                schedules.add(schedule);

            }
            FitnessClub.getFitnessClub().setSchedules(schedules);
            req.getRequestDispatcher("schedule.jsp").include(req,resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
