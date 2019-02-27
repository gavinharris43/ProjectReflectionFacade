package com.qa.InspectorFacade.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class FormClientRest {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${url.form}")
	private String formURL;
	
	@Value("${path.formBase}")
	private String formBase;
	
	@Value("${path.formCreateForm}")
	private String createFormPath;
	
	@PostMapping("${path.formCreateForm}")
    public String createForm(String data) {
		
        restTemplate.put(formURL + formBase + createFormPath, data);
        return "sentItYo";
    }

}
