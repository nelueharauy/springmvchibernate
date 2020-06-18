package net.roseindia.dao;

import java.util.List;

import net.roseindia.model.Employees;

public interface EmployeeDAO {
	
	public void addEmployee(Employees p);
	public void updateEmployee(Employees p);
	public List<Employees> listEmployee();
	public Employees getEmployeeById(int id);
	public void removeEmployee(int id);
	
}
