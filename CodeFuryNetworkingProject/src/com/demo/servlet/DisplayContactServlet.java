package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
 * Servlet implementation class DisplayContactServlet
 */
//@WebServlet("/viewcontact")
public class DisplayContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		ContactService contactService=new ContactServiceImpl();
		List<String> uelist=contactService.getUserEmail();
		List<String> celist=contactService.getContactEmail();
		List<UserDetails> ulist=new ArrayList<>();
		List<ContactDetails> clist=new ArrayList<>();
		for(String s:uelist)
		{
			ulist.add(contactService.getByUserEmail(s));
		}
		for(String p:celist)
		{
			clist.add(contactService.getByContactEmail(p));
		}
		request.setAttribute("ulist",ulist);
		request.setAttribute("clist",clist);
		RequestDispatcher rd=request.getRequestDispatcher("displayproduct.jsp");
		rd.forward(request, response);
	}


}
