package org.example.spb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.example.spb.dto.UserDto;
import org.example.spb.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {
	@Autowired
	private UserManagementService userService;
	
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
	public String registrationPage(Model model) {
		UserDto dto = new UserDto();
		model.addAttribute("newUser", dto);
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView createUser(@ModelAttribute ("newUser") @Valid UserDto dto, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("register", "newUser", dto);
		} else {
		 if (userService.createAccount(dto)) {
			 return new ModelAndView("list");
		 } else {
			 return new ModelAndView("register", "newUser", dto);
		 }
		}
	}
}