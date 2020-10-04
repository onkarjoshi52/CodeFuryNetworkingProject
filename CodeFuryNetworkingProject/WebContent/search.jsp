<%@ page language="java" import="com.demo.bean.UserDetails,com.demo.bean.ContactDetails,java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%UserDetails u=(UserDetails)request.getAttribute("UserDetails");
ContactDetails c=(ContactDetails)request.getAttribute("ContactDetails");
%>

 <form action="delete">
<table border="2">
    <tr><th>Contact Email</th><th>Contact Name</th><th>Contact Mob</th><th>Contact City</th><th>Edit</th><th><button type="submit" name="btn" id="sub" value="delete">Delete</button></th></tr>
 if(u!=null)
 {
  <tr><td><%=u.getUemail() %></td>
   <td><%=u.getUfullName() %></td>
    <td><%=u.getUmob() %></td>
     <td><%=u.getUcity() %></td>
      
       <td>
         <a href="edit?pid=<%=u.getUemail()%>">edit</a>
      </td>
      <td>
         
          <input type="checkbox" name="delete"  value="<%=u.getUemail() %>" >Delete<br>
      </td>
     
   </tr>
  }
  else
  {
   <tr><td><%=c.getCemail() %></td>
   <td><%=c.getCfullName() %></td>
    <td><%=c.getCmob() %></td>
     <td><%=c.getCcity() %></td>
      
       <td>
         <a href="edit?pid=<%=c.getCemail()%>">edit</a>
      </td>
      <td>
         
          <input type="checkbox" name="delete"  value="<%=c.getCemail() %>" >Delete<br>
      </td>
     
   </tr>
  }

 </table>
 </form>
 
 <a href="viewcontact">Go To Contact List</a>
</body>
</html>