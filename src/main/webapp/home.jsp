<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<style>
body {
	font-family: 'Poppins', sans-serif;
}

nav {
	display: flex;
	justify-content: space-between;
}

nav h2 {
	color: white;
	font-weight: 700;
}

#nav-bar {
	background-color: black;
	padding: 10px;
}

.skills-info {
	max-width: 100%;
	display: grid;
	grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
	gap: 20px;
	margin: 0 auto;
}

.education {
	
	border-radius: 10px;
}

.education p a {
	text-decoration: none;
	color: #251199;
}

.education p a:hover {
	color: deeppink
}

.main-content {
	margin-bottom: 30px;
}

footer {
	background-color: rgb(77, 27, 99);
	color: white;
	height: 60vh;
	padding-top: 10px;
}

#footer-1 {
	display: flex;
	justify-content: space-between;
}

#footer-1 a {
	text-decoration: none;
	color: white;
}

#footer-1 a:hover {
	color: deeppink;
}

#footer-1 h1 {
	font-weight: 700;
}

.copy-rights {
	align-items: center;
	padding-top: 30px;
}

@media only screen and (max-width: 970px) {
	#footer-1 {
		flex-direction: column;
		justify-content: center;
		align-items: center;
		padding-top: 20px;
	}
	.profile {
		text-align: center;
	}
	.link {
		padding-bottom: 30px;
	}
}
</style>

	<section id="nav-bar">
		<nav class="container">
			<div class="logo">
				<h2>Employee Portal</h2>
			</div>
			<div class="navlinks">
				<form:form action="/logout">
					<div class="form-group">
						<button style="width: 100%;" type="submit"
							class="btn btn-outline-danger ">Logout</button>
					</div>
				</form:form>
			</div>
		</nav>

	</section>
	<section class="main-content">
		<div class="container mt-4">
			<h1>Employee List :</h1>
			<br>
			<div class="form-group" style="float: right;">
				<a href="/addEmployee"><button type="submit"
						class="btn btn-outline-primary ">Add Employee</button></a>
			</div>
			<br> <br>
			<!--  <table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">S.no</th>
						<th scope="col">First Name</th>
						<th scope="col">Last Name</th>
						<th scope="col">Designation</th>
						<th scope="col">Modify</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${empList}" var="emp" varStatus="loop">
						<tr>
							<td><c:out value="${loop.index+1 }" /></td>
							<td><c:out value="${emp.firstName}" /></td>
							<td><c:out value="${emp.lastName}" /></td>
							<td><c:out value="${emp.designation}" /></td>
							<td><a href="/${emp.id}">Edit</a> / <a href="/delete/${emp.id}">delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>-->

			<div class="skills-info education-all">


				<c:forEach items="${empList}" var="emp" varStatus="loop">
					<div class="shadow p-3 mb-5 bg-white education">
						<div>
							<p>
								S.No : <b><c:out value="${loop.index+1 }" /></b>
							</p>
							<p>
								First name: <b><c:out value="${emp.firstName}" /></b>
							</p>
							<p>
								Last name: <b><c:out value="${emp.lastName}" /></b>
							</p>
							<p>
								Designation: <b><c:out value="${emp.designation}" /></b>
							</p>
							<p>
								Modify: <b><a href="/${emp.id}">Edit</a> / <a
									href="/delete/${emp.id}">delete</a></b>
							</p>
						</div>
					</div>
				</c:forEach>



			</div>


		</div>
	</section>
	<footer>
		<div class="container" id="footer-1">

			<div class="profile link">
				<h1>SWAMY THUDUM</h1>
				<hr>
				<p>
					<b>Java Developer</b>
				</p>
				<a href="mailto:thudumswamy786@gmail.com">thudumswamy786@gmail.com</a>
			</div>


			<div class="social-media link">
				<p>
					<a href="#">Facebook</a>
				</p>
				<p>
					<a href="#">Twitter</a>
				</p>
				<p>
					<a href="#">Whatsapp</a>
				</p>
			</div>
			<div class="copy-rights link">
				<p>Allrights Reserved By @thisis_swamy</p>
			</div>

		</div>
	</footer>


</body>
