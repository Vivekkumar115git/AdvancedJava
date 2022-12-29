<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello Word!!</h1>
<%
Date d=new Date();
int n=5;

%>
<h3>Date : <%=d %></h3>
<%
   if(n>5){
%>
<h3>n is greater<h3>
  <% }
  else{%> 
	  
<h3>n is smaller</h3>
 <%} %> 
<%for(int i=0;i<n;i++){ %>

<h5>The ans : <%=n*i%></h5>


<%} %>
 
  




</body>
</html>