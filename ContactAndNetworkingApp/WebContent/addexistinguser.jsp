<%@ page language="java" import="com.demo.bean.UserDetails,java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% UserDetails user=(UserDetails) request.getAttribute("user"); %>
	<%--redirect to user homepage --%>
	<form action="addnewcontact.html" method="post">
		<table>
			<tr><td>Name: </td><td><%=user.getUfullName() %></td></tr>
			<tr><td>Email: </td><td><%=user.getUemail() %></td></tr>
			<tr><td>Phone: </td><td><%=user.getUmob() %></td></tr>
			<tr><td>Gender: </td><td><%=user.getUgender() %></td></tr>
			<tr><td>Date of Birth: </td><td><%=user.getUbdate() %></td></tr>
			<tr><td>Address: </td><td><%=user.getUaddress() %></td></tr>
			<tr><td>Country: </td><td><%=user.getUcountry() %></td></tr>
			<tr><td>State: </td><td><%=user.getUstate() %></td></tr>
			<tr><td>City: </td><td><%=user.getUcity() %></td></tr>
			<tr><td>Company: </td><td><%=user.getUcompany() %></td></tr>
			<tr><td><input type="submit" name="btn" value="Add contact"></td>
			<td><input type="reset" name="btn" value="Cancle"></td>
		</table>
	</form>

</body>
</html>