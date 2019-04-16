package com.frvazquez.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.frvazquez.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {

	private static final Log LOG = LogFactory.getLog(Example3Controller.class);

	private static final String EXAMPLE_VIEW = "form";
	private static final String RESULT_VIEW = "result";

	// forma 1 de redireccion
	@GetMapping("/redirect")
	public String redirect() {
		return "redirect:/example3/showform";
	}

	// forma 2 de redireccion
	@GetMapping("/")
	public RedirectView redirect2() {
		return new RedirectView("showform");// solo el nombre del path que se encuentre dentro mis request mapping
	}

	@GetMapping("/error")
	public String showError(Model model) {
		model.addAttribute("person", new Person());
		int i = 6 / 0;
		System.out.println(i);
		return EXAMPLE_VIEW;
	}

	@GetMapping("/showform")
	public String showForm(Model model) {
		LOG.info("Iniciando Formulario...");
		model.addAttribute("person", new Person());
		return EXAMPLE_VIEW;
	}

	@PostMapping("/addperson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
		LOG.info("VALORES OBTENIDOS DEL FORMULARIO.");
		LOG.info(person);
		ModelAndView mav = new ModelAndView();

		if(bindingResult.hasErrors()) {
			mav.setViewName(EXAMPLE_VIEW);
		}else {
			mav.setViewName(RESULT_VIEW);
			mav.addObject("person", person);
		}
		return mav;
	}
}
