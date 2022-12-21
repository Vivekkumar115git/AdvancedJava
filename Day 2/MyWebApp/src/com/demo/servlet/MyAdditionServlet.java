package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyAdditionServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		System.out.println("query string : "+request.getQueryString());
		int num1=Integer.parseInt(request.getParameter("num1"));
		int num2=Integer.parseInt(request.getParameter("num2"));
		String btn=request.getParameter("btn");
		switch(btn) {
		case "add":
			int addition=num1+num2;
			out.println("<h1>Addition : "+addition+"</h1>");
			break;
		case "sub":
			int subtraction=num1-num2;
			out.println("<h1>Subtraction : "+subtraction+"</h1>");
		break;
		case "mul":
			int multiply=num1*num2;
			out.println("<h1>Multiplication : "+multiply+"</h1>");
			break;
		}
		
		
	}

}
