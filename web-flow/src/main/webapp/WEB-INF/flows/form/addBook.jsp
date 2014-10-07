<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Spring Labs - SWF Forms</title>
</head>
<body>
<h1>Add a book form</h1>

<form action="${flowExecutionUrl}" method="post">
	<input type="hidden" name="_eventId" value="submit">

	<div>
		<label>Author</label>
		<spring:bind path="book.author">
			<input name="${status.expression}" value="${status.value}">
			<c:if test="${status.error}">
				<span>${status.errorMessage}</span>
			</c:if>
		</spring:bind>
	</div>

	<div>
		<label>Title</label>
		<spring:bind path="book.title">
			<input name="${status.expression}" value="${status.value}">
			<c:if test="${status.error}">
				<span>${status.errorMessage}</span>
			</c:if>
		</spring:bind>
	</div>
	<input type="submit" value="Add">
</form>

<a href="${flowExecutionUrl}&_eventId=reset">Reset</a>

</body>
</html>