<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security"
		   uri="http://www.springframework.org/security/tags" %>
<c:url var="homeUrl" value="/"/>
<c:url var="loginUrl" value="/login"/>
<c:url var="postLoginUrl" value="/j_spring_security_check"/>
<c:url var="logoutUrl" value="/j_spring_security_logout"/>
<html>
<head>
	<title>AcmeSecurity</title>
</head>
<body>

￼￼￼￼￼￼ <a href="${homeUrl}">Home</a>
<security:authorize access="isAnonymous()">
	Hi, guest. You can login right here<br/>

	<form class="main" action="${postLoginUrl}" method="post">
		Username: <input type="text" name="j_username"/><br/>
		Password: <input type="password" name="j_password"/><br/>
		<input type="checkbox" name="_spring_security_remember_me"/>
		Remember me<br/>
		<input type="submit" value="Log in"/>
	</form><br/>
	Or navigate to a separate page
	<a href="${loginUrl}">Log in</a>
</security:authorize>
<security:authorize access="isAuthenticated()">
	Hi, <security:authentication property="principal.fullName"/>.
	<a href="${logoutUrl}">Log out</a>
</security:authorize>

</body>
</html>