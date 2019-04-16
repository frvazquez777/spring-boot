package com.frvazquez.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frvazquez.model.ContactModel;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

	@GetMapping("/checkrest")
	public ResponseEntity<String> checkrest(){
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}
	
	@GetMapping("/checkrest2")
	public ResponseEntity<ContactModel> checkrest2(){
		ContactModel cm = new ContactModel("frvazquez", "vazquez", "9812087422", "MTY");
		return new ResponseEntity<ContactModel>(cm, HttpStatus.OK);
	}
	
}
