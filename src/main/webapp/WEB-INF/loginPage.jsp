<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
		<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>
<head>
	<title>Login Page</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
		
		
<div class="container">
		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>Login Page</title>


		<body>
			<c:if test="${logoutMessage != null}">
				<c:out value="${logoutMessage}"></c:out>
			</c:if>
			<h1>Login</h1>
			<c:if test="${errorMessage != null}">
				<c:out value="${errorMessage}"></c:out>
			</c:if>
			<form method="POST" action="/loginuser">
				<p>
					<label for="username">Username</label>
					<input type="text" id="username" name="username" />
				</p>
				<p>
					<label for="password">Password</label>
					<input type="password" id="password" name="password" />
				</p>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<input type="submit" value="Login!" />
			</form>
												
			
			
			
			

	           
				<h1>Register!</h1> 	

			


				<p>
					<form:errors path="user.*"/>
				</p>
				
			
			
				<form:form method="POST" action="/registration" modelAttribute="user">
					<p>
						<form:label path="username">Username:</form:label>
						<form:input path="username" />
					</p>
						<p>
							<form:label path="firstname">First Name:</form:label>
							<form:input path="firstname" />
						</p>
						<p>
							<form:label path="lastname">Last Name:</form:label>
							<form:input path="lastname" />
						</p>
					<p>
						<form:label path="password">Password:</form:label>
						<form:password path="password" />
					</p>
					<p>
						<form:label path="passwordConfirmation">Password Confirmation:</form:label>
						<form:password path="passwordConfirmation" />
					</p>
					
					<input type="submit" value="Register!" />
				</form:form>
		</body>
</div>
		</html>