<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Taking new contact(not user) details</h1>
	<%String cname=(String) request.getAttribute("cname"); %>
	<%String cemail=(String) request.getAttribute("cemail"); %>
	
	<form action="addcontact" method="post">
		<table>
			<tr><td>Name: </td><td><input type="text" name="cname" value="<%=cname %>"></td></tr>
			<tr><td>Email: </td><td><input type="text" name="cemail" value="<%=cemail %>"></td></tr>
			<tr><td>Phone number: </td><td><input type="number" minlength="10" maxlength="10" name="num" id="phone" placeholder="Enter phone number" autofocus></td></tr>
			<tr><td>Gender: </td>
			<td><input type="radio" name="gender" value="female">Female</td>
			<td><input type="radio" name="gender" value="male">Male</td>
			<td><input type="radio" name="gender" value="other">Other</td>
			</tr>
			<tr><td>Date of Birth:</td><td><input type="text" name="date" id="date" placeholder="Enter birth date"></td></tr>
			<tr><td>Address: </td><td><input type="text" name="address" id="addr" placeholder="Enter address"></td></tr>
			<tr><td>Country: </td>
			<td><select name="country">
			<option value="india">India</option>
			<option value="canada">Canada</option>
			</select></td>
			<td>State: </td>
			<td><select name="state">
			<option value="maha">Maharashtra</option>
			<option value="mp">MadhyaPradesh</option>
			</select></td>
			<td>City: </td>
			<td><select name="state">
			<option value="pune">Pune</option>
			<option value="mumbai">Mumbai</option>
			</select></td></tr>
			<tr><td>Company: </td><td><input type="text" name="company" id="company" placeholder="Enter company"></td></tr>
			<tr><td>Contact image:</td><td></td></tr>
			<tr><td></td><td><input type="submit" name="btn" value="Add Contact"></td><td><input type="reset" name="btn" value="Cancle"></td></tr>
		</table>
	</form>

</body>
</html>