package com.example.jasptranslation.bean;

import java.net.URL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PdfLink {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private URL url;
	
	@ManyToOne
	private PdfTranslateLink pdfTranslateLink;
	
	@Column(length = 1000000)
	private String translationResult;
	
	private String toLang;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public URL getUrl() {
		return url;
	}
	public void setUrl(URL url) {
		this.url = url;
	}
	public PdfTranslateLink getPdfTranslateLink() {
		return pdfTranslateLink;
	}
	public void setPdfTranslateLink(PdfTranslateLink pdfTranslateLink) {
		this.pdfTranslateLink = pdfTranslateLink;
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
