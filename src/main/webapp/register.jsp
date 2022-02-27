<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registration Page</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">


</head>
<body style="background-color: darkblue;">
	<style>
body {
	font-family: 'Poppins', sans-serif;
}
a{
text-decoration:none;
color:red;
font-weight:700;
text-align: right;
}
</style>
	<div class="container shadow  col-md-3 justify-content-center "
		style="padding: 40px; margin-top: 20px; border-radius: 10px; width: 400px; font-family: sans-serif; background-color: white;">
		
		<div>
			<h1 class="text-center">
				<b>Register</b>
			</h1>
			<hr>

		</div>
		<form:form action="/register" >
			<div class="form-group">
				<label for="">First Name</label> <input type="text"
					class="form-control" placeholder="Enter your first name"
					name="firstName">
			</div>
			<div class="form-group">
				<label for="">Last Name</label> <input type="text"
					class="form-control" placeholder="Enter your last name"
					name="lastName">
			</div>
			<div class="form-group">
				<label for="">E-mail</label> <input type="text" class="form-control"
					placeholder="Enter Your email address" name="email">
			</div>
			<div class="form-group">
				<label for="">Password</label> <input type="text"
					class="form-control" placeholder="Enter Password" name="password">
			</div>
			<div class="form-group">
				<label for="">Confirm Password</label> <input type="text"
					class="form-control" placeholder="Enter Confirm password"
					name="confirmPassword">
			</div>

			<br>
			<div class="form-group">
				<button style="width: 100%;" type="submit"
					class="btn btn-outline-primary ">Register</button>
			</div>
		</form:form><hr>
		 <div> Login From here.. <a href="/mylogin">Login</a>
		</div>
		<!--  <div class="container">
				<b>If you Registered Please login from here</b><br>
				
		</div>-->
	</div>
	
</body>
</html>
