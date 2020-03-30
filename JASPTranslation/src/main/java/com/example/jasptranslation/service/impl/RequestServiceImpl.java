package com.example.jasptranslation.service.impl;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jasptranslation.bean.JRequest;
import com.example.jasptranslation.dao.RequestDao;
import com.example.jasptranslation.service.facade.RequestService;
import com.example.jasptranslation.util.ReadPdf;
import com.example.jasptranslation.util.YandexApiConnection;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class RequestServiceImpl implements RequestService {

	@Autowired
	RequestDao requestDao;
	
	@Override
	public JRequest findByTextOrigine(String textOrigine) {
		return requestDao.findByTextOrigine(textOrigine);
	}

	@Override
	public JRequest save(JRequest request) {
		JRequest jRequestfounded = findByTextOrigine(request.getTextOrigine());
		if (jRequestfounded == null) {
			return requestDao.save(request);
		}else {
			return jRequestfounded;
		}
	}

	@Override
	public JRequest translate(JRequest jrequest) throws Exception {
		YandexApiConnection connect = new YandexApiConnection();
		ReadPdf readPdf = new ReadPdf();
		if (jrequest.getPdflinks().size() != 0) {
			return readPdf.pdfToString(jrequest);
		} else {
			if (jrequest.getTextOrigine() == "") {
				jrequest.setTextOrigine("erreue dans la requete");
				return jrequest;
			} else {
				jrequest = connect.postConnect(jrequest);
				jrequest = save(jrequest);
				return jrequest;
			}
		}
		
		
	}
	
	
	
	
	
}
