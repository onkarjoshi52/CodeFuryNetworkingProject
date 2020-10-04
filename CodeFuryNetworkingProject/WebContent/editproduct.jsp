<%@ page language="java" import="com.demo.bean.UserDetails,com.demo.bean.ContactDetails,java.util.*"  contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <% UserDetails u=(UserDetails)request.getAttribute("UserDetails");
    ContactDetails c=(ContactDetails)request.getAttribute("ContactDetails"); %>
   
   <form action="/ProductCatDemo/update" method="post" >
   if(u!=null)
   {
       Contact Email : <input type="hidden" name="uemail" value="<%=u.getUemail() %>"  >
       Contact Name : <input type="text" name="uname" value="<%=u.getUfullName() %>">
       Mobile: <input type="text" name="umob" value="<%=u.getUmob() %>">
       city : <input type="text" name="ucity" value="<%=u.getUcity()%>">
       
       <input type="submit" name="btn" value="update">
    }
    else
    {
       
       Contact Email : <input type="hidden" name="cemail" value="<%=c.getCemail() %>"  >
       Contact Name : <input type="text" name="cname" value="<%=c.getCfullName() %>">
       Mobile: <input type="text" name="cmob" value="<%=c.getCmob() %>">
       city : <input type="text" name="ccity" value="<%=c.getCcity()%>">
       
       <input type="submit" name="btn" value="update">
    
    }
   </form>
</body>
</html>