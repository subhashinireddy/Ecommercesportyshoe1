<%@page import="com.example.demo.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<Product> list=(List<Product>)request.getAttribute("list"); %>

<table border="1">
<tr><th>SId</th><th>SName</th><th>SCost</th><th>Buy Product</th></tr>
<%for(Product p:list){ %>

<tr><td><%=p.getId()%></td><td><%=p.getName() %></td><td><%=p.getCost() %></td><td><a href="addToCart.jsp">Add To Cart</a></td></tr>

<%}%> 
</body>
</html>