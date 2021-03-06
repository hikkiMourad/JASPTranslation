package com.example.jasptranslation.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jasptranslation.bean.StringTranslate;
import com.example.jasptranslation.service.facade.StringTranslateService;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController

@RequestMapping("translateString")
public class StringTranslateRest {

	@Autowired
	StringTranslateService stringTranslateService;
	
	@PostMapping("/")
	public StringTranslate translate(@RequestBody  StringTranslate stringTranslate) {
		return stringTranslateService.translate(stringTranslate);
	}
	
	
	
}
/* example d'une requete

{
"textOrigine" : "my house",
"langResult" : "pl"
}

*/