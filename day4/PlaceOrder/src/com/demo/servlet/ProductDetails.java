package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductDetails
 */
@WebServlet("/findprod")
public class ProductDetails extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		int catid=Integer.parseInt(request.getParameter("catid"));
		ProductService pservice=new ProductServiceImpl();
		List<Product> plist=pservice.getByCategory(catid);
		out.println("<form action='generatecart' method='get'>");
		int cnt=1;
		for(Product p:plist) {  
			String str=p.getPid()+":"+p.getPname()+":"+p.getPrice();  ///1:lays:40
			out.println("<input type='checkbox' name='prod' id='p"+cnt+"' value='"+str+"'><label for='p"+cnt+"'>"+p.getPname()+"-----"+p.getPrice()+"<lable><br>");
			cnt++;
			
		}
		     
		out.println("<button type='submit' name='btn' id='btn'>Add to cart</button>");
		out.print("</form>");
		
		
	}

}
