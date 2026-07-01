<%-- 
    Document   : login
    Created on : Jun 24, 2026, 4:23:22 PM
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
        <h1>Login</h1>
        <%
            if(request.getParameter("log")!=null){
                if(request.getParameter("log").equals("false")){
        %>            
        <h2 style="color: red"><i>Please enter again!</i></h2>
        <%        }
            }
        %>
        <form method="POST" action="LoginProcess">
            <table border="0">
                <thead>
                    <tr>
                        <th>Login</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Username: </td>
                        <td><input type="text" name="username" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password" value="" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Login" />
                            <input type="reset" value="Reset" />
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
