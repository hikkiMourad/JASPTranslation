package com.example.jasptranslation.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jasptranslation.bean.PdfTranslateLink;
import com.example.jasptranslation.service.facade.PdfTranslateLinkService;

@RestController
@RequestMapping("translate-pdf-of-link/")
public class PdfTranslateLinkRest {
	@Autowired
	PdfTranslateLinkService pdfTranslateLinkService;
	
	@PostMapping("/")
	public PdfTranslateLink translatePdf(@RequestBody PdfTranslateLink pdfTranslateLink) {
		return pdfTranslateLinkService.translatePdf(pdfTranslateLink);
	}

	

}
/*Example d'une requete
{
"pdflinks" : [
	{"url" : "http://www.africau.edu/images/default/sample.pdf"  ,"toLang" : "fr"}
	]

}
*/