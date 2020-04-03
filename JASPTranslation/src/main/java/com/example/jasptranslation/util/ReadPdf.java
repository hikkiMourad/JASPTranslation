package com.example.jasptranslation.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import com.example.jasptranslation.bean.PdfLink;

public class ReadPdf {
	public PdfLink pdfToString(PdfLink pdfLink) {
		YandexApiConnection yandexApiConnection = new YandexApiConnection();
		String pdfFileInText = null;
			InputStream is = null;
			try {
				HttpURLConnection connection=(HttpURLConnection)pdfLink.getUrl().openConnection();
				 is = connection.getInputStream();
			} catch (IOException e1) {
				System.out.println("errur1" + e1.getMessage());
			}
			try (PDDocument document = PDDocument.load(is)) {

	            document.getClass();

	            if (!document.isEncrypted()) {
				
	                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
	                stripper.setSortByPosition(true);

	                PDFTextStripper tStripper = new PDFTextStripper();

	               
	                
	                pdfFileInText = tStripper.getText(document);
	                pdfFileInText =  yandexApiConnection.stringTranslation(pdfFileInText,pdfLink.getToLang());
	                if (pdfFileInText.length() > 10000) {
	                	pdfFileInText = "more than 10000 char";
					}
	               	                	
	            }

	        }
			catch (Exception e) {
				System.out.println("erreur2 " + e.getMessage());
			}
			pdfLink.setTranslationResult(pdfFileInText);
		return pdfLink;
	}
}
