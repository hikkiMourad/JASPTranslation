package com.example.jasptranslation.dao;

import java.net.URL;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jasptranslation.bean.PdfLink;

public interface PdfLinkDao extends JpaRepository<PdfLink, Long>{

	public List<PdfLink> findByJRequestId(Long Id);
	public List<PdfLink> findByUrl(URL url);
	
}
