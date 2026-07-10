<%-- 
    Document   : index
    Created on : Jul 8, 2026, 3:39:46 PM
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
        <h1>Hello World!</h1>
        Var4: <%= request.getParameter("var4")%> <br/>
        Var5: <%= request.getParameter("var5")%><br/>
        --<br/>
        Var 4: ${param.var4} <br/>
        Var 5: ${param.var5} <br/>
        
        <a href="example1.jsp?var1=7&var2=8">Example 1</a><br/>
        <%@include file="header.jsp" %>
        <jsp:include page="header.jsp" flush="true"/>
        
        
    </body>
</html>
