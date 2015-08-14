package org.example.spb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecurityController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		String url = "redirect:/";
		
		if (request.isUserInRole("ROLE_ADMIN")) {
			url += "manage";
		} else {
			url += "list";
		}
		return url;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registrationPage() {
		return null;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String createUser() {
		return null;
	}
}