package com.example.jasptranslation.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PdfTranslationString {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String translatedText;
	@ManyToOne
	private JRequest jrequest;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTranslatedText() {
		return translatedText;
	}
	public void setTranslatedText(String translatedText) {
		this.translatedText = translatedText;
	}
	public JRequest getJrequest() {
		return jrequest;
	}
	public void setJrequest(JRequest jrequest) {
		this.jrequest = jrequest;
	}
	public PdfTranslationString(String translatedText) {
		super();
		this.translatedText = translatedText;
	}
	
	
}
