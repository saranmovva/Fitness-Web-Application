<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link type="text/css" rel="stylesheet" href="css/materialize.min.css">
<link type="text/css" rel="stylesheet" href="css/custom.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.modal {
	width: 75% !important;
	max-height: 100% !important;
	overflow-y: hidden !important;
}
</style>
<title>Base Metabolic Rate</title>

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
	<div class="container center-align">
		<h1 class="z-depth-3">Calculate your Base Metabolic Rate</h1>
		<ul class="collapsible" data-collapsible="accordion">
			<li>
				<div class="collapsible-header">
					<i class="material-icons">fitness_center</i>What is base Metabolic
					Rate?
				</div>
				<div class="collapsible-body">
					<span>Everybody requires a minimum number of calories to
						live. This minimum number is called the basal metabolic rate
						(BMR). Your BMR is the number of calories your organs need to
						function while you perform no activity whatsoever. You can think
						of it as the amount of energy you'd burn if you stayed in bed all
						day. Since your basal metabolic rate is based largely on
						involuntary functions like breathing and pumping blood, changes in
						your day-to-day activity don't do much to raise or lower this
						number. However, increasing muscle mass does increase BMR, because
						muscle is metabolically "hungry" and it takes more energy to
						maintain more muscle. This means that when you have a lot of
						muscle mass, you'll burn more calories at rest.</span>
				</div>
			</li>
			<li>
				<div class="collapsible-header">
					<i class="material-icons">fitness_center</i>Why does it matter?
				</div>
				<div class="collapsible-body">
					<span>Once you know your BMR, you can use it to calculate
						the calories you actually burn in a day. From there, you can
						determine how many calories you need to eat to gain muscle, lose
						fat, or maintain your weight. The overall number of calories your
						body uses on a daily basis is referred to as your "total daily
						energy expenditure" (TDEE). It's determined based on your BMR as
						well as your activity level throughout the day. This varies
						significantly based on your activity level, age, and sex.
						Generally, men have a higher TDEE than women because they have
						more muscle mass, and both TDEE and BMR tend to fall regardless of
						gender as you age. You can use a TDEE calculator to find this
						number, or calculate it manually to get a more specific result.
						Keep in mind, though, that it's impossible to know your exact
						TDEE, as your activity levels will change day to day, and the only
						way to get 100 percent accurate BMR numbers is through laboratory
						testing.</span>
				</div>
			</li>
			<li>
				<div class="collapsible-header">
					<i class="material-icons">fitness_center</i>How to use your Base
					Metabolic Rate to lose fat or gain muscle
				</div>
				<div class="collapsible-body">
					<span>Once you use your BMR to determine the total amount of
						calories your burn throughout the day, you can make sure that the
						nutrition plan you follow is appropriate for your level of energy
						expenditure and that it isn't giving you too many or too few
						calories. Being armed with this knowledge, rather than
						guesstimating or blindly following a plan without scaling it to
						your individual needs, can make or break your muscle gains or fat
						loss.</span>
				</div>
			</li>
		</ul>
	</div>


	<div class="allRadio container" id="allRadio">
		<div class="center-align">
			<h5>Click on the option that best fits you to calculate your
				Base Metabolic Rate</h5>
			<form action="BMRServlet" method="post">
				<div>
					<input class="radio-label" name="grp1" type="radio" id="r1"
						name="answer" value="1.2" checked="checked"> <label
						for="r1"> Sitting/lying all day </label>
				</div>

				<div>
					<input class="radio-label" name="grp1" type="radio" id="r2"
						name="answer" value="1.3"> <label for="r2">Seated
						work, no exercise</label>
				</div>
				<div>
					<input class="radio-label" name="grp1" type="radio" id="r3"
						name="answer" value="1.4"> <label for="r3">Seated
						work, light exercise</label>
				</div>
				<div>
					<input class="radio-label" name="grp1" type="radio" id="r4"
						name="answer" value="1.5"> <label for="r4">Moderately
						physical work, no exercise</label>
				</div>
				<input class="radio-label" name="grp1" type="radio" id="r5"
					name="answer" value="1.6"> <label for="r5">Moderately
					physical work, little exercise</label>


				<div>
					<input class="radio-label" name="grp1" type="radio" id="r6"
						name="answer" value="1.7"> <label for="r6">Moderatey
						phsical work, heavy exercise</label>
				</div>
				<div>
					<input class="radio-label" name="grp1" type="radio" id="r7"
						name="answer" value="1.8"> <label for="r7">Above
						average physical work / exercise</label>
				</div>
				<div>
					<button class="btn waves-effect waves-light" type="submit"
						value="submit" name="action" onclick="return">Submit</button>

				</div>
			</form>
		</div>

	</div>
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