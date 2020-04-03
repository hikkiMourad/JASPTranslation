package com.example.jasptranslation.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.jasptranslation.bean.TranslateUploadedPdf;
import com.example.jasptranslation.service.facade.TranslateUploadedPdfService;

@RestController
@RequestMapping("translate-uploaded-pdf/")
public class TranslateUploadedPdfRest {

	@Autowired
	TranslateUploadedPdfService service;
	@PostMapping("/")
	public TranslateUploadedPdf translate(@RequestParam("TranslateTo")String toLang,@RequestParam("pdfFile") MultipartFile file) {
		return service.translate(toLang, file);
	}

	
	
	
	
}
