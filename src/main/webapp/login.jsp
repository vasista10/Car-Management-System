<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<div class="login-container">
	<h1>User Login</h1>
		
		    <form action="LoginSuccess" method="post">
		        <input type="email" placeholder="Enter your email" name="userEmail">
		        <input type="password" placeholder="Enter your password" name="userPassword">
		        <input type="submit" value="Login">
		    </form>
		    <p class="register-link">
		        Don't have an account? <a href="Register.jsp">Register here</a>.
		    </p>
	 </div>
</body>
</html>
