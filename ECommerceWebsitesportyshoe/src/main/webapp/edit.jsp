<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String id=request.getParameter("id"); %>
<form action="edit">
<input type="hidden" name="id"  value="<%=id%>">
ProductName<input type="text"  name="name"><br>
ProductCost<input type="text"  name="cost"><br>
<input type="submit" value="enter the new details">
</form>
</body>

</body>
</html>