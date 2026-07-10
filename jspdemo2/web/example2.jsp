<%-- 
    Document   : example2
    Created on : Jul 8, 2026, 3:54:25 PM
    Author     : minhloan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Example 2</h1>
        Cart: <%= session.getAttribute("cart") %>
        <% //response.sendRedirect("index.jsp?var4=7&var5=8"); %>
        <jsp:forward page="index.jsp"> 
            <jsp:param name="var4" value="10"/>
            <jsp:param name="var5" value="20"/>
        </jsp:forward>
    </body>
</html>
