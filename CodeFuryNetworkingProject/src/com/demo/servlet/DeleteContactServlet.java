package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
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
 * Servlet implementation class DeleteProduct
 */
//@WebServlet("/delete")
public class DeleteContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		
			String[] email =request.getParameterValues("delete");
			ContactService contactService=new ContactServiceImpl();
			List<String> uelist=contactService.getUserEmail();
			List<String> celist=contactService.getContactEmail();
			if(uelist.contains("email"))
			{
			  for( String s:uelist) { 
			       
			      UserDetails u= contactService.getByUserEmail(s);
			       contactService.deleteContact(u);
			       System.out.println("Contact deleted");
			  
			  }
			}
			else
			{
			  for( String s:celist) { 
			       
			      ContactDetails c= contactService.getByContactEmail(s);
			       contactService.deleteContact(c);
			       System.out.println("Contact deleted");
			  
			  }
			}
			
			
		
		
		RequestDispatcher rd=request.getRequestDispatcher("viewproduct");
		rd.forward(request, response);
		
	}
	

}
