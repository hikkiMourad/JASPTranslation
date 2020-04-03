package com.example.jasptranslation.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PdfTranslateLink {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany(mappedBy = "pdfTranslateLink")
	private List<PdfLink> pdflinks;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<PdfLink> getPdflinks() {
		return pdflinks;
	}
	public void setPdflinks(List<PdfLink> pdflinks) {
		this.pdflinks = pdflinks;
	}
	

	
	
	
	
}
