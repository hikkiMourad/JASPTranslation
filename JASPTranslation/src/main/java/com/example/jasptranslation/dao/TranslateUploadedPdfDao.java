package com.example.jasptranslation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.example.jasptranslation.bean.TranslateUploadedPdf;

@Repository
public interface TranslateUploadedPdfDao extends JpaRepository<TranslateUploadedPdf, Long> {

	public List<TranslateUploadedPdf> findByFileAndToLang(MultipartFile file,String toLang);
	
}
