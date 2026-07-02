<%-- 
    Document   : region
    Created on : Jul 2, 2026, 3:31:04 PM
    Author     : minhloan
--%>

<%@page import="java.util.List"%>
<%@page import="mypack.Region"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Region</h1>
        <%
            List<Region> listRegion = (List<Region>) request.getAttribute("listRegion");
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>Region ID</th>
                    <th>Region Description</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%for (Region r : listRegion) {%>
                <tr>
                    <td><%= r.getRegionID()%></td>
                    <td><%= r.getRegionDescription()%></td>
                    <td><a href="regioncontroller?action=edit&idregion=<%= r.getRegionID()%>">Edit</a></td>
                    <td><a href="regioncontroller?action=delete&idregion=<%= r.getRegionID()%>">Delete</a></td>
                </tr>
                <%}%>
            </tbody>
        </table>

    </body>
</html>
