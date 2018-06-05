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
<title>Login</title>
</head>
<body>
	<script src="js/jquery.js"></script>
	<script src="js/materialize.min.js"></script>
	<script src="js/plotly-latest.min.js"></script>

	<%@ page import="edu.ben.model.User"%>

	<%
		User temp = (User) session.getAttribute("User");
		if (temp == null) {
			response.sendRedirect("index.jsp");
		} else if (temp.getAge() == 0 || temp.getHeight() == 0 || temp.getGender().equals(" ")) {
	%>
	
	<div class="parallax-container">
		<div class="parallax">
			<img src="images/loginpage.jpeg">
		</div>
	</div>
	<div class="section white z-depth-5">
		<div class="row container">
			<br>
			<form action="UserUpdateServlet" action="post">
				<div class="input-field col s6 offset-s3 center-align ">
					<input id="Age" name="Age" type="number" class="validate" value=""
						min="1"> <label for="Age">Age</label>
				</div>

				<div class="input-field col s6 offset-s3 center-align">
					<input name="Height" type="number" class="validate" min="1">
					<label for="Height">Height (In Inches)</label>
				</div>
				<br> <label>Gender</label>
				<p>
					<input name="Gender" type="radio" id="Male" value="Male" /> <label
						for="Male">Male</label>
				</p>
				<p>
					<input name="Gender" type="radio" id="Female" value="Female" /> <label
						for="Female">Female</label>
				</p>
				<br> <br>
				<div class="input-field col s6 offset-s3 center-align">
					<button class="btn waves-effect waves-light" type="submit"
						name="SubmitButton">
						Submit <i class="material-icons right">send</i>
					</button>
				</div>
			</form>
		</div>
	</div>
	<div class="parallax-container">
		<div class="parallax">
			<img src="images/loginpage.jpeg">
		</div>
	</div>


	<%
		} else {
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
			<img src="images/loginpage.jpeg">
		</div>
	</div>

	<div class="container section">
		<div id="WeightUpdate" class="row">

			<form action="WeightUpdateServlet" action="post">
				<div class="col s4 center-align">
					<h5>Update Weight</h5>
					<div class="input-field">
						<input id="date" name="DateValue" type="date">
					</div>

					<div class="input-field">
						<input id="weight" name="WeightValue" type="number"
							class="validate"> <label for="weightValue">Weight</label>
					</div>

					<div class="input-field">
						<button class="btn waves-effect waves-light" type="submit"
							name="WeightButton">
							Save <i class="material-icons right">send</i>
						</button>
					</div>
				</div>
			</form>
			<div class="col s8 center-align">
				<div id="graphDiv"></div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="section"></div>
	</div>





	<script type="text/javascript">
		var weightString = ${sessionScope.WeightStr};
		var dateString = ${sessionScope.DateStr};

		 var trace1 = {
			x : dateString,
			y : weightString,
			type : 'scatter',
			mode : 'lines'
		}

		 /* var trace1 = {
			x: ['2017-9-20', '2017-9-22', '2017-9-23', '2017-9-27'],
			y: [16, 15, 13, 17],
			type: 'scatter',
			mode: 'lines'
		}; */

		var layout = {
			title : 'Weight Over Time',
		};

		/* $.get("GraphPageServlet", function (data, status){
			console.log("request returned");
			var layout = {
				title: 'Weight Over Time',
			};
			
			console.log(data);
			//JSON.parse(data);
			Plotly.newPlot('graphDiv', data, layout);
		}); */

		var data = [ trace1, ];
		Plotly.newPlot('graphDiv', data, layout);
	</script>

	<div class="parallax-container">
		<div class="parallax">
			<img src="images/loginpage.jpeg">
		</div>
	</div>

	<%
		}
	%>

</body>
</html>