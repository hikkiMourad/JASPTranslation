package com.example.jasptranslation.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.jasptranslation.bean.TranslateUploadedPdf;
import com.example.jasptranslation.dao.TranslateUploadedPdfDao;
import com.example.jasptranslation.service.facade.TranslateUploadedPdfService;
import com.example.jasptranslation.util.ReadPdf;

@Service
public class TranslateUploadedPdfServiceImpl implements TranslateUploadedPdfService {

	@Autowired
	TranslateUploadedPdfDao uploadedPdfDao;


	@Override
	public TranslateUploadedPdf save(TranslateUploadedPdf translateUploadedPdf) {
		return uploadedPdfDao.save(translateUploadedPdf);
	}

	@Override
	public TranslateUploadedPdf translate(String toLang ,MultipartFile file) {
		TranslateUploadedPdf translatedFile = new TranslateUploadedPdf();
		
		
			if (file.isEmpty()) {
				System.out.println("file is empty");
	        }

	        try {
	        	ReadPdf readPdf = new ReadPdf();
	        	byte[] bytes = file.getBytes();
	        	List<TranslateUploadedPdf> templist = findByFile(bytes);
	        	System.out.println(templist);
	        	if (templist.size() == 0) {
	        		System.out.println(bytes.hashCode() + " " + bytes.length);
		            translatedFile.setFile(bytes);
		            translatedFile.setToLang(toLang);
		            translatedFile.setTranslationResult(readPdf.translateFromBytes(bytes, toLang));
		            translatedFile = save(translatedFile);
		            System.out.println(file.getOriginalFilename()  + " "+file.getContentType());
	        	}else {
	        		translatedFile.setFile(bytes);
	        		translatedFile.setToLang(toLang);
	        		translatedFile.setTranslationResult(templist.get(0).getTranslationResult());
	        	}
	            
	            
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
		
		
		
		return translatedFile;
	}

	@Override
	public List<TranslateUploadedPdf> findByFile(byte[] file) {
		return uploadedPdfDao.findByFile(file);
	}
	
	
	
	
}
