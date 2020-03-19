package com.example.jasptranslation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jasptranslation.bean.JRequest;
import com.example.jasptranslation.dao.RequestDao;
import com.example.jasptranslation.service.facade.RequestService;

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
			requestDao.save(request);
			return request;
		}else {
			return jRequestfounded;
		}
	}

	@Override
	public JRequest translate(JRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
