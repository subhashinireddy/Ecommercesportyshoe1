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
<form action="/add"> 
<input type="submit" value=" Add product">

<%List<Product> list=(List<Product>)request.getAttribute("list"); %>

<table border="1">
<tr><th>SId</th><th>SName</th><th>SCost</th><th>Edit Operation</th><th>Delete Operation</th></tr>
<%for(Product p:list){ %>

<tr><td><%=p.getId()%></td><td><%=p.getName() %></td><td><%=p.getCost() %></td><td><a href="edit.jsp">Edit</a></td><td><a href="delete.jsp">Delete</a></td></tr>

<%}%> 

</body>
</html>