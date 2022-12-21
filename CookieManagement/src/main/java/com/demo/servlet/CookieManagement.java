package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookiedetails")
public class CookieManagement extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String btn=request.getParameter("btn");
		String cname=request.getParameter("cname");
		String desc=request.getParameter("description");
		RequestDispatcher rd=request.getRequestDispatcher("cookiedetails.html");
		
		switch(btn) {
		
		case "add":
			Cookie c=new Cookie(cname,desc);
			
			response.addCookie(c);
			out.println("Cookie added successfully!");
			rd.include(request, response);
			break;
			
		case "delete":
			Cookie[] carr=request.getCookies();
			for(Cookie c1:carr) {
				if(c1.getName().equals(cname)) {
					c1.setMaxAge(0);
					response.addCookie(c1);
					break;
				}
			}
			out.println("Cookie deleted Successfully!");
			rd.include(request, response);
			break;
			
			
		case "show":
			carr=request.getCookies();
			for(Cookie c1:carr) {
				out.println("<h4>"+c1.getName()+"----->"+c1.getValue()+"</h4>");
				
			}
			rd.include(request, response);
			break;
		}
		
	}

}
