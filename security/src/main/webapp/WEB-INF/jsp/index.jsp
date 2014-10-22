<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security"
		   uri="http://www.springframework.org/security/tags" %>
<c:url var="homeUrl" value="/"/>
<c:url var="loginUrl" value="/spring_security_login"/>
<c:url var="logoutUrl" value="/j_spring_security_logout"/>

<html>
<head>
	<title></title>
</head>
<body>

￼￼￼￼￼￼ <a href="${homeUrl}">Home</a>
<security:authorize access="isAnonymous()">
	Hi, guest. <a href="${loginUrl}">Log in</a>
</security:authorize>
<security:authorize access="isAuthenticated()">
	Hi, <security:authentication property="principal.username"/>.
	<a href="${logoutUrl}">Log out</a>
</security:authorize>

</body>
</html>