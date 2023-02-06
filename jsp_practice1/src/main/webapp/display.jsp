<%@page import="jsp_practice1_dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String names = (String) request.getAttribute("name");
	%>
	<%
	List<Employee> list = (List) request.getAttribute("list");
	%>
	<%
	if (names != null) {
	%>
	<h3>
		ChangedBy:
		<%= names %></h3>
	<%
	}
	%>
	<table border="2px">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Address</th>
			<th>Phone</th>
			<th>Email</th>
			<th>Password</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>

		<%
		for (Employee employee : list) {
		%>
		<tr>
			<td><%=employee.getId()%></td>
			<td><%=employee.getName()%></td>
			<td><%=employee.getAddress()%></td>
			<td><%=employee.getPhone()%></td>
			<td><%=employee.getEmail()%></td>
			<td><%=employee.getPassword()%></td>
			<td><a href="delete?id=<%=employee.getId()%>">Delete</a></td>
			<td><a href="update?id=<%=employee.getId()%>">Update</a></td>

		</tr>
		<%
		}
		%>

	</table>
</body>
</html>