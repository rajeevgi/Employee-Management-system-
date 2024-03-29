package com.sprk.emp_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EmployeeUtil {

	private DataSource dataSource;

	public EmployeeUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public List<Employee> getAllEmployees() throws Exception {
		List<Employee> employees = null;

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		int empId;
		String name;
		String email;
		Double salary;
		Timestamp doj;

		Employee emp = null;

		try {
			String sql = "select * from employee";
			conn = dataSource.getConnection();
			st = conn.createStatement();

			rs = st.executeQuery(sql);

			employees = new ArrayList<>();

			while (rs.next()) {
				empId = rs.getInt("emp_id");
				name = rs.getString("name");
				email = rs.getString("email");
				salary = rs.getDouble("salary");
				doj = rs.getTimestamp("doj");

				emp = new Employee(empId, name, email, salary, doj);

				employees.add(emp);

			}

		} finally {
			closeAll(conn, st, rs);
		}

		return employees;
	}

	public void closeAll(Connection conn, Statement st, ResultSet rs) throws Exception {
		if (conn != null) {
			conn.close();
		}
		if (st != null) {
			st.close();
		}
		if (rs != null) {
			rs.close();
		}
	}

	public void addEmployee(Employee theEmp) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {

			String sql = "insert into employee (name,email,salary,doj) values(?,?,?,?)";

			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, theEmp.getName());
			ps.setString(2, theEmp.getEmail());
			ps.setDouble(3, theEmp.getSalary());
			ps.setTimestamp(4, theEmp.getDoj());

			ps.executeUpdate();

		} finally {

			closeAll(conn, ps, null);

		}

	}

	public void deleteEmployee(String id) throws Exception {
		// create basic obj
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// convert string to int
			int empId = Integer.parseInt(id);

			String sql = "Delete from employee where emp_id = ?";

			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empId);

			ps.executeUpdate();

		} finally {
			closeAll(conn, ps, null);
		}

	}

	public Employee findEmpById(String id) throws Exception {
		int empId = Integer.parseInt(id);
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Employee emp = null;
		try {
			String sql = "select * from employee where emp_id = ?";

			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empId);

			rs = ps.executeQuery();
			String name;
			String email;
			double salary;
			Timestamp doj;

			while (rs.next()) {
				name = rs.getString("name");
				// empId =rs.getInt("emp_id");
				email = rs.getString("email");
				salary = rs.getDouble("salary");
				doj = rs.getTimestamp("doj");

				emp = new Employee(empId, name, email, salary, doj);
			}

		} finally {
			closeAll(conn, ps, rs);
		}
		return emp;
	}

	public void updateEmployee(Employee theEmp) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {

			String sql = "update employee set name = ?, email = ?, salary = ?, doj = ? where emp_id = ?";

			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, theEmp.getName());
			ps.setString(2, theEmp.getEmail());
			ps.setDouble(3, theEmp.getSalary());
			ps.setTimestamp(4, theEmp.getDoj());
			ps.setInt(5, theEmp.getEmpId());
			ps.executeUpdate();

		} finally {

			closeAll(conn, ps, null);

		}

	}

}