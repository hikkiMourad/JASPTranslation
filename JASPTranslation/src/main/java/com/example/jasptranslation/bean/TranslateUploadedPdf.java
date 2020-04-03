package com.example.jasptranslation.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

@Entity

public class TranslateUploadedPdf {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private byte[] file;
	@Column(length = 1000000)
	private String translationResult;
	private String toLang;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public String getTranslationResult() {
		return translationResult;
	}
	public void setTranslationResult(String translationResult) {
		this.translationResult = translationResult;
	}
	public String getToLang() {
		return toLang;
	}
	public void setToLang(String toLang) {
		this.toLang = toLang;
	}
	
	
	
	
}
