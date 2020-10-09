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
		if(ulist.isEmpty())
			System.out.println("Ulist empty");
	%>
	<table border="2">
		<tr><th>User id</th><th>User email</th><th>Action</th></tr>
		<%for(User u : ulist) { %>
			
			<tr><td><%=u.getUid() %></td>
				<td><%=u.getUemail() %></td>
				<td>
					<a href="UnblockServlet?uemail=<%=u.getUemail() %>">Unblock user</a>
				</td>
			 </tr>
		<% } %>
	</table>
	<br>
</body>
</html>