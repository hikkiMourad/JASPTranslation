package com.example.jasptranslation.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import com.example.jasptranslation.bean.JRequest;
import com.example.jasptranslation.bean.PdfLink;
import com.example.jasptranslation.bean.PdfTranslationString;

public class ReadPdf {
	public JRequest pdfToString(JRequest jRequest) {
		YandexApiConnection yandexApiConnection = new YandexApiConnection();
		List<PdfTranslationString> tempList = new ArrayList<>();
		for (PdfLink  plink: jRequest.getPdflinks()) {
			InputStream is = null;
			try {
				HttpURLConnection connection=(HttpURLConnection)plink.getUrl().openConnection();
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

	                String pdfFileInText = tStripper.getText(document);
	                pdfFileInText =  yandexApiConnection.stringTranslation(pdfFileInText);
	                if (pdfFileInText.length() > 10000) {
	                	pdfFileInText = "more than 10000 char";
					}
	               
	                	tempList.add(new PdfTranslationString(pdfFileInText));
	                	
	            }

	        }
			catch (Exception e) {
				System.out.println("erreur2 " + e.getMessage());
			}

		}
		
		jRequest.setTranslationStrings(tempList);
		return jRequest;
	}
}
