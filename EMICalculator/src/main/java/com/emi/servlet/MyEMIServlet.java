package com.emi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyEMIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		System.out.println("Get are called!");
		double TotalAmount,Emi;
		double amount=Double.parseDouble(request.getParameter("amount"));
		double rate=Double.parseDouble(request.getParameter("rate"));
		int n=Integer.parseInt(request.getParameter("numberyear"));
		TotalAmount=(amount + ((amount*rate)/100))*n;
		Emi=TotalAmount/12;
		
		out.println("<h2>Loan Amount:- "+amount+"</h2>");
		out.println("<h2>Interest:- "+rate+"</h2>");
		out.println("<h2>Total Amount:-"+TotalAmount+"</h2>");
		out.println("<h2>EMI:-"+Emi+"</h2>");
		
		
		
		
		
	}
}
