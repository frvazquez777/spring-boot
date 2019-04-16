package com.frvazquez.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example2")
public class Example2Controller {

	private static final String EXAMPLE_VIEW = "example3";

	//parametros 1er forma
	@GetMapping("/request1")
	public ModelAndView peticion1(@RequestParam(name = "nm", required = false, defaultValue = "FRVAZQUEZ") String name) {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("nm_in_model", name);
		return mav;
	}
	
	
	//parametros 2da. forma
	@GetMapping("/request2/{nm}")
	public ModelAndView peticion2(@PathVariable("nm") String name) {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("nm_in_model", name);
		return mav;
	}
	
}
