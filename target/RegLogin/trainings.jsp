<%@ page import="org.example.entity.*" %>
<link href="resources/css/portfolio.css" rel="stylesheet">

<html>
<head>
    <title>My trainings</title>
</head>
<body>
<%@ include file="link.jsp" %>
<div class="container">
<h2>My trainings: </h2>
<div class="embossed-heavy">
<%
    Account account = null;

    if (session.getAttribute("name") != null){
        for( Account account1: FitnessClub.getFitnessClub().getAccounts()){
            if(account1.getFirstName().equalsIgnoreCase(session.getAttribute("name").toString())){
                account = account1;
            }
        }
        for(Schedule schedule1: account.getSchedules()){
            out.println("<br>Programme: " + schedule1.getProgramme()+ "<br>" +
                    "Time: " + schedule1.getTime() + "<br>" +
                    "Trainer: " + schedule1.getTrainer() + "<br> \n" +
            "<hr>"
            );
        }
    }else {
        out.println("You are not logged in!");
        request.getRequestDispatcher("login.jsp");
    }
%>
</div>
</div>
</body>
</html>
