<%@ page import="org.example.entity.Account" %>
<%@ page import="org.example.entity.FitnessClub" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Registration Details</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="resources/css/schedule.css" rel="stylesheet">
</head>
<body>
<%@ include file="link.jsp" %>
<div class="container">
<h1>You are successfully registered!</h1>
<h2>User List</h2>
<table>
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Email</th>
        <th>Password</th>
    </tr>
    <%
        List<Account> accountList = FitnessClub.getFitnessClub().getAccounts();
        for(Account account: accountList){
            out.println("<tr class=\"grey\">\n" +
                    "            <td>"+ account.getFirstName() + "</td>\n" +
                    "            <td>"+ account.getLastName() + "</td>\n" +
                    "            <td>"+ account.getEmail() + " </td>\n" +
                    "            <td>"+ account.getPassword() + "</td>\n" +
                    "        </tr>");
        }
    %>
</table>
</div>
</body>
</html>
