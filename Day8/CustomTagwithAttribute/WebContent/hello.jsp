<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/myHello" prefix="say" %>
<%@taglib uri="/mysub" prefix="mytag" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
    String lname="Khadilkar";
    String fname="Kishori";

%>
  <say:hello lastName="<%=lname%>" firstName="<%=fname%>"> 
  </say:hello>
  <say:add num1="10" num2="30"></say:add>
  
  <say:hello lastName="Joshi" firstName="Deepa"> 
  </say:hello>
  <mytag:subtract num1="50" num2="30"></mytag:subtract>
  
  
</body>
</html>