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
            Region editRegion = null;
            if(request.getAttribute("editRegion")!=null){
                editRegion = (Region)request.getAttribute("editRegion");                
            }
        %>
        <form method="POST" action="regioncontroller">
            <table border="0">
                <thead>
                    <tr>
                        <th colspan="2">Region Form</th>                        
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Region ID</td>
                        <td><input type="text" name="regionID" value="<%=((editRegion!=null)?editRegion.getRegionID():"") %>" /></td>
                    </tr>
                    <tr>
                        <td>Region Description</td>
                        <td><input type="text" name="regionDescription" value="<%=((editRegion!=null)?editRegion.getRegionDescription():"") %>" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="<%=((editRegion!=null)?"Edit":"Add") %>" name="<%=((editRegion!=null)?"btnEdit":"btnAdd") %>" />
                            <input type="reset" value="Reset" name="btnReset" />
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>
<!--View-->
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
                    <td><a href="regioncontroller?action=edit&id=<%= r.getRegionID()%>">Edit</a></td>
                    <td><a href="regioncontroller?action=delete&id=<%= r.getRegionID()%>">Delete</a></td>
                </tr>
                <%}%>
            </tbody>
        </table>

    </body>
</html>
