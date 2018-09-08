package com.andrews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.andrews.model.User;
import com.andrews.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	public UserService userService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/back")
	public String back() {
		return "index";
	}
	
	@GetMapping("/goToInsertPage")
	public String goToInsertPage() {
		return "insertPage";
		
	}
	
	@GetMapping("/goToViewPage")
	public String getAll(Model model) {
		model.addAttribute("users", userService.findAll());
		return "usersPage";
	}
	
	@GetMapping("/insertOne") 
	public String insertOne(@RequestParam("name") String name){
		User user = new User();
		user.setName(name);
		userService.insertUser(new User(name));
		return "insertPage";
	}
	
	@GetMapping("/filter") 
	public String filter(@RequestParam("reg") String reg, 
						Model model){
		model.addAttribute("users", userService.filterAll(reg));
		return "usersPage";
	}

	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {
		model.addAttribute("message", e.getMessage());
		return "errorPage";
	}
	
}
