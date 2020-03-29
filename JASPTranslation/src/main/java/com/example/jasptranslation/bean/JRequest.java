package com.example.jasptranslation.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class JRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String textOrigine;
	private String langOrigine;
	private String textResult;
	private String langResult;
	@OneToMany(mappedBy = "jRequest")
	private List<PdfLink> pdflinks;
	private List<String> pdfTranslation;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTextOrigine() {
		return textOrigine;
	}
	public void setTextOrigine(String textOrigine) {
		this.textOrigine = textOrigine;
	}
	public String getLangOrigine() {
		return langOrigine;
	}
	public void setLangOrigine(String langOrigine) {
		this.langOrigine = langOrigine;
	}
	public String getTextResult() {
		return textResult;
	}
	public void setTextResult(String textResult) {
		this.textResult = textResult;
	}
	public String getLangResult() {
		return langResult;
	}
	public void setLangResult(String langResult) {
		this.langResult = langResult;
	}
	public List<PdfLink> getPdflinks() {
		return pdflinks;
	}
	public void setPdflinks(List<PdfLink> pdflinks) {
		this.pdflinks = pdflinks;
	}
	public List<String> getPdfTranslation() {
		return pdfTranslation;
	}
	public void setPdfTranslation(List<String> pdfTranslation) {
		this.pdfTranslation = pdfTranslation;
	}
	
	
	
	
}
