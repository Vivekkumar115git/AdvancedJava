<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="i" value="12"></c:set>
Variable i : <c:out value="${i}"></c:out>

<c:if test="${i<15}">
    <h1>less than 15</h1>
</c:if>

<c:forEach var="i" begin="1" end="5">
     <c:out value="${i}"></c:out>

</c:forEach>

<%-- <table>
<c:forEach var="p" items="${plist}">
   <tr>
   <td>${p.pid}<td>
   <td>${p.pname} </td>
   <td>${p.qty}</td>
   <td>${p.price}</td>
   </tr>
</c:forEach>
</table> --%>
<c:set var="c" value="y"></c:set>

<c:choose>
  <c:when test="${c=='R'}">
      you selected red
  </c:when>
<c:when test="${c=='y'}">
      you selected yellow
  </c:when>
  <c:otherwise>
      This is default case
  </c:otherwise>

</c:choose>


</body>
</html>