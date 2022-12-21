package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<h1>This is second servlet</h1>");
		out.println("<h2>this is second line</h2>");
		
		
	}

}
