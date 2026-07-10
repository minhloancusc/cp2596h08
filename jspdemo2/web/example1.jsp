<%-- 
    Document   : example1
    Created on : Jul 8, 2026, 3:49:52 PM
    Author     : minhloan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:out value="Hello JSTL"/>
        <c:out value="${5+6}"/>
        <c:set var="var5" value="50"/>
        <c:out value="${var5}"/>
        <c:if test="${!empty var5}">Bien 5 rong</c:if>
        
        
        <h1>Example 1</h1>
        Var 1: <% out.print(request.getParameter("var1"));%>
        <br/>
        Var 2: <%= request.getParameter("var2") %>
        <%
            session.setAttribute("cart", 456);
        %>
        <a href="example2.jsp">Exmple 2</a>
    </body>
</html>
