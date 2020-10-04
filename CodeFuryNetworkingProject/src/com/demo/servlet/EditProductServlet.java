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


import com.demo.bean.UserDetails;
import com.demo.service.ContactService;
import com.demo.service.ContactServiceImpl;


/**
 * Servlet implementation class EditProduct
 */
//@WebServlet("/edit")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		
			
		    String uemail=request.getParameter("uEmail");
		    String cemail=request.getParameter("cEmail");
			ContactService contactService=new ContactServiceImpl();
			List<String> uelist=contactService.getUserEmail();
			List<String> celist=contactService.getContactEmail();
			if(uelist.contains("uemail"))
			{  
				UserDetails u=contactService.getByUserEmail(uemail);
				
				request.setAttribute("UserDetails",u);
				RequestDispatcher rd=request.getRequestDispatcher("editproduct.jsp");
				rd.forward(request, response);
			 
			}
			else
			{
				
					UserDetails c=contactService.getByUserEmail(cemail);
					
					request.setAttribute("UserDetails",c);
					RequestDispatcher rd=request.getRequestDispatcher("editproduct.jsp");
					rd.forward(request, response);
				 }
			}
			
			
						
			
		}
		
			
			
		
		
	}


