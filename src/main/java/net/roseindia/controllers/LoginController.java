package net.roseindia.controllers;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.roseindia.form.LoginForm;
import net.roseindia.service.EmployeeService;
import net.roseindia.service.LoginService;

@Controller
@RequestMapping("loginform.html")
public class LoginController {

	@Autowired
	public LoginService loginService;

	@Autowired
	public EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map model) {
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "loginform";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid LoginForm loginForm, BindingResult result,
			Map model, HttpSession session) {
		
		if (result.hasErrors()) {
			return "loginform";
		}
		
		String userType = loginService.checkLogin(loginForm.getUserName(),loginForm.getPassword());
		//TODO: don't forget to make final variables.
		if(!userType.equals("NOTFOUND")){
			
			loginForm.setUserType(userType);

			session.setAttribute("loginFormInSession", loginForm);
			
			model.put("loginForm", loginForm);
			model.put("listEmployee", employeeService.listEmployee());
			
			return "loginsuccess";
		}else{
			result.rejectValue("userName","invaliduser");
			return "loginform";
		}
	}
}
