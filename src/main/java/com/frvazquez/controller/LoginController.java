package com.frvazquez.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.frvazquez.constant.ViewConstant;

@Controller
public class LoginController {

	private static final Log LOG = LogFactory.getLog(LoginController.class);


//	@GetMapping("/")
//	public String redictToLogin() {
//		LOG.info("Rediccion a Login");
//		return ViewConstant.REDIRECT_TO_LOGIN;
//	}

	@GetMapping("/login")
	public String showLoginForm(Model model,
			@RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		LOG.info("Formulario Login");
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
//		model.addAttribute("userCredentials", new UserCredential());
		return ViewConstant.LOGIN_VIEW;
	}

//	@PostMapping("/logincheck")
//	public String loginCheck(@ModelAttribute(name = "userCredentials") UserCredential userCredential) {
//		LOG.info("credenciales : " + userCredential);
//		if (userCredential.validUsername("frvazquez") && userCredential.validPassword("1234")) {
//			LOG.info("ACCESO PERMITOD");
//			return ViewConstant.REDIRECT_TO_CONTACTS;
//		}
//		return ViewConstant.REDIRECT_TO_LOGIN + "?error";
//	}
	
	@GetMapping({"/loginsuccess", "/"})
	public String loginSuccess() {
		LOG.info("Login method");
		return ViewConstant.REDIRECT_TO_CONTACTS;
	}

}
