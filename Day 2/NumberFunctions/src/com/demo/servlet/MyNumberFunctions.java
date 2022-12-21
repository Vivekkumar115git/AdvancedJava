package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyNumberFunctions extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		int num = Integer.parseInt(req.getParameter("num"));
		String choice = req.getParameter("btn");
		
		switch(choice) {
	
		case "fact":
			int ans = factorial(num);
			out.println("<h1> Factorial is :"+ans+"</h1>");
			break;
			
		case "prime":
			boolean status = checkPrime(num);
			if(status) out.println("<h1> The number is a prime number</h1>");
			else out.println("<h1> The number is not a prime number</h1>");
			break;
			
		case "digitSum":
			int sum = digitSum(num);
			out.println("<h1> sum is : "+sum+"</h1>");
			break;
		
		}
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException{
		System.out.println("in post method");
		doGet(req, res);
	}
	
	public int factorial(int num) {
		int fact = 1;
		for(int i=1;i<=num;i++) {
			fact*=i;
		}
		return fact;
	}
	
	public boolean checkPrime(int num) {
		for(int i=2;i<num;i++) {
			if(num%i==0) return false;
		}
		return true;
	}
	
	public int digitSum(int num) {
		int sum = 0;
		
		while(num>0) {
			sum+=num%10;
			num/=10;
		}
		return sum;
	}


}


