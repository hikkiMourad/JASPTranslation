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

	
	
	@PostMapping("/")
	public JRequest translate(@RequestBody JRequest request) throws Exception {
		return requestService.translate(request);
	}
	
}
/*  --- Exemple de d'une requete pour traduire une liste de PDF a l'aide des lien http ---
{
"pdflinks" : [
	{"url" : "http://www.africau.edu/images/default/sample.pdf"},{"url" : "http://www.africau.edu/images/default/sample.pdf"}
	]
}
*/
