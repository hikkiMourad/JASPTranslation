package com.example.jasptranslation.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jasptranslation.bean.PdfLink;
import com.example.jasptranslation.bean.PdfTranslateLink;
import com.example.jasptranslation.dao.PdfTranslateLinkDao;
import com.example.jasptranslation.service.facade.PdfLinkService;
import com.example.jasptranslation.service.facade.PdfTranslateLinkService;
import com.example.jasptranslation.util.ReadPdf;

@Service
public class PdfTranslateLinkServiceImpl implements PdfTranslateLinkService {

	@Autowired
	PdfTranslateLinkDao pdfTranslateLinkDao;
	@Autowired
	PdfLinkService pdfLinkService;
	

	@Override
	public PdfTranslateLink translatePdf(PdfTranslateLink pdfTranslateLink) {
		
		ReadPdf readpdf = new ReadPdf();
		pdfTranslateLink = save(pdfTranslateLink);
		
		for (PdfLink pdflink : pdfTranslateLink.getPdflinks()) {
			System.out.println(pdflink.getUrl() + " "+pdflink.getToLang());
			 if (pdflink.getToLang() == null) {
				 pdflink.setToLang("fr");
				}
			ArrayList<PdfLink> templist = (ArrayList<PdfLink>) pdfLinkService.findByUrlAndToLang(pdflink.getUrl(), pdflink.getToLang());
			if (templist.size() == 0) {
				pdflink = readpdf.pdfToString(pdflink);
				pdflink = pdfLinkService.save(pdflink);
				System.out.println("1");
			}else {System.out.println("2");
				pdflink.setTranslationResult(templist.get(0).getTranslationResult());
			}
		}
		
		return pdfTranslateLink;
	}

	@Override
	public PdfTranslateLink save(PdfTranslateLink pdfTranslateLink) {
		return pdfTranslateLinkDao.save(pdfTranslateLink);
	}
	
	
}
