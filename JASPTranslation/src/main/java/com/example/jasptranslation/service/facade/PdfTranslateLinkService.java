package com.example.jasptranslation.service.facade;

import com.example.jasptranslation.bean.PdfTranslateLink;

public interface PdfTranslateLinkService {

	public PdfTranslateLink translatePdf (PdfTranslateLink pdfTranslateLink);
	public PdfTranslateLink save(PdfTranslateLink pdfTranslateLink);
}
