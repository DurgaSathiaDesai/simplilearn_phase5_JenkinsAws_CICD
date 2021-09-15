package com.simplilearn.phase5.project.WebApp.SampleJenkinsAwsDeployApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController 
{
	@RequestMapping(value= {
			"/",
			"/home"
	})
	public String home()
	{
		return "welcome";
	}
}
