package com.tka.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.tka.model.User;
import com.tka.service.UserService;

@Controller
public class UserController {
	
	@Autowired
    UserService userService;
	
	@GetMapping("/")
	public String openUserPage() {
		return "login";
		
	}
	
	@GetMapping("usercheck")
	public String userCheck(@ModelAttribute User user, Model model) {
		System.err.println("user controller >> "+user);
		boolean correct = userService.userCheck(user);
		System.err.println("correct or not "+correct);
		if (correct) {
			ArrayList<User>alUser = new ArrayList<User>();
			alUser.add(new User("pradip", "pradip123"));
			alUser.add(new User("vaibhav", "vaibhav123"));
			
			model.addAttribute("manyusers", alUser);
			return "players";
		}else {
			model.addAttribute("message", "your password is wrong");
			return "login";
		}
		
	}
}
