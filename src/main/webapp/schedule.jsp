<%@ page import="org.example.entity.FitnessClub" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.example.entity.Schedule" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="resources/css/schedule.css" rel="stylesheet">

    <title>Schedule</title>
</head>
<body>
<%@ include file="link.jsp" %>

<div class="container">
    <h2>Schedule</h2>
    <table>
        <tr>
            <th>Programme</th>
            <th>Time</th>
            <th>Price</th>
            <th>Trainer</th>
            <th>Sign for programme</th>
        </tr>
        <%
            List<Schedule> schedules = FitnessClub.getFitnessClub().getSchedules();
            for(Schedule schedule: schedules){
                out.println("<tr class=\"grey\">\n" +
                        "            <td>"+ schedule.getProgramme() + "</td>\n" +
                        "            <td>"+ schedule.getTime() + "</td>\n" +
                        "            <td>"+ schedule.getPrice() + " </td>\n" +
                        "            <td>"+ schedule.getTrainer() + "</td>\n" +
                        " <td><form action=\"schedule\" method=\"post\">\n" +
                        "            <input type=\"hidden\" name=\"schedule\" value='" + schedule.getProgramme() +"'>\n" +
                        "<input type='submit' value='Sign'>" +
                        "        </form></td>" +
                        "        </tr>");
            }
        %>
    </table>
</div>
</body>
</html>
