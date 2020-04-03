package com.example.jasptranslation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jasptranslation.bean.StringTranslate;
import com.example.jasptranslation.dao.StringTranslateDao;
import com.example.jasptranslation.service.facade.StringTranslateService;
import com.example.jasptranslation.util.YandexApiConnection;

@Service
public class StringTranslateServiceImpl implements StringTranslateService {
	@Autowired
	StringTranslateDao stringTranslateDao;

	

	
	@Override
	public StringTranslate findByTextOrigineAndLangResult(String textOrigine, String langResult) {
		return stringTranslateDao.findByTextOrigineAndLangResult(textOrigine, langResult);
	}
	@Override
	public StringTranslate save(StringTranslate stringTranslate) {
			return stringTranslateDao.save(stringTranslate);
		
	}
	@Override
	public StringTranslate translate(StringTranslate stringTranslate) {
		YandexApiConnection connect = new YandexApiConnection();
		StringTranslate founded = findByTextOrigineAndLangResult(stringTranslate.getTextOrigine(),stringTranslate.getLangResult());
		if (founded != null ) {
			return founded;
		} else {
			try {
				stringTranslate = connect.translateString(stringTranslate);
				stringTranslate = save(stringTranslate);
				return stringTranslate;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return stringTranslate;
			}
		}
	}
	
	
	
}
