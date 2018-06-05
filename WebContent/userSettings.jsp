<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="edu.ben.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link type="text/css" rel="stylesheet" href="css/materialize.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.modal {
	width: 75% !important;
	max-height: 100% !important;
	overflow-y: hidden !important;
}
</style>
<title>User Settings</title>
</head>
<body>
	<script src="js/jquery.js"></script>
	<script src="js/materialize.min.js"></script>
	<%@ page import="edu.ben.model.User"%>

	<%
		User temp = (User) session.getAttribute("User");
		if (temp == null) {
			response.sendRedirect("index.jsp");
		} else if (temp.getAge() == 0 || temp.getHeight() == 0 || temp.getGender().equals(" ")) {
			response.sendRedirect("Dashboard.jsp");
		}
		else{
	%>
	<nav>
	<div class="container nav-wrapper">
		<a href="#" class="brand-logo">FitnessTracker</a>
		<ul id="nav-mobile" class="right hide-on-med-and-down">
			<li class="active"><a href="Dashboard.jsp">Dashboard</a></li>
			<li><a href="bmrCalculator.jsp">BMR</a></li>
			<li><a href="bmiCalculator.jsp">BMI</a></li>
			<li><a href="userSettings.jsp">Settings</a></li>
			<li><a href="LogoutServlet">Log Out</a></li>
			<li><a class="modal-trigger" href="#modal1"><i
					class="material-icons">search</i></a></li>
		</ul>
	</div>
	</nav>

	<div id="modal1" class="modal">
		<div class="modal-content">
			<h4>Search for Recipes</h4>
			<script>
				(function() {
					var cx = '014434530682917099062:0_z75elo1qw';
					var gcse = document.createElement('script');
					gcse.type = 'text/javascript';
					gcse.async = true;
					gcse.src = 'https://cse.google.com/cse.js?cx=' + cx;
					var s = document.getElementsByTagName('script')[0];
					s.parentNode.insertBefore(gcse, s);
				})();
			</script>
			<gcse:search></gcse:search>
			<br> <br> <br> <br> <br> <br> <br>
			<br> <br>
		</div>

	</div>
	<div class="parallax-container">
		<div class="parallax">
			<img src="images/exercise1.jpg">
		</div>
	</div>
	<br>
	<div class="row">
		<div class="container">
			<fieldset id="disable" disabled="disabled">
				<div class="row">
					<div class="input-field col s4">
						<i class="material-icons prefix">account_circle</i> <input
							placeholder="${sessionScope.User.firstName}" name="firstName"
							id="first_name" type="text" class="validate"> <label
							for="first_name">First Name</label>
					</div>
					<div class="input-field col s4">
						<i class="material-icons prefix">account_circle</i> <input
							placeholder="${sessionScope.User.lastName}" name="lastName"
							id="last_name" type="text" class="validate"> <label
							for="last_name">Last Name</label>
					</div>

					<div class="input-field col s4">
						<i class="material-icons prefix">email</i> <input
							placeholder="${sessionScope.User.email}" name="email" id="email"
							type="email" class="validate"> <label for="email">Last
							Name</label>
					</div>
				</div>
			</fieldset>
		</div>
	</div>
	<form action="UserSettingServlet" method="post">
		<div class="container">
			<div class="row">
				<fieldset id="enable" disabled="disabled">
					<div class="row">
						<div class="input-field col s6">
							<i class="material-icons prefix">lock</i> <input
								value="${sessionScope.User.password}" name="password"
								id="password" type="password" class="validate"> <label
								for="password">Password</label>
						</div>
						<div class="input-field col s6">
							<i class="material-icons prefix">person_outline</i> <input
								value="${sessionScope.User.height}" name="height" id="height"
								type="number" class="validate" min="1"> <label
								for="height">Height</label>

						</div>
					</div>

					<div class="row">

						<div class="input-field col s6">
							<i class="material-icons prefix">person_outline</i> <input
								value="${sessionScope.User.age}" name="age" id="age"
								type="number" class="validate" min="1"> <label for="age">Age</label>

						</div>
					</div>
					<div class="container center-align">
						<div class="row">
							<button id="edit" class="waves-effect waves-light btn"
								type="submit" value="submit" name="action" onclick="return">
								<i class="material-icons left">arrow_back</i>Submit
							</button>
						</div>
					</div>

				</fieldset>
			</div>
			<div>
				<div class="row">
					<div class="input-field col s6">
						<button id="edit" class="waves-effect waves-light btn"
							type="button" onclick="enableFields()">
							<i class="material-icons left">arrow_back</i>Edit Information
						</button>
					</div>
				</div>
			</div>
		</div>
	</form>
	<div class="parallax-container">
		<div class="parallax">
			<img src="images/exercise2.jpg">
		</div>
	</div>
	<%
		}
	%>
</body>
</html>