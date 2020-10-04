<%@ page language="java" import="java.util.*, com.demo.bean.User" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% List<User> ulist = (ArrayList<User>)request.getAttribute("ulist"); 
	%>
	<table border="2">
		<tr><th>User email</th><th>User Name</th><th>User full name</th><th>User city</th><th>User company</th><th>User id</th><th>Action</th></tr>
		<tr><td>print</td><td>print</td><td>print</td><td>print</td><td>print</td></tr>
		<%for(User u : ulist) { %>
			
			<tr><td><%=u.getUemail() %></td>
				<td><%=u.getUname() %></td>
				<td><%=u.getUfullName() %></td>
				<td><%=u.getUcity() %></td>
				<td><%=u.getUcompany() %></td>
				<td><%=u.getUid() %></td>
				<td>
					<a href="AddFriendServlet?uid=<%=u.getUid() %>">Add Friend</a>/<a href="BlockUserServlet?uid=<%=u.getUid() %>">Block user</a>
				</td>
			 </tr>
		<% } %>
	</table>
	<br>
</body>
</html>