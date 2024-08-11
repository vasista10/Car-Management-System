<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
<link rel="stylesheet" type="text/css" href="css/add.css">
</head>
<body>
	 <% ResultSet rs = (ResultSet) request.getAttribute("resultSet");
	 	rs.next();
    %>
    
    <h1>Update Here</h1>
    <form action="save-updated-car" method="post">
        <input type="number" value="<%= rs.getInt(1) %>" name="carId" readonly="readonly">
        <input type="text" value="<%= rs.getString(2) %>" name="carModel">
        <input type="text" value="<%= rs.getString(3) %>" name="carBrand">
        <input type="number" value="<%= rs.getInt(4) %>" name="carPrice">
        <input type="submit" value="UPDATE">
        <a href="Home.jsp" class="btn">Go to Home</a>
    </form>
</body>
</html>