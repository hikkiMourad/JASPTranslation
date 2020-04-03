package com.example.jasptranslation.service.facade;

import java.net.URL;
import java.util.List;

import com.example.jasptranslation.bean.PdfLink;
import com.example.jasptranslation.bean.PdfTranslateLink;

public interface PdfLinkService {

	public List<PdfLink> findByUrlAndToLang(URL url,String toLang);
	public PdfLink save(PdfLink link);
}
