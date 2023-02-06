<%@page import="jsp_practice1_dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%Employee employee=(Employee)request.getAttribute("employee");%>
<form action="edit" method="post">
Id <input type="number" name="id" value="<%=employee.getId() %>" readonly="true">
Name <input type="text" name="name" value="<%=employee.getName() %>">
Address <input type="text" name="address" value="<%=employee.getAddress() %>" >
Phone <input type="tel" name="phone" value="<%=employee.getPhone()%>" >
Email <input type="email" name="email" value="<%=employee.getEmail() %>" >
<br>
Password <input type="text" name="password" value="<%=employee.getPassword() %>" >
 <input type="submit" name="Submit">

</form>
</body>
</html>