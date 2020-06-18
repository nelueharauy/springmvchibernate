package net.roseindia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.roseindia.dao.EmployeeDAO;
import net.roseindia.model.Employees;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDAO employeeDAO;

	public void setPersonDAO(EmployeeDAO personDAO) {
		this.employeeDAO = personDAO;
	}

	@Transactional
	public void addEmployee(Employees p) {
		this.employeeDAO.addEmployee(p);
	}

	@Transactional
	public void updateEmployee(Employees p) {
		this.employeeDAO.updateEmployee(p);
	}

	@Transactional
	public List<Employees> listEmployee() {
		return this.employeeDAO.listEmployee();
	}

	@Transactional
	public Employees getEmployeeById(int id) {
		return this.employeeDAO.getEmployeeById(id);
	}

	@Transactional
	public void removeEmployee(int id) {
		this.employeeDAO.removeEmployee(id);
	}	
}