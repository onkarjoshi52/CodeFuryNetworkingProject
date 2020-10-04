package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.Contact;
import com.demo.service.ContactService;
import com.demo.service.ContactServiceImpl;


//@WebServlet("/addcontact")
public class AddContactDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String email=(String) request.getParameter("cemail");
		String name=(String) request.getParameter("cname");
		String number=request.getParameter("num");
		String gender=request.getParameter("gender");
		String bdate=request.getParameter("date");
		String addr=request.getParameter("address");
		String country=request.getParameter("country");
		String state=request.getParameter("state");
		String city=request.getParameter("city");
		String company=request.getParameter("company");
		Contact contact=new Contact(email,name,number,gender,bdate,addr,country,state,city,company);
		ContactService contactService=new ContactServiceImpl();
		int status=contactService.addNewContact(contact);
		out.println("New contact added successfully");
		///change path to home page of user
		RequestDispatcher rd=request.getRequestDispatcher("addnewcontact.html");
		rd.forward(request, response);
	}

}
