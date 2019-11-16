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
		int userId = loginService.checkUser2(user);
		return userId;
	public int checkUser(@RequestBody Users user) {
		Users oldUser = loginService.checkUser(user);
		return oldUser.getId();
	}

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Users newUser(@RequestBody Users user) {
		// return loginService.newUser(user);
		System.out.println("Attempting Creation");
		return loginService.createUser(user);
	public int newUser(@RequestBody Users user) {
		Users newUser = loginService.create(user);
		return newUser.getId();
	}

	@Autowired
	public LoginController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}
}
