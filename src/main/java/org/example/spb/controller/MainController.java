package org.example.spb.controller;


import java.util.List;

import javax.validation.Valid;

import org.example.spb.dto.CommentDto;
import org.example.spb.dto.PostDto;
import org.example.spb.service.PostManagementService;
import org.example.spb.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
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
		String url = "redirect:/";
		if (result.hasErrors()) {
			model.addAttribute("post", dto);
			url = "create";
		} else {
			postSevice.create(dto);
			url = "manage";
		}
		return url;
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String updatePage(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("post", postSevice.getOne(id));
		return "update";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String updatePost(@ModelAttribute("post") @Valid PostDto dto,
			BindingResult result, Model model, @PathVariable("id") Integer id) {
		String url = "redirect:/";
		if (result.hasErrors()) {
			model.addAttribute("post", dto);
			url += "update/" + id; 
		} else {
			postSevice.update(dto);
			url += "read/" + id;
		}
		return url;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteConfirmPage(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("postTitle", postSevice.getOne(id).getTitle());
		model.addAttribute("id", id);
		return "delete";
	}
	
	@RequestMapping(value = "/delete_confirm/{id}", method = RequestMethod.GET)
	public String deletePost(@PathVariable("id") Integer id) {
		postSevice.delete(id);
		return "redirect:/manage";
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
	
	@RequestMapping(value = "/comment_delete/{postId}/{commentId}", method = RequestMethod.GET)
	public String deleteComment(@PathVariable("postId") Integer postId, @PathVariable("commentId") Integer commentId) {
		postSevice.deleteComment(commentId);
		return "redirect:/update/" + postId;
	}
}