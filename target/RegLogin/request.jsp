<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="resources/css/formstyle.css" rel="stylesheet">


    <title>Request Form</title>
</head>
<body>
<h2><a href="index.jsp">Home</a></h2>
<form action="request" method="post">
<div class="container">
    <h2>Request Form</h2>
    <div classs="field">
        <label for="name">Name</label>
        <input type="text" placeholder="Enter name" id="name" name="name" required>
    </div>
    <div classs="field">
        <label for="phoneNumber">Phone number</label>
        <input type="text" placeholder="Enter phone number" id="phoneNumber" name="phoneNumber" required>
    </div>
    <div classs="field">
        <label for="question">Your question</label>
        <input type="text" placeholder="Enter your question" id="question" name="question" required>
    </div>
    <input class="btn" type="submit" value="Send">
</div>
</form>
</body>
</html>
