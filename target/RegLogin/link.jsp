<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="resources/css/header.css" rel="stylesheet">

</head>
<body>
<nav>
    <ul>
        <li><p class="icon">Fitness Club</p> </li>
        <li><a href="index.jsp">Home</a></li>
        <li><a href="schedule">Schedule</a></li>
        <li>
            <div class="dropdown">
                <button  class="dropbtn">Services
                    <i class="fa fa-caret-down"></i>
                </button>
                <div class="dropdown-content">
                    <a href="gym.jsp">Gym</a>
                    <a href="group.jsp">Group programs</a>
                </div>
            </div>
        </li>
        <li><a href="request.jsp">Leave request</a></li>
        <li><a href="profile.jsp">Profile</a></li>
        <li><a href="login.jsp">Login</a></li>
        <li><a href="LogoutServlet">Logout</a></li>
    </ul>
</nav>
</body>

