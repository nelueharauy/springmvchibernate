package net.roseindia.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.roseindia.form.EmployeeForm;
import net.roseindia.form.LoginForm;
import net.roseindia.model.Employees;
import net.roseindia.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	public EmployeeService employeeService;
	
	@RequestMapping(value= "/add", method = RequestMethod.GET)
	public String employeeAdd(Map model){
		EmployeeForm employeeForm = new EmployeeForm();
		
		model.put("employeeForm", employeeForm);
				
		return "employeeInfoPage";	
	}
	
	@RequestMapping(value= "/addOrUpdateEmployee", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") Employees p, Map model, HttpSession session){
		
		if(p.getId() == null){
			//add
			employeeService.addEmployee(p);
		} else {
			//update employee
			employeeService.updateEmployee(p);
		}
		
		/*if(p.getId() == 0){
			//new person, add it
			this.personService.addPerson(p);
		}else{
			//existing person, call update
			this.personService.updatePerson(p);
		}*/
		LoginForm loginForm = (LoginForm) session.getAttribute("loginFormInSession");
		model.put("loginForm", loginForm);
		model.put("listEmployee", employeeService.listEmployee());
		
		return "loginsuccess";
		
	}
	
	@RequestMapping(value= "/remove/{id}", method = RequestMethod.GET)
	public String removeEmployee(@PathVariable("id") int id, Map model, HttpSession session){
		employeeService.removeEmployee(id);
		
		LoginForm loginForm = (LoginForm) session.getAttribute("loginFormInSession");
		model.put("loginForm", loginForm);
		model.put("listEmployee", employeeService.listEmployee());
		
		return "loginsuccess";
	}
	
	@RequestMapping(value= "/"
			+ "{id}", method = RequestMethod.GET)
	public String editEmployee(@PathVariable("id") int id, Map model) {
		EmployeeForm employeeForm = new EmployeeForm();

		model.put("employeeForm", employeeService.getEmployeeById(id));
		
		return "employeeInfoPage";
	}
	
}
