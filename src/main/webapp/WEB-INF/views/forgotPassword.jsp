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
<a href="<%=request.getContextPath()%>/j_spring_security_logout">Logout</a>
	<center>

		<div style="color: teal; font-size: 30px">JavaRush | Registration Form</div>



		<c:url var="forgotPassword" value="saveUser.html" />
		<form:form id="forgotPassword" modelAttribute="user" method="post"
			action="rememberPassword">
			<table width="800px" height="150px">
				<tr>
					<td><form:label path="email">email</form:label></td>
					<td><form:input path="email" /><form:errors path="email" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Remind me" />
					</td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>
