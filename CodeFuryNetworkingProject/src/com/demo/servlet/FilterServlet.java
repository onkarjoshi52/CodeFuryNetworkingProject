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
 * Servlet implementation class FilterServlet
 */
//@WebServlet("/filter")
public class FilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
	    String city=request.getParameter("filter1");
	    ContactService contactService=new ContactServiceImpl();
	    List<String> uelist=contactService.getUserEmail();
		List<String> celist=contactService.getContactEmail();
	   
		       
			 ContactDetails c=contactService.searchBycity(city);
			    request.setAttribute("ContactDetails",c);
		  
	
		
	   
		
		RequestDispatcher rd=request.getRequestDispatcher("search.jsp");
		rd.forward(request, response);
	}

	

}
