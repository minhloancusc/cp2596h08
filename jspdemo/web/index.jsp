<%-- 
    Document   : index
    Created on : Jul 6, 2026, 3:41:04 PM
    Author     : minhloan
--%>

<%@page errorPage="process_error.jsp" contentType="text/html" pageEncoding="UTF-8" import="java.util.Date,java.util.ArrayList"%>
<%@include  file="header.jsp"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%= "Hello JSP"%>
        <%= 5 + 6%>
        <%@include  file="header.jsp"  %>
        <%
            Date date = new Date();
            out.print(date.getDate());
            ArrayList aList = new ArrayList();
            int x = 5;
            int y = 1;
            int c = x / y;
//            public int sum(int m, int n){
//                return m+n;
//            }
            class MyClass {

                public void display() {

                }
            }
        %>

        <%--       <%= x %> --%>

        <%!
            int a = 5;
            int b = 7;

            public int sum(int m, int n) {
                return m + n;
            }

            class MyClass {

                public void display() {

                }
            }
        %>
    </body>
</html>
