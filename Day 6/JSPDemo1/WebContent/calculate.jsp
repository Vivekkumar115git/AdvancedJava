<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="MyError.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Header.html" %>
<%!

public void jspInit(){
	System.out.print("in jsp init method");
}
public void jspDestroy(){
	System.out.print("in jsp destroy method");
}
  public int addition(int a,int b){
	return a+b;
}
public int factorial(int n){
	int f=1;
	for(int i=1;i<=n;i++){
		f=f*i;
	}
	return f;
}

%>
   <%
     
     int num1=Integer.parseInt(request.getParameter("num1"));
     String btn=request.getParameter("btn");
     String s=null;
     
     switch(btn){
     case "add":
    	 int num2=Integer.parseInt(request.getParameter("num2"));
    	 int ans=addition(num1,num2);
    	 %>
    	  <h3>Addition : <%=ans%>  </h3>
    	 <%
    	 break;
         case "fact":
    	 ans=factorial(num1);
    	 %>
    	 <h3>Factorial : <%=ans%> </h3>
    	 
    	 <%
    	
    	 break;
  
     }
    
   %>
   <%@include file="footer.html" %>
</body>
</html>