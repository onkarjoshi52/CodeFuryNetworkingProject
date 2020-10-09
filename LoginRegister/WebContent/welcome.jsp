<%@ page language="java" import="com.demo.bean.UserDetails" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%UserDetails user=(UserDetails)session.getAttribute("user details"); %>
</head>
<body>

<h1>Welcome <%=user.getUname()%></h1>
</body>
</html>