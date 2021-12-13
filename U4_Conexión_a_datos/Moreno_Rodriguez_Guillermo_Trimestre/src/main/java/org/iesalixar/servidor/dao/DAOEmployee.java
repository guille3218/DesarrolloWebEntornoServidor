package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Employee;

public interface DAOEmployee {
	public List<Employee> getAllEmployee();
	public boolean addEmployee(Employee employee);
	public Employee getEmployee(int numberEmployee);
}
