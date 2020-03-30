package com.example.jasptranslation.service.facade;

import java.net.URL;
import java.util.List;

import com.example.jasptranslation.bean.PdfLink;

public interface PdfLinkService {

	public List<PdfLink> findByJrequestId(Long Id);
	public List<PdfLink> findByUrl(URL url);
	public PdfLink save(PdfLink link);
}
