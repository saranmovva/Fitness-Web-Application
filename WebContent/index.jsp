<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link type="text/css" rel="stylesheet" href="css/materialize.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<script src="js/jquery.js"></script>
	<script src="js/materialize.min.js"></script>
	<div class="parallax-container">
		<div class="parallax">
			<img src="images/loginpage.jpeg">
		</div>
	</div>
	<div class="section white z-depth-5">
		<div class="row container">
			<ul id="LoginRegistrationTab" class="tabs tabs-fixed-width"
				style="overflow-x: hidden">
				<li class="tab"><a class="active waves" href="#LoginDiv">Login</a></li>
				<li class="tab"><a href="#RegisterDiv">Register </a></li>
			</ul>

			<div id="LoginDiv" class="col s12 z-depth-3 card-panel">
				<form action="LoginServlet" action="post">
					<div class="input-field col s6 offset-s3 center-align ">
						<input id="loginEmail" name="LoginEmail" type="email"
							class="validate" value="${loginEmail}"> <label
							for="loginEmail">Email</label>
					</div>

					<div class="input-field col s6 offset-s3 center-align">
						<input id="loginPassword" name="LoginPassword" type="password"
							class="validate"> <label for="loginPassword">Password</label>
					</div>

					<div class="input-field col s6 offset-s3 center-align">
						<button class="btn waves-effect waves-light" type="submit"
							name="LoginButton">
							Login <i class="material-icons right">send</i>
						</button>
					</div>
					<div class="input-field col s6 offset-s3 center-align"></div>
				</form>
			</div>

			<div id="RegisterDiv" class="col s12 z-depth-3 card-panel">
				<br> <br>
				<form action="RegistrationServlet" method="post">
					<div class="input-field col s6 offset-s3 center-align ">
						<input id="FirstName" name="FirstName" type="text"
							class="validate" value="${FirstName}"> <label
							for="FirstName">First Name</label>
					</div>
					<div class="input-field col s6 offset-s3 center-align ">
						<input id="LastName" name="LastName" type="text" class="validate"
							value="${LastName}"> <label for="LastName">Last
							Name</label>
					</div>
					<div class="input-field col s6 offset-s3 center-align ">
						<input id="Email" name="Email" type="email" class="validate"
							value="${Email}"> <label for="Email">Email</label>
					</div>

					<div class="input-field col s6 offset-s3 center-align">
						<input id="Password" name="Password" type="password"
							class="validate"> <label for="Password">Password</label>
					</div>
					<div class="input-field col s6 offset-s3 center-align">
						<input id="ConfirmPassword" name="ConfirmPassword" type="password"
							class="validate"> <label for="ConfirmPassword">Confirm
							Password</label>
					</div>

					<div class="input-field col s6 offset-s3 center-align">
						<button class="btn waves-effect waves-light" type="submit"
							name="RegisterButton">
							Register <i class="material-icons right">send</i>
						</button>
					</div>
					<div class="input-field col s6 offset-s3 center-align"></div>
				</form>
			</div>

		</div>
	</div>
	<div class="parallax-container">
		<div class="parallax">
			<img src="images/loginpage.jpeg">
		</div>
	</div>
</body>
</html>