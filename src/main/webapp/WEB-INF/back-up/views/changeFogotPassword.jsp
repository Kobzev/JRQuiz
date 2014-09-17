<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JavaRush | Registration Form</title>
</head>
<body>
	<center>

		<div style="color: teal; font-size: 30px">JavaRush | Registration Form</div>



		<c:url var="forgotPassword" value="saveUser.html" />
		<form:form id="forgotPassword" modelAttribute="user" method="post"
			action="saveUser">
			<table width="800px" height="150px">
				<tr>
					<td><form:label path="password">new password</form:label></td>
					<td><form:input path="password" /><form:errors path="password" /></td>
					<td><form:input type="hidden" readonly="true" path="id" value="${user.id}" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Save" />
					</td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>
