package com.example.jasptranslation.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.jasptranslation.bean.TranslateUploadedPdf;
import com.example.jasptranslation.dao.TranslateUploadedPdfDao;
import com.example.jasptranslation.service.facade.TranslateUploadedPdfService;

@Service
public class TranslateUploadedPdfServiceImpl implements TranslateUploadedPdfService {

	@Autowired
	TranslateUploadedPdfDao uploadedPdfDao;

	@Override
	public List<TranslateUploadedPdf> findByFileAndToLang(MultipartFile file, String toLang) {
		return uploadedPdfDao.findByFileAndToLang(file, toLang);
	}

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
        	String UPLOADED_FOLDER = "C:\\Users\\op\\Desktop\\temp\\";
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            System.out.println(file.getOriginalFilename() + " " + path);
            Files.write(path, bytes);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
		return translatedFile;
	}
	
	
	
	
}
