<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<title>BMI</title>
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
			<img src="images/track.jpg">
		</div>
	</div>
	<div class="container">
		<div class="section">

			<div class="row">
				<div class="col s12 center">
					<h3>
						<i class="mdi-content-send brown-text"></i>
					</h3>
					<h4>Calculate your BMI</h4>
					<p class="center-align light">
						BMI is a measurement of a person's leanness or corpulence based on
						their height and weight, and is intended to quantify tissue mass.
						Although BMI has limitations in that it is an estimate that cannot
						take body composition into account, it can be used as a general
						indicator of a healthy body weight based on a person's height. The
						value obtained from the calculation of BMI is widely used to
						categorize whether a person is underweight, normal weight,
						overweight, or obese depending on what range the value falls
						between. These ranges of BMI vary based on factors such as region
						and age, and are sometimes further divided into subcategories such
						as severely underweight or very severely obese. As previously
						mentioned however, due to a wide variety of body types as well as
						distribution of muscle, bone mass, and fat, BMI should be
						considered along with other measurements rather than being used as
						the sole method for determining a person's "healthy" body weight.<br>
						The formula for calculating BMI is your weight divided by your
						height squared. This will using the data already stored to do this
						calculation. Press the button below to find out your BMI.
					</p>
					<div>
						<form action="BMIServlet" method="post">

							<button class="btn waves-effect waves-light" type="submit"
								value="submit" name="action">Calculate</button>
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>
	<div class="parallax-container">
		<div class="parallax">
			<img src="images/track.jpg">
		</div>
	</div>
	<%
		}
	%>
</body>
</html>