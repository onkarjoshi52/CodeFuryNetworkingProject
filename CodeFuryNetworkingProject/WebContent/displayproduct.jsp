<%@ page language="java" import="java.util.*,com.demo.bean.UserDetails,com.demo.bean.ContactDetails" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <table>
  
  <td>
<table  >

<tr>
<td>
<form action="SearchServlet" method="get">
Search By Email: <input type="text" name="prodName" id="name"  >
            
<button type="submit" name="btn" id="sub" value="search">Search</button>

<!-- <a href="SearchServlet?name=name1">Search</a> -->
</form>
</td>

<td>

</td>
</tr>
</table>
</td>
<td>
<form action="filter">
<td>Filter : </td>
  <td><select name="filter">
     <option value="city">Filter By City  </option>
       
      <td>
     <input type="text" name="filter1" id="filter2"  >
     <button type="submit" name="btn" id="sub1" value="search">Search</button>
      </td>
     
    
    
   </select></td> <td></td>
 </form>

</td>


</table>


 <% List<UserDetails> ulist=(ArrayList<UserDetails>)request.getAttribute("ulist");
    List<ContactDetails> clist=(ArrayList<ContactDetails>)request.getAttribute("clist");
 %>
 <form action="delete">
<table border="2">

    <tr><th>User Email</th><th>User Name</th><th>User Mob</th><th>User City</th><th>Edit</th><th><button type="submit" name="btn" id="sub2" value="delete">Delete</button></th></tr>
<%for(UserDetails u:ulist) {%>   
   <tr><td><%=u.getUemail() %></td>
   <td><%=u.getUfullName() %></td>
    <td><%=u.getUmob() %></td>
     <td><%=u.getUcity() %></td>
      
       <td>
         <a href="edit?uEmail=<%=u.getUemail()%>">edit</a>
      </td>
      <td>
         
          <input type="checkbox" name="delete"  value="<%=u.getUemail() %>" >Delete<br>
      </td>
     
   </tr>
  
<%} %>

<%for(ContactDetails c:clist) {%>   
   <tr><td><%=c.getCemail() %></td>
   <td><%=c.getCfullName() %></td>
    <td><%=c.getCmob() %></td>
     <td><%=c.getCcity() %></td>
      
       <td>
         <a href="edit?cEmail=<%=c.getCemail()%>">edit</a>
      </td>
      <td>
         
          <input type="checkbox" name="delete"  value="<%=c.getCemail() %>" >Delete<br>
      </td>
     
   </tr>
<%} %>

 </table>
 </form>
<a href="addcontact.jsp">Add Contact</a>
</body>
</html>