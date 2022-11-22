<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Shopping</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>
#first {
	margin-top: 30px;
	margin-left: 20%;
}

#useLogin {
	align-content: center;
	color: blue;
}
</style>

</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">WebSiteName</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#">Page 1</a></li>
				<li><a href="#">Page 2</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
				<li><a href="userlogin.jsp"><span class="glyphicon glyphicon-log-in"></span>
						Login</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<h2>User Signup</h2>
		<form action="./user" method="post">
			<div class="form-group">
				<label for="fname">First Name:</label> <input type="text"
					class="form-control" id="fname" placeholder="Enter First Name"
					name="fname">
			</div>
			<div class="form-group">
				<label for="lname">Last name:</label> <input type="text"
					class="form-control" id="lname" placeholder="Enter LastName"
					name="lname">
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" id="email" placeholder="Enter email"
					name="email">
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" id="password" placeholder="Enter password"
					name="password">
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
<%
             request.getAttribute("validation");
%>
</body>
</html>