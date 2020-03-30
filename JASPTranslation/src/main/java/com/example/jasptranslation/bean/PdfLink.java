package com.example.jasptranslation.bean;

import java.net.URL;

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
	private JRequest jrequest;
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
	
	
}
