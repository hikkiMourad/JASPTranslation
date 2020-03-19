package com.example.jasptranslation.service.facade;

import com.example.jasptranslation.bean.JRequest;

public interface RequestService {

	public JRequest findByTextOrigine(String textOrigine);
	public JRequest save(JRequest request);
	public JRequest translate(JRequest request) throws Exception;
}
