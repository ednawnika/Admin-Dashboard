<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
		<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
			<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
			<meta charset="utf-8">
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

		<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>

		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>Admin Page</title>
		</head>

		<body>
			<div class="container">
			<h1>Welcome to the Admin Page
				<c:out value="${currentUser.username}"></c:out>
			</h1>

			<form id="logoutForm" method="POST" action="/logout">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<input type="submit" value="Logout!" />
			</form>
			<br>



			<br>
			
				<table>
					<thead>
						<tr>
						<th>Name</th>
						<th>Email</th>
						<th>Action</th>
						</tr>
					</thead>
					<tbody>
	
						<c:forEach var="admin" items="${users}">
						
					<tr>
						<td><c:out value="${admin.username}"/></td>
						<td><c:out value="${admin.firstname}" /></td>		
							<td>
							<c:forEach var="role" items="${admin.roles}">
								<c:if test="${role.name.equals('ROLE_USER')}">User
									<a href="admin/delete/${admin.id}">Delete</a>
									<a href="admin/upgrade/${admin.id}">Make-Admin</a>
										
								</c:if>
								<c:if test="${role.name.equals('ROLE_ADMIN')}">ADMIN</c:if>	
							</c:forEach>
							</td>
				</c:forEach>
			</tbody>
				</table>
</div>

	


						
			







		</body>

		</html>