<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRK Technologies</title>
<!-- Font Awesome link -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- Bootstrap link -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet" href="List.css">
</head>
<body>
	<div class="container bg-info-custom text-light pb-4">
		<div class="text-center">
			<h2>Welcome To Employee Management System</h2>
			<p class="pt-2">Tech company, kalamboli</p>
		</div>
	</div>

	<div class="container pt-5 ">
		<div class="carousel slide" data-bs-ride="carousel" id="mycarousel">

			<div class="carousel-indicators">
				<button type="button" data-bs-target="#mycarousel"
					data-bs-slide-to="0" class="active" aria-current="true"></button>
				<button type="button" data-bs-target="#mycarousel"
					data-bs-slide-to="1"></button>
				<button type="button" data-bs-target="#mycarousel"
					data-bs-slide-to="2"></button>
			</div>

			<div class="carousel-inner">
				<!-- 1st image -->
				<div class="carousel-item active">
					<img alt="" src="emp1.jpg" class="d-block w-100">
				</div>

				<!-- 2nd image -->
				<div class="carousel-item">
					<img alt="" src="emp2.jpg" class="d-block w-100">
				</div>

				<!-- 3rd image -->
				<div class="carousel-item">
					<img alt="" src="emp3.jpg" class="d-block w-100">
				</div>
			</div>


			<button class="carousel-control-prev" type="button"
				data-bs-target="#mycarousel" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden"></span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#mycarousel" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden"></span>
			</button>

		</div>
	</div>


	<c:url var="listallemp" value="EmployeeController">
		<c:param name="command" value="LIST"></c:param>
	</c:url>

	<div class="d-flex justify-content-center align-items-center">
		<span><a href="${listallemp}">List All Employee </a> || &nbsp;
		</span> <br>
		<br> <span><a href="add-employee.jsp">Add Employee</a></span>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
		integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
		crossorigin="anonymous"></script>
</body>
</html>