<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Car</title>
<link rel="stylesheet" type="text/css" href="css/add.css">
</head>
<body>
	<h1>Enter Car Details</h1>
	<form action="AddCar" method="post">
        <input type="text" placeholder="Enter model" name="carModel">
        <input type="text" placeholder="Enter the brand" name="carBrand">
        <input type="number" placeholder="Enter the price" name="carPrice">
        <input type="submit" value="Add">
        <a href="Home.jsp" class="btn">Go to Home</a>
    </form>
</body>
</html>