<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!--Insert-->
<c:if test="${!empty param.addRegion}">
    <sql:update dataSource="${conn}">
        insert into Region (RegionID,RegionDescription) values (?,?)
        <sql:param value="${param.regionID}"/>
        <sql:param value="${param.regionDescription}"/>
    </sql:update>
</c:if>
<!--Delete-->
<c:if test="${(!empty param.action)&&(param.action=='delete')}">
    <sql:update dataSource="${conn}">
        Delete from Region where RegionID=?
        <sql:param value="${param.id}"/>
    </sql:update>
    <script>alert("Xoa Thanh cong")</script>    
</c:if>
<!--Edit-->
<c:if test="${(!empty param.action)&&(param.action=='edit')}">
    <sql:query var="rs2" dataSource="${conn}">
        select RegionID,RegionDescription from Region where RegionID=?
        <sql:param value="${param.id}"/>
    </sql:query>
    <c:set var="editRow" value="${rs2.rows}"/>
</c:if>
<c:if test="${!empty param.editRegion}">
    <sql:update dataSource="${conn}">
        update Region set RegionDescription=? where RegionID=?
        <sql:param value="${param.regionDescription}"/>
        <sql:param value="${param.regionID}"/>        
    </sql:update>
    <script>alert("Cap nhat Thanh cong")</script>     
</c:if>        
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Region</title>
    </head>
    <body>
        <h1>Region</h1>
        <!--Form-->
        <form method="POST">
            <table border="0">
                <thead>
                    <tr>
                        <th colspan="2">Region Form</th>                
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Region ID</td>
                        <td><input type="text" name="regionID" value="${editRow[0].RegionID}" /></td>
                    </tr>
                    <tr>
                        <td>Region Description</td>
                        <td><input type="text" name="regionDescription" value="${editRow[0].RegionDescription}" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="${(empty editRow)?'Add':'Edit'}" name="${(empty editRow)?'addRegion':'editRegion'}" />
                            <input type="submit" value="Reset" name="resetForm" />
                        </td>
                    </tr>
                </tbody>
            </table>
        </form> 
        <br/>        
        <!--View-->
        <sql:query var="rs1" sql="select RegionID,RegionDescription from Region" dataSource="${conn}"/>
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
                <c:forEach var="item1" items="${rs1.rows}">                                    
                    <tr>
                        <td>${item1.RegionID}</td>
                        <td>${item1.RegionDescription}</td>
                        <td><a href="?action=edit&id=${item1.RegionID}">Edit</a></td>
                        <td><a href="?action=delete&id=${item1.RegionID}">Delete</a></td>
                    </tr>
                </c:forEach>    
            </tbody>
        </table>

    </body>
</html>
