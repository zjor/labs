<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="baseURL"
	   value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html ng-app="AcmeRegistration">
<head>
	<!-- Standard Meta -->
	<meta charset="utf-8"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

	<title>Acme Registration</title>

	<link rel="stylesheet" type="text/css" href="${baseURL}/static/css/semantic.css">

	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.js"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery.address/1.6/jquery.address.js"></script>
	<script src="${baseURL}/static/javascript/semantic.min.js"></script>

	<link rel="stylesheet" type="text/css" href="${baseURL}/static/css/acme.css">
	<!--<script src="feed.js"></script>-->

</head>
<body>
<h3 class="ui inverted teal header">
	Acme Registration Example
</h3>

<div class="ui two column grid">
	<div class="seven wide left column">
		<form name="registrationForm" class="ui fluid form" ng-controller="RegistrationController" ng-submit="registrationForm.$valid && register()" novalidate>
			<h3 class="ui header">Register</h3>

			<div class="two fields">
				<div class="field">
					<label>First Name</label>
					<input placeholder="First Name" type="text" ng-model="member.firstName" required>
				</div>
				<div class="field">
					<label>Last Name</label>
					<input placeholder="Last Name" type="text" ng-model="member.lastName" required>
				</div>
			</div>

			<div class="field">
				<label>Username</label>
				<input placeholder="Username" type="text" ng-model="member.username" required>
			</div>

			<div class="field">
				<label>Email</label>
				<input placeholder="Email" type="email" ng-model="member.email" required>
			</div>

			<div class="field">
				<label>Password</label>
				<input type="password" required>
			</div>
			<div class="field">
				<label>Confirm Password</label>
				<input type="password" required>
			</div>

			<div class="inline field">
				<div class="ui checkbox">
					<input type="checkbox" id="terms">
					<label for="terms">I agree to the terms and conditions</label>
				</div>
			</div>
			<input type="submit" value="Register" class="ui blue submit button"/>
		</form>
	</div>
	<div class="nine wide right column">
		<div class="ui fluid">
			<h3 class="ui header">Acme honored members</h3>
			<table class="ui celled table">
				<thead>
				<tr>
					<th>Username</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				</thead>
				<tbody ng-controller="MembersController">
				<tr ng-repeat="member in repository.members">
					<td>{{member.username}}</td>
					<td>{{member.firstName}}</td>
					<td>{{member.lastName}}</td>
					<td><i class="icon checkmark" ng-show="member.verified"></i>{{member.email}}</td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<script src="${baseURL}/static/javascript/angular.min.js"></script>
<script src="${baseURL}/static/javascript/app.js"></script>
</body>
</html>