<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<style>
body {
	font-family: 'Poppins', sans-serif;
}
</style>
</head>
<body style="background-color: darkcyan;">
	<div class="container">
		<c:if test="${param.error != null }">
			<div
				class="mt-4 alert alert-danger container shadow  col-md-6 justify-content-center "
				role="alert">Invalid Username/password! Please Enter Valid
				Credentials...</div>
		</c:if>
		<c:if test="${param.logout != null}">
			<div
				class="mt-4 alert alert-success container shadow  col-md-6 justify-content-center "
				role="alert">Successfully logged out ! please login again...</div>
		</c:if>

	</div>

	<div class="container shadow  col-md-3 justify-content-center "
		style="padding: 20px; margin-top: 20px; border-radius: 10px; width: 400px; font-family: sans-serif; background-color: white;">
		<div>
			<h1 class="text-center">
				<b>Login</b>
			</h1>
			<hr>

		</div>
		<br>
		<form:form>
			<div class="form-group">
				<label for="">Username</label> <input type="text"
					class="form-control" placeholder="Enter username" name="myname">
			</div>
			<div class="form-group">
				<label for="">Password</label> <input type="text"
					class="form-control" placeholder="Enter password" name="pass">
			</div>
			<br>
			<div class="form-group">
				<button style="width: 100%;" type="submit"
					class="btn btn-outline-primary ">Login</button>
			</div>
			<hr>
			<small class="text-danger" style="margin-bottom: 15px;">Don't
				Have account ? Create One</small>
			<div class="form-group">
				<a href="/register"><button style="width: 100%;" type="button"
						class="btn btn-outline-success ">Create Account</button></a>
			</div>
			<br>

		</form:form>

	</div>

</body>