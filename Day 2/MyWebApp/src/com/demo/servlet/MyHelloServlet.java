package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHelloServlet extends HttpServlet{
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("in init method");
	}

	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		System.out.println("In doGet method");
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<h1>Hello world!</h1>");
		out.println("<h2>Welcome to servlet programming</h2>");
		
	}
	
	public void destroy() {
		System.out.println("in destroy method");
	}
}
