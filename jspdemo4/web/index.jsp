<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="mytag" uri="/WEB-INF/tlds/mytag_library" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <mytag:example1 param1="5" param2="8"/> <br/>
        <mytag:example2>images/images.png</mytag:example2>
        <mytag:example2>images/hoa1.jpg</mytag:example2><br/>
        <mytag:example3 width="150" slogan="Hoa Sen">images/hoa1.jpg</mytag:example3>
    </body>
</html>
