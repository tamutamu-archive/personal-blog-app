package org.example.spb.controller;


import java.util.List;

import javax.validation.Valid;

import org.example.spb.domain.Role;
import org.example.spb.dto.CommentDto;
import org.example.spb.dto.PostDto;
import org.example.spb.service.PostManagementService;
import org.example.spb.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@Autowired
	private PostManagementService postSevice;
	
	@Autowired
	private UserManagementService userService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model, @AuthenticationPrincipal User user) {
		model.addAttribute("user", user);
		model.addAttribute("posts", postSevice.getRange(0));
		return "list";
	}
	
	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public String manage(Model model) {
		model.addAttribute("posts", postSevice.getRange(0));
		return "/manage";
	}
	
	@RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
	public String read(Model model, @AuthenticationPrincipal User user, @PathVariable("id") Integer id) {
		model.addAttribute("post", postSevice.getOne(id));
		model.addAttribute("newComment", new CommentDto());
		model.addAttribute("user", user);
		return "read";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createPage(Model model) {
		model.addAttribute("post", new PostDto());
		return "create";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createPost(@ModelAttribute ("post") @Valid PostDto dto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("post", dto);
			return "create";
		} else {
			postSevice.create(dto);
			return "manage";
		}
	}
	
	@RequestMapping(value = "/comment/{id}", method = RequestMethod.POST)
	public String leaveAComment(@ModelAttribute("newComment") @Valid CommentDto dto,
			BindingResult result, Model model, @PathVariable("id") Integer id, @AuthenticationPrincipal User user) {
		String url = "redirect:/";
		if (user == null) {
			url += "register";
		} else {
			if (result.hasErrors()) {
				model.addAttribute("newComment", dto);
			} else {
				
				postSevice.addComment(dto, userService.getIdByEmail(user.getUsername()), id);
			}
			url += "read/" + id;
		}
		
		return url;
	}
}