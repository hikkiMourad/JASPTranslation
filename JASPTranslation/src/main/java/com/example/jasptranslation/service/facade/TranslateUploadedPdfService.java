package com.example.jasptranslation.service.facade;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.jasptranslation.bean.TranslateUploadedPdf;

public interface TranslateUploadedPdfService {

	public List<TranslateUploadedPdf> findByFile(byte[] file);
	public TranslateUploadedPdf save(TranslateUploadedPdf translateUploadedPdf);
	public TranslateUploadedPdf translate(String toLang,MultipartFile file );
}
