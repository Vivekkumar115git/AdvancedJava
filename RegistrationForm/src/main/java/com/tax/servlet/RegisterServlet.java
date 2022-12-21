package com.tax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String name=req.getParameter("name");
		out.println("<h2>Name:-"+name+"</h2>");
		
		
		
	}
	
//	public void doPost(HttpServletRequest req,HttpServletResponse res) {
//		
//		
//	}
	
}
