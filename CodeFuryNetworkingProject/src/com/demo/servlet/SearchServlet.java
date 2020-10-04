package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.bean.ContactDetails;

import com.demo.bean.UserDetails;
import com.demo.service.ContactService;
import com.demo.service.ContactServiceImpl;


/**
 * Servlet implementation class SearchServlet
 */
//@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
	    //String mytest = (String)request.getAttribute("name");
		String param1 = request.getParameter("prodName");
		
		ContactService contactService=new ContactServiceImpl();
		List<String> uelist=contactService.getUserEmail();
		List<String> celist=contactService.getContactEmail();
		if(uelist.contains("param1"))
		{
		  
		      UserDetails u= contactService.getByUserEmail(param1);
		      request.setAttribute("UserDetails",u);
		  
		
		}
		else
		{
		 
		       
		      ContactDetails c= contactService.getByContactEmail(param1);
		      request.setAttribute("ContactDetails",c);
		  
		  
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("search.jsp");
		rd.forward(request, response);
		
	}

	
}
