package com.frvazquez.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.frvazquez.constant.ViewConstant;
import com.frvazquez.model.ContactModel;
import com.frvazquez.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {

	private static final Log LOG = LogFactory.getLog(ContactController.class);

	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/contactform")
	public String redirectContactForm(Model model) {
		LOG.info("Formulario add contacts");
		ContactModel contactModel = new ContactModel();
		contactModel.setSu(false);
		model.addAttribute("contactModel", contactModel);
		return ViewConstant.CONTACT_FORM;
	}

	@GetMapping("/cancel")
	public String cancel() {
		LOG.info("Cancel ADD Contacts");
		return ViewConstant.REDIRECT_TO_CONTACTS;
	}

	@GetMapping("/listcontact")
	public ModelAndView listContacts() {
		LOG.info("List ADD Contacts");
		ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS_VIEW);
		
		User user  = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("username", user.getUsername());
		List<ContactModel> list = contactService.allContacts();
		mav.addObject("contacts", list);
		return mav;
	}

	@PostMapping("/addcontact")
	public ModelAndView addContact(@Valid @ModelAttribute(name = "contactModel") ContactModel contactModel,
			BindingResult bindingResult) {

		LOG.info("ADD CONTACT : " + contactModel);
		boolean valid = false;
		ModelAndView mav = new ModelAndView(ViewConstant.REDIRECT_TO_CONTACTS);
		mav.addObject("result", 1);
		mav.addObject("valid", valid);

		if (bindingResult.hasErrors()) {
			LOG.error("ERROR VALID FORM");				
			mav.setViewName(ViewConstant.CONTACT_FORM);
		} else {
			if(contactModel.getSu()) {
				LOG.info("MODIFY Contact");

				contactModel = contactService.updateContact(contactModel);
			} else {
				LOG.info("Valid Exist Contact");

				valid = contactService.addContact(contactModel);

				if (valid) {
					LOG.info("Contact Process ADD.");
					mav.addObject("valid", valid);
					mav.addObject("contactModel", contactModel);
					mav.setViewName(ViewConstant.CONTACT_FORM);
				}
			}
			
		}

		return mav;
	}

	@GetMapping("/updatecontact")
	public ModelAndView updateContact(@RequestParam(name = "telephone", required = true) String telephone) {
		LOG.info("Update CONTACT -- PARAM: " + telephone);
		ModelAndView mav = new ModelAndView(ViewConstant.CONTACT_FORM);
		ContactModel contactModel = contactService.findByTelephone(telephone);
		contactModel.setSu(true);
		mav.addObject("contactModel", contactModel);
		return mav;
	}
	
	@GetMapping("/removecontact")
	public ModelAndView removeContact(@RequestParam(name = "telephone", required = true) String telephone) {
		LOG.info("REMOVE CONTACT -- PARAM: " + telephone);
		contactService.removeContact(telephone);
		return listContacts();
	}
}
