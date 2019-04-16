package com.frvazquez.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.frvazquez.component.ExampleComponent;
import com.frvazquez.model.Person;
import com.frvazquez.service.ExampleService;

@Controller
@RequestMapping("example")
public class Example1Controller {

	public static final String EXAMPLE_VIEW = "example";
	public static final String PEOPLE_VIEW = "example2";
	
	//injectar componente
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	
	//insertamos el servicio
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;
	
	// 1er forma de invocacion
	@RequestMapping(value = "/exampleString", method = RequestMethod.GET)
	public String exampleStrin(Model model) {
		exampleComponent.sayHello();
		model.addAttribute("person", new Person("Frvazquez", 30));
		return EXAMPLE_VIEW;
	}
	
	// 2da forma de invocacion - recomendable
	@GetMapping("exampleMAV")
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("person", new Person("Fredy", 31));
		return mav;
	}

	@GetMapping("people")
	public ModelAndView people() {
		ModelAndView mav = new ModelAndView(PEOPLE_VIEW);
		mav.addObject("people", exampleService.getListPeople());
		return mav;
	}
	
}
