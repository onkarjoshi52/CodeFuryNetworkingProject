package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class UpdateProduct
 */
//@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		String role=(String) session.getAttribute("role");
		
			
			String uemail=request.getParameter("uemail");
			String uname=request.getParameter("uname");
			String umob=request.getParameter("umob");
			String ucity=request.getParameter("ucity");
			
			String cemail=request.getParameter("cemail");
			String cname=request.getParameter("cname");
			String cmob=request.getParameter("cmob");
			String ccity=request.getParameter("ccity");
			
			UserDetails u=new UserDetails(uemail,uname,umob,ucity);
			ContactDetails c=new ContactDetails(cemail,cname,cmob,ccity);
			
			ContactService pService=new ContactServiceImpl();
			if(uemail!=null)
			{
				pService.updatecontact(u);
				System.out.println("product updated");
			}
			else
			{
				pService.updatecontact(c);
				System.out.println("product updated");
			}
			
			//RequestDispatcher rd=request.getRequestDispatcher("viewproduct?cat="+cid);
			RequestDispatcher rd=request.getRequestDispatcher("viewproduct");
			rd.forward(request, response);
		
	}
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   {
		   doPost(request,response);
	   }
   }

}
