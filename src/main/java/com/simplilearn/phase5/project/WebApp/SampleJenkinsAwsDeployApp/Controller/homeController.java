package com.simplilearn.phase5.project.WebApp.SampleJenkinsAwsDeployApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplilearn.phase5.project.WebApp.SampleJenkinsAwsDeployApp.Service.loginService;



@Controller
public class homeController 
{
	@Autowired
	private loginService loginservice;
	
	@RequestMapping(value= {
			"/",
			"/home"
	})
	public String home()
	{
		return "welcome";
	}
	
	@RequestMapping("/processlogin")
	public String login(Model model,@RequestParam(value="username")String username,@RequestParam(value="password")String password)
	{
		//model.addAttribute("user", username);
		String url;
		String isValid = loginservice.validateCredentials(username, password);
		if(isValid.equalsIgnoreCase("false"))
		{
			model.addAttribute("error", "Invalid Username or Password");
			url = "welcome";
		}
		else
		{
			if(isValid.equalsIgnoreCase("admin"))
			{
				url = "home";
			}
			else
			{
				model.addAttribute("error", "Only Admins can login");
				url = "welcome";
			}
		}
		return url;
	}
}
