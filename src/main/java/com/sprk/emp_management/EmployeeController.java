package com.sprk.emp_management;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet ("/EmployeeController")
public class EmployeeController extends HttpServlet {

	private EmployeeUtil employeeUtil;

	@Resource(name = "jdbc/sprkemp")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		employeeUtil = new EmployeeUtil(dataSource);
	}

	public EmployeeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String command = request.getParameter("command");
		if (command == null) {
			command = "LIST";
		}

		try {

			switch (command) {
			case "LIST":
				listAllEmployee(request, response);

				break;

			case "DELETE":
				deleteEmp(request, response);
				listAllEmployee(request, response);
				break;

			case "LOAD":
				loadEmp(request, response);
				break;

			default:
				listAllEmployee(request, response);
				break;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void loadEmp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String id = request.getParameter("emp_id");
		Employee emp = employeeUtil.findEmpById(id);
		request.setAttribute("theEmp", emp);

		RequestDispatcher rs = request.getRequestDispatcher("/update-emp-form.jsp");
		rs.forward(request, response);

	}

	private void deleteEmp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String id = request.getParameter("emp_id");
		employeeUtil.deleteEmployee(id);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");
		if (command == null) {
			command = "LIST";
		}

		try {

			switch (command) {
			case "LIST":
				listAllEmployee(request, response);

				break;

			case "ADD":
				insertEmp(request, response);
				break;

			case "UPDATE":
				updateEmp(request, response);
				listAllEmployee(request, response);
				break;

			default:
				listAllEmployee(request, response);
				break;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void updateEmp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// Read the employee id from the request object
		String id = request.getParameter("empId");
//		System.out.println(id);

		String name = request.getParameter("username");
		String email = request.getParameter("useremail");
		String salary = request.getParameter("userSalary");
		String dojStr = request.getParameter("doj");

		StringBuffer dojBuff = new StringBuffer(dojStr);
		if (name == null || name.trim().equals("")) {
			request.setAttribute("status", "Invalid-user-name");

			RequestDispatcher rd = request.getRequestDispatcher("/update-emp-form.jsp");
			rd.forward(request, response);
		} else if (dojBuff.toString() == null || dojBuff.toString().equals("")) {
			request.setAttribute("status", "Invalid-doj");
			RequestDispatcher rd = request.getRequestDispatcher("/update-emp-form.jsp");
			rd.forward(request, response);
		} else if (email == null || email.trim().equals("")) {
			request.setAttribute("status", "Invalid-email");
			RequestDispatcher rd = request.getRequestDispatcher("/update-emp-form.jsp");
			rd.forward(request, response);
		} else {
			dojBuff.append(":00");
			dojStr = dojBuff.toString();
			int empId = Integer.parseInt(id);

			Timestamp doj = Timestamp.valueOf(dojStr.replace("T", " "));

			double empSalary = Double.parseDouble(salary);
			Employee theEmp = new Employee(empId, name, email,empSalary, doj);

			employeeUtil.updateEmployee(theEmp);

		}
	}


	private void insertEmp(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read all the field first

		String name = request.getParameter("username");
		String email = request.getParameter("useremail");
//		double salary = Double.parseDouble(request.getParameter("userSalary"));
		String salary = request.getParameter("userSalary");
		String dojStr = request.getParameter("doj");

		StringBuffer dojBuff = new StringBuffer(dojStr);
		if (name == null || name.trim().equals("")) {
			request.setAttribute("status", "Invalid-Username");
			RequestDispatcher rd = request.getRequestDispatcher("/add-employee.jsp");
			rd.forward(request, response);
		} else if (dojBuff.toString() == null || dojBuff.toString().equals("")) {
			request.setAttribute("status", "Invalid-DOJ");
			RequestDispatcher rd = request.getRequestDispatcher("/add-employee.jsp");
			rd.forward(request, response);
		} else if (email == null || email.trim().equals("")) {
			request.setAttribute("status", "Invalid-Email");
			RequestDispatcher rd = request.getRequestDispatcher("/add-employee.jsp");
			rd.forward(request, response);
		} else if (salary == null || salary.trim().equals("")) {
			request.setAttribute("status", "Invalid-salary");
			RequestDispatcher rd = request.getRequestDispatcher("/add-employee.jsp");
			rd.forward(request, response);
		} else {
			dojBuff.append(":00");
			dojStr = dojBuff.toString();
//		System.out.println(dojStr);

			Timestamp doj = Timestamp.valueOf(dojStr.replace("T", " "));
//		System.out.println(doj);
			double empSalary = Double.parseDouble(salary);
			Employee theEmp = new Employee(name, email, empSalary, doj);

			employeeUtil.addEmployee(theEmp);

			response.sendRedirect(request.getContextPath() + "/EmployeeController");

		}

	}

	private void listAllEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Employee> employees = employeeUtil.getAllEmployees();

		request.setAttribute("allEmployees", employees);
		RequestDispatcher rd = request.getRequestDispatcher("List-employee.jsp");
		rd.forward(request, response);

	}

}