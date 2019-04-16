package com.frvazquez.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/say")
public class InitController {

	@GetMapping("/helloworld")
	public String getWelcome() {
		return "helloworld";
	}
	
}
