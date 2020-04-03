package com.example.jasptranslation.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StringTranslate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String textOrigine;
	private String langOrigine;
	private String textResult;
	private String langResult;
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
	
	
}
