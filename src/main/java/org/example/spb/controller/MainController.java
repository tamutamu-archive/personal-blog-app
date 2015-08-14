package org.example.spb.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model, @AuthenticationPrincipal User user) {
		model.addAttribute("user", user);
		return "list";
	}
	
	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public String manage(Model model) {
		return "/manage";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(Model model, @AuthenticationPrincipal User user) {
		model.addAttribute("user", user);
		return "read";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "create";
	}
}