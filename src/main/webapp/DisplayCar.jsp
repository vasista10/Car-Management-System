<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cars</title>
<link rel="stylesheet" type="text/css" href="css/display.css">
</head>
<body>
	<% ResultSet rs = (ResultSet) request.getAttribute("resultSet");%>
	<h1>Cars</h1>
	 <table>
        <tr>
            <th>Car Id</th>
            <th>Model</th>
            <th>Brand</th>
            <th>Price</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <% while(rs.next()){ %>
        <tr>
            <td><%=rs.getInt(1) %></td>
            <td><%=rs.getString(2) %></td>
            <td><%=rs.getString(3) %></td>
            <td><%=rs.getInt(4) %></td>
            <td><a href="update-car?carId=<%=rs.getInt(1) %>">UPDATE</a></td>
            <td><a href="delete-car?carId=<%=rs.getInt(1) %>" class="delete">DELETE</a></td>
        </tr>
        <% } %>
    </table>
    <a href="Home.jsp" class="btn">Go to Home</a>
</body>
</html>