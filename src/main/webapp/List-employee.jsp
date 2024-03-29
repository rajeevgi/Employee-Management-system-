<%@page import="com.sprk.emp_management.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Employees</title>
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

<style>
table {
	display: flex;
	justify-content: center;
	align-items: center;
}
</style>
</head>
<body>

	<div class="container bg-info-custom text-light pb-4">
		<div class="text-center">
			<h2>Welcome To Employee Management System</h2>
			<p class="pt-2">List Of All Employees</p>
		</div>
	</div>

	<div class="container pt-5">
		<!-- <table border="1"
			style="border: 1px maroon; border-collapse: collapse;"> -->

		<table class="table table-bordered ">
			<tr class="bg-secondary-custom text-center">
				<th>Name</th>
				<th>Email-ID</th>
				<th>Salary</th>
				<th>DOJ</th>
				<th>Action</th>
			</tr>

			<c:set var="employees"
				value="<%=(List<Employee>) request.getAttribute(\"allEmployees\")%>" />
			<c:forEach var="tempEmp" items="${employees}">
				<tr>
					<c:url var="updateEmp" value="EmployeeController">
						<c:param name="command" value="LOAD" />
						<c:param name="emp_id" value="${tempEmp.empId}" />
					</c:url>
					<c:url var="deleteEmp" value="EmployeeController">
						<c:param name="command" value="DELETE" />
						<c:param name="emp_id" value="${tempEmp.empId}" />
					</c:url>

					<td>${tempEmp.name}</td>
					<td>${tempEmp.email}</td>
					<td>${tempEmp.salary}</td>
					<td>${tempEmp.doj}</td>
					<td><a href="${updateEmp}"><i class="fa-solid fa-user-pen"></i>
							Update</a>&nbsp;&nbsp; |&nbsp;&nbsp; <a href="${deleteEmp}"><i
							class="fa-solid fa-user-minus"></i> Delete</a></td>
					<%-- <td>${tempEmp.empId}</td> --%>
				</tr>
			</c:forEach>
		</table>
		<br>

	</div>
	<div class="container d-flex px-4">
		<div class="row gx-5">
			<div class="col">
				<div class="add-employee">
					<a href="add-employee.jsp"><i class="fa-solid fa-user-plus"></i>
						Add Employee</a>
				</div>
			</div>
			<div class="col">
				<div class="add-employee">
					<a href="welcome.jsp">Homepage</a>
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
		integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
		crossorigin="anonymous"></script>
</body>
</html>