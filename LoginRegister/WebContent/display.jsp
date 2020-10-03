<%@ page language="java" import="com.demo.bean.UserDetails,java.text.SimpleDateFormat" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% UserDetails u=(UserDetails)request.getAttribute("img");
	%>
	<h3>City:</h3> <%=u.getUimage() %>
</body>
</html>