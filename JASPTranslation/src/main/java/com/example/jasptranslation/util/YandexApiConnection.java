package com.example.jasptranslation.util;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.jasptranslation.bean.PdfTranslateLink;
import com.example.jasptranslation.bean.StringTranslate;
import com.fasterxml.jackson.databind.ObjectMapper;

public class YandexApiConnection {

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
	
	public StringTranslate translateString(StringTranslate stringTranslate) throws Exception {

		HttpClient httpClient = HttpClient.newBuilder()
	            .version(HttpClient.Version.HTTP_2)
	            .build();
		if (stringTranslate.getLangResult() == null) {
			stringTranslate.setLangResult("fr");
		}
		URI link = new URI("https://translate.yandex.net/api/v1.5/tr.json/translate?lang="+stringTranslate.getLangResult()+"&key=trnsl.1.1.20200319T151952Z.9235896eb67ed1dd.e6da4cce904e8141b3b1cb3edc87ccff2a1b45d0&options=1");
		Map<Object, Object> data = new HashMap();
        data.put("text", stringTranslate.getTextOrigine());
       

        HttpRequest request = HttpRequest.newBuilder()
                .POST(buildFormDataFromMap(data))
                .uri(link)
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .build();
        System.out.println(request.toString());
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> reponse = mapper.readValue(response.body(), Map.class);
        System.out.println(response.body());
        ArrayList text =   (ArrayList) reponse.get("text");
        Map<String, String> lang  = (Map<String, String>) reponse.get("detected"); 
        stringTranslate.setTextResult((String) text.get(0));
        stringTranslate.setLangOrigine(lang.get("lang"));
        return stringTranslate;
	}
	
	public String stringTranslation(String text,String toLang) {
		try {
			HttpClient httpClient = HttpClient.newBuilder()
		            .version(HttpClient.Version.HTTP_2)
		            .build();
			if (toLang == null) {
				toLang = "fr";
			}
			URI link = new URI("https://translate.yandex.net/api/v1.5/tr.json/translate?lang="+toLang+"&key=trnsl.1.1.20200319T151952Z.9235896eb67ed1dd.e6da4cce904e8141b3b1cb3edc87ccff2a1b45d0&options=1");
			Map<Object, Object> data = new HashMap();
	        data.put("text", text);
	       

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
	        ArrayList responseArray =   (ArrayList) reponse.get("text");
	        
	        return (String) responseArray.get(0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "error";
		}
		
		
	}
}
