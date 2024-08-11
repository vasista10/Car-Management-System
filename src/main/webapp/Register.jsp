<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
	<div class="login-container">
		<h1>User Registeration</h1>
			<form action="Register" method="post">
				<input type="text" placeholder="Enter your name" name="userName">
				<input type="email" placeholder="Enter your email" name="userEmail">
				<input type="number" placeholder="Enter your phone no" name="userPhone">
				<input type="password" placeholder="Enter password" name="userPassword">
				<input type="password" placeholder="Confirm Password" name="confirmPassword">
				<input type="submit" value="Register">
			</form>
			<p class="register-link">
		        Aldready have an account? <a href="login.jsp">Login here</a>.
		    </p>
	</div>
</body>
</html>