<%
    if(session.getAttribute("username")==null){
        response.sendRedirect("../login.jsp");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!Admin Dashboard</h1> 
        <h2>Hello! <%= session.getAttribute("username") %></h2>
        
        <a href="../SignOut">Signout</a>
    </body>
</html>
