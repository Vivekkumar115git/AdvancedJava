package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.User;

public class AdminServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		HttpSession session=request.getSession();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		User u=(User) session.getAttribute("user");
		if(u!=null && u.getRole().equals("admin")) {
			response.setContentType("text/html");
			
			out.println("in admin servlet");
		}
		else {
			out.println("pls enter credentials");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request,response);
			
			
		}
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		doPost(request,response);
	}

}
