<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>I18n</h1>
        <c:set var="clientLocale" value="${pageContext.request.locale}" />
        <c:out value="${clientLocale}"/> <br/>
        Preferred locale: ${clientLocale.displayName}<br/>
        Preferred locale country: ${clientLocale.displayCountry} <br/>
        Preferred locale language: ${clientLocale.displayLanguage}

        <h3>Lower priority locales...</h3>
        <c:set var="clientLocales" value="${pageContext.request.locales}" />                
        <c:forEach var="loc" items="${clientLocales}" begin="1">
            Locale: ${loc.displayName}<br/>
            Locale country: ${loc.displayCountry}<br/>
            Locale language: ${loc.displayLanguage}<br/>
            <hr/>
        </c:forEach>
        <hr/>
        <h2>Set Locate, after display coutry, language, date</h2>
        <c:set var="num1" value="123456"/>
        <c:set var="num2" value="0.82"/>
        <c:set var="num3" value="345987.246"/>
        
        <a href="?lang=vi_VN"><img src="resources/images/icons/icons8-vietnam-48.png"/></a>
        <a href="?lang=ja_JP"><img src="resources/images/icons/icons8-japan-48.png"/></a>
        <a href="?lang=fr_FR"><img src="resources/images/icons/icons8-france-48.png"/></a><br/>
        <fmt:setLocale value="${param.lang}"/>        
        <jsp:useBean id="datevn" class="java.util.Date" />
        Full Date: <fmt:formatDate value="${datevn}" type="both" dateStyle="full" timeStyle="full" /> <br />
        Currency: <fmt:formatNumber value="${num1}" type="currency" /><br />
        Percentages: <fmt:formatNumber value="${num2}" type="percent" /> <br/>
        Number: <fmt:formatNumber value="${num3}" pattern="###,###.000"/>
        <hr/>
        <fmt:setBundle basename="i18n.myi18n" />
        Wellcome: <fmt:message key="welcome" /> <br/>        
        Username: <fmt:message key="username" /><br/>
        Password: <fmt:message key="password" /><br/>


    </body>
</html>
