package com.example.jasptranslation.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jasptranslation.bean.JRequest;
import com.example.jasptranslation.service.facade.RequestService;

@RestController
@RequestMapping("translate/")
public class JRequestRest {

	@Autowired
	RequestService requestService;

	
	
	@PostMapping("translate/")
	public JRequest translate(@RequestBody JRequest request) {
		return requestService.translate(request);
	}
	
}
