package com.demo.servlet;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.demo.bean.UserDetails;
import com.demo.service.*;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//static SimpleDateFormat sdf;
	public void init() {
		//sdf=new SimpleDateFormat("yyyy-MM-dd");
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");

		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String mob=request.getParameter("mob");
		String gender=request.getParameter("gender");
		String username=request.getParameter("username");
		String pass=request.getParameter("pass");
		String dob=request.getParameter("dob");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		String company=request.getParameter("company");
		String image=request.getParameter("img");
		String supportQ=request.getParameter("supportQ");
		String supportA=request.getParameter("supportA");
		
		BufferedImage bImage = ImageIO.read(new File(image));
		RegisterService registerService=new RegisterServiceImpl();

		Date dt=Date.valueOf(dob);
		
			
			UserDetails userDetails=new UserDetails(email,name,username,pass,mob,gender,dt,address,city,state,country,company,bImage,supportQ,supportA);
			registerService.saveDetails(userDetails);
			request.setAttribute("User Details", userDetails);
			RequestDispatcher rd=request.getRequestDispatcher("display.jsp");
			rd.forward(request, response);
			
		
		
		
	}
		
	
}