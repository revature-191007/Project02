package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Users;
import com.revature.services.LoginService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("start")
public class LoginController {
	LoginService loginService;

	@PostMapping("/login")
	//return user id if logged in in successfully
	public int checkUser(@RequestBody Users user) {
		System.out.println("Attempting Login");
		System.out.println("User Input:"+ user.getUsername() + " " + user.getHashpass());
		int OldUserId = loginService.checkUser2(user);
		return OldUserId;
	}

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Users newUser(@RequestBody Users user) {
		// return loginService.newUser(user);
		System.out.println("Attempting User Creation...");
		return loginService.createUser(user);

	}

	@Autowired
	public LoginController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}
}
