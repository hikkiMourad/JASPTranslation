package com.example.jasptranslation.service.impl;

import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jasptranslation.bean.PdfLink;
import com.example.jasptranslation.dao.PdfLinkDao;
import com.example.jasptranslation.service.facade.PdfLinkService;

@Service
public class PdfLinkServiceImpl implements PdfLinkService {

	@Autowired
	PdfLinkDao pdfLinkDao;


	@Override
	public List<PdfLink> findByUrlAndToLang(URL url,String toLang) {
		return pdfLinkDao.findByUrlAndToLang(url, toLang);
	}

	@Override
	public PdfLink save(PdfLink link) {
		return pdfLinkDao.save(link);
	}
	
	
}
