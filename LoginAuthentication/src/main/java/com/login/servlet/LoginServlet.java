package com.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.beans.User;
import com.login.service.LoginService;
import com.login.service.LoginServiceImpl;

public class LoginServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String uname=req.getParameter("nm");
		String pass=req.getParameter("passwd");
		LoginService ls=new LoginServiceImpl();
		User u=ls.validateUser(uname, pass);
		if(u!=null) {
			if(u.getRole().equals("admin")) {
				RequestDispatcher rd=req.getRequestDispatcher("admin");
				rd.forward(req, res);
			}
			else {
				RequestDispatcher rd=req.getRequestDispatcher("userservlet");
				rd.forward(req,res);
			}
		}
		else {
			out.println("Invalid credentials");
			
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		
	}

	
}
