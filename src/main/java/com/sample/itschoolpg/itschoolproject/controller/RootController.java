package com.sample.itschoolpg.itschoolproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

  @GetMapping("/")
  public String index() {
    return "index";
  }
  
  @GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}

  @GetMapping("/logout")
  public String showLogoutForm() {
    return "logout";
  }

}
