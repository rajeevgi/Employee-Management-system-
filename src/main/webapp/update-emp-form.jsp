<%@page import="com.sprk.emp_management.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRk Technologies</title>
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
			<p class="pt-2">Update the employee details</p>
		</div>
	</div>
	<hr>
	<div class="container d-flex bg-light mt-5">
		<div class="img">
			<img alt="" src="update-employee.png">
		</div>

		<div class="form-group m-5">
			<div class="text">
				<h3>Update Here....</h3>
			</div>
			<form action="EmployeeController" method="post">
				<c:set var="emp"
					value="<%=(Employee) request.getAttribute(\"theEmp\")%>" />
				<input type="hidden" name="command" value="UPDATE"> <input
					type="hidden" name="empId" value="${emp.empId }">

				<%-- <c:out value="${emp}"></c:out> --%>
				<%-- <% request.setAttribute("empId", "${emp.empId}"); %> --%>

				<input type="hidden" id="status" name="status"
					value="<%=(String) request.getAttribute("status")%>"> <br>
				<br>
				<label for="username">Name:</label> <input name="username"
					type="text" value="${emp.name}"> <br> <br> <label
					for="useremail">Email:</label>&nbsp; <input name="useremail"
					type="email" value="${emp.email}"> <br> <br> <label
					for="userSalary">Salary:</label> <input name="userSalary"
					type="text" value="${emp.salary}"> <br> <br> <label
					for="doj">DOJ:</label>&nbsp;&nbsp;&nbsp; <input name="doj"
					type="datetime-local" value="${emp.doj}"> <br> <br>
				<input type="submit" value="Submit" class="bg-success"
					style="width: 100px; height: 50px; border-radius: 5px;">

			</form>
		</div>
	</div>
	<hr>

	<script type="text/javascript">
		var status = document.getElementById("status").value;

		console.log(status);

		if (status === "Invalid-Username") {
			alert("Username cannot be empty");
		} else if (status === "Invalid-Email") {
			alert("Email cannot be empty");
		} else if (status === "Invalid-Salary") {
			alert("Salary cannot be empty");
		} else if (status === "Invalid-DOJ") {
			alert("DOJ cannot be empty");
		}
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
		integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
		crossorigin="anonymous"></script>
</body>
</html>