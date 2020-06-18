<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List Home Page</title>
</head>
<body>
<h3>Welcome: <c:out value="${loginForm.userName}" /> type: <c:out value="${loginForm.userType}" /></h3>
<table>
	<tr>
		<td><a href="<c:url value='/forms/loginform.html' />">Back</a></td>
	</tr>
</table>

<c:if test="${loginForm.userType == 'ADMIN'}">
<table>
	<tr>
		<td><a href="<c:url value='/forms/add' />">Add User</a></td>
	</tr>
</table>
</c:if>

<c:if test="${!empty listEmployee}">
	<table class="tg" border="1">
	<tr>
		<th width="120">Name</th>
		<th width="120">Primary Address</th>
		<th width="120">Primary Contact info</th>
		<th width="120">Age</th>
		<th width="120"># of Years in the Company</th>
		<c:if test="${loginForm.userType == 'ADMIN'}">
			<th width="60">Edit</th>
			<th width="60">Delete</th>
		</c:if>
	</tr>
	<c:forEach items="${listEmployee}" var="employee">
		<tr>
			<td>${employee.firstName} ${employee.lastName}</td>
			<td>static data a</td>
			<td>static data b</td>
			<td>static data c</td>
			<td>static data d</td>
			<c:if test="${loginForm.userType == 'ADMIN'}">
				<td><a href="<c:url value='/forms/${employee.id}' />" >Edit</a></td>
				<td><a href="<c:url value='/forms/remove/${employee.id}' />" >Delete</a></td>
			</c:if>
			<c:if test="${loginForm.userType == 'VIEW'}">
				<td>View</td>
			</c:if>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>