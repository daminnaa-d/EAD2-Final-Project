<html>
<head>
    <title>Profile</title>
    <link href="resources/css/schedule.css" rel="stylesheet">
</head>
<body>
<%@ include file="link.jsp" %>

<div class="container">
    <h1>Account name: <%=session.getAttribute("name")%></h1>
    <br>
    <button class="button" style="vertical-align:middle"><span><a href="trainings.jsp">My trainings</a></span></button>
</div>
</body>
</html>
