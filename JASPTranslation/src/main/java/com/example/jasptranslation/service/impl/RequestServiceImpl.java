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
		jrequest = postConnect(jrequest);
		jrequest = save(jrequest);
		return jrequest;
	}
	
	
	private static HttpRequest.BodyPublisher buildFormDataFromMap(Map<Object, Object> data) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            if (builder.length() > 0) {
                builder.append("&");
            }
            builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
            builder.append("=");
            builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
        }
        System.out.println(builder.toString());
        return HttpRequest.BodyPublishers.ofString(builder.toString());
    }
	
	public JRequest postConnect(JRequest jRequest) throws Exception {
		HttpClient httpClient = HttpClient.newBuilder()
	            .version(HttpClient.Version.HTTP_2)
	            .build();
		URI link = new URI("https://translate.yandex.net/api/v1.5/tr.json/translate?lang=fr&key=trnsl.1.1.20200319T151952Z.9235896eb67ed1dd.e6da4cce904e8141b3b1cb3edc87ccff2a1b45d0&options=1");
		Map<Object, Object> data = new HashMap();
        data.put("text", jRequest.getTextOrigine());
       

        HttpRequest request = HttpRequest.newBuilder()
                .POST(buildFormDataFromMap(data))
                .uri(link)
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> reponse = mapper.readValue(response.body(), Map.class);
        System.out.println(response.body());
        ArrayList text =   (ArrayList) reponse.get("text");
        Map<String, String> lang  = (Map<String, String>) reponse.get("detected"); 
        jRequest.setTextResult((String) text.get(0));
        jRequest.setLangOrigine(lang.get("lang"));
        jRequest.setLangResult("fr");
        return jRequest;
	}
	
	
}
