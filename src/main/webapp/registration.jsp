<%@ page import="org.example.entity.Account" %>
<%@ page import="java.io.PrintWriter"%>
<%@page import="java.util.*" %>

<%--
  Created by IntelliJ IDEA.
  User: D.Dilara
  Date: 08.02.2021
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="resources/css/formstyle.css" rel="stylesheet">
    <title>Register</title>
</head>
<body>
<h2><a href="index.jsp">Home</a></h2>
<form action="registration" method="POST">
    <form action="<%= request.getContextPath() %>/registration" method="post">
    <div class="container">
    <h2>Registration</h2>
    <div classs="field">
    <label for="firstname">First Name</label>
    <input type="text" placeholder="Enter first name" id="firstname" name="firstname" required>
    </div>
    <div classs="field">
    <label for="lastname">Last Name</label>
    <input type="text" placeholder="Enter last name" id="lastname" name="lastname" required>
    </div>
    <div classs="field">
    <label for="email">Email</label>
    <input type="text" placeholder="Enter email" id="email" name="email" required>
    </div>
    <div classs="field">
    <label for="pswd">Password</label>
    <input type="password" placeholder="Enter password" id="pswd" name="pswd" required>
    </div>
        <hr>
        <p>Already have an account? <a href="login.jsp">Log in</a></p>
    <button type="submit" class="btn">Register</button>
    </div>
</form>
</body>
</html>
