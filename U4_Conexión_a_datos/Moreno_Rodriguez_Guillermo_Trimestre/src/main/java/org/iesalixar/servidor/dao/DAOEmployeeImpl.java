package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.db.PoolDB;
import org.iesalixar.servidor.model.Employee;

public class DAOEmployeeImpl implements DAOEmployee{

	public DAOEmployeeImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Employee> getAllEmployee() {
		ArrayList<Employee> employees = new ArrayList<>();
		
		try {
			PoolDB pool = new PoolDB();

			Connection con;
			con = pool.getConnection();
			
			String sql = "select * from employees";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				Employee employee = new Employee();
				
				employee.setEmployeeNumber(rs.getInt("employeeNumber"));
				employee.setLastName(rs.getString("lastName"));
				employee.setFirstName(rs.getString("firstName"));
				employee.setExtension(rs.getString("extension"));
				employee.setEmail(rs.getString("email"));
				employee.setOfficeCode(rs.getString("officeCode"));
				employee.setReportsTo(rs.getInt("reportsTo"));
				employee.setJobTitle(rs.getString("jobTitle"));
				
				employees.add(employee);
			}
			
			con.close();
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return employees;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		int resultado = 0;
		
		try {
			PoolDB pool = new PoolDB();

			Connection con;
			con = pool.getConnection();
			String sql = "insert into employees values(?,?,?,?,?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setInt(1, employee.getEmployeeNumber());
			statement.setString(3, employee.getLastName());
			statement.setString(2, employee.getFirstName());
			statement.setString(4, employee.getExtension());
			statement.setString(5, employee.getEmail());
			statement.setString(6, employee.getOfficeCode());
			statement.setInt(7, employee.getReportsTo());
			statement.setString(8, employee.getJobTitle());
			
			resultado = statement.executeUpdate();

			con.close();
	
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return (resultado == 0 ? false : true);
	}

	@Override
	public Employee getEmployee(int numberEmployee) {
		Employee employee = null;
		try {
			PoolDB pool = new PoolDB();

			Connection con;
			con = pool.getConnection();
			
			String sql = "select * from employees where employeeNumber= ?";
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, String.valueOf(numberEmployee));
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				employee = new Employee();
				
				employee.setEmployeeNumber(rs.getInt("employeeNumber"));
				employee.setLastName(rs.getString("lastName"));
				employee.setFirstName(rs.getString("firstName"));
				employee.setExtension(rs.getString("extension"));
				employee.setEmail(rs.getString("email"));
				employee.setOfficeCode(rs.getString("officeCode"));
				employee.setReportsTo(rs.getInt("reportsTo"));
				employee.setJobTitle(rs.getString("jobTitle"));
			}
			
			con.close();
			
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return employee;
	}
	
	
}
