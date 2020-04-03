package com.example.jasptranslation.service.facade;

import com.example.jasptranslation.bean.PdfTranslateLink;
import com.example.jasptranslation.bean.StringTranslate;

public interface StringTranslateService {
	public StringTranslate findByTextOrigineAndLangResult(String textOrigine,String langResult);
	public StringTranslate save(StringTranslate stringTranslate);
	public StringTranslate translate(StringTranslate stringTranslate);

}
