<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/home.css">
</head>
<body>
	<div class="container">
		<header>
			<h2>
				<a href="#"><i class="ion-plane"></i> Katotravel</a>
			</h2>
			<nav>
				<ul>
					<li><a href="#" title="Hotels">Hotels</a></li>
					<li><a href="#" title="Flights">Flights</a></li>
					<li><a href="#" title="Tours">Tours</a></li>
					<li><a class="btn" href="?action=logout" title="Register / Log In">Logout</a></li>
				</ul>
			</nav>
		</header>

		<div class="cover">
			<h1>Discover what's out there.</h1>
			<form class="flex-form">
				<label for="from"> <i class="ion-location"></i>
				</label> <input type="search" placeholder="Where do you want to go?">
				<input type="submit" value="Search">
			</form>
			<div id="madeby">
				<span> Photo by <a href="https://unsplash.com/@benblenner"
					target="_blank">Ben Blennerhassett</a>
				</span>
			</div>
		</div>

	</div>
</body>
</html>