<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Info Page</title>
</head>
<body>
<h3>Employee Info Page</h3>

<form:form action="addOrUpdateEmployee" commandName="employeeForm">
<table>
	<tr>
		<td>
			First Name:
		</td>
		<td>
			<form:hidden path="id" /><form:input path="firstName" />
		</td>
	</tr>
	
	<tr>
		<td>
			Last Name:
		</td>
		<td>
			<form:input path="lastName" />
		</td>
	</tr>
	
	<tr>
		<td>
			Middle Name:
		</td>
		<td>
			<form:input path="middleName" />
		</td>
	</tr>
	
	<tr>
		<td>
			Birth Date:
		</td>
		<td>
			<form:input path="birthDate" />
		</td>
	</tr>
	
	<tr>
		<td>
			Gender:
		</td>
		<td>
			<form:input path="gender" />
		</td>
	</tr>
	
	<tr>
		<td>
			Martial Status:
		</td>
		<td>
			<form:input path="martialStatus" />
		</td>
	</tr>
	
	<tr>
		<td>
			Position:
		</td>
		<td>
			<form:input path="position" />
		</td>
	</tr>
	
	<tr>
		<td>
			Date Hired:
		</td>
		<td>
			<form:input path="dateHired" />
		</td>
	</tr>
	
	<tr>
		<td>
			<c:if test="${!empty employeeForm.firstName}">
				<input type="submit" value="Edit Employee" />
			</c:if>
			<c:if test="${empty employeeForm.firstName}">
				<input type="submit" value="Add Employee" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
