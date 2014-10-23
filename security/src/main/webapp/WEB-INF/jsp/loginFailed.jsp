<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="loginUrl" value="/login"/>
<html>
<head>
	<title>AcmeSecurity</title>
</head>
<body>
<h1>Login attempt has failed.</h1>
<p>Please try <a href="${loginUrl}">again</a>.</p>
</body>
</html>