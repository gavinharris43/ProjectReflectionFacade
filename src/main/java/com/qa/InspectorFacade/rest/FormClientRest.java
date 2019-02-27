package com.qa.InspectorFacade.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qa.InspectorFacade.persistence.domain.ReflectionForm;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class FormClientRest {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private MongoClientRest mongoclient;
	
	@Value("${url.form}")
	private String formURL;
	
	@Value("${path.formBase}")
	private String formBase;
	
	@Value("${path.formCreateForm}")
	private String createFormPath;
	
	@PostMapping("${path.formCreateForm}")
    public ResponseEntity<ReflectionForm> createForm(@RequestBody ReflectionForm form) {
		
        return restTemplate.postForEntity(formURL + formBase + createFormPath, form, ReflectionForm.class);
    }
	
	@GetMapping("${path.getFormsForTrainee}")
	public ResponseEntity<String> getForm(@PathVariable String email) {
		return mongoclient.mongoGetAllFormsSpecificTraineeByEmail(email);
	}
	
	@GetMapping("${path.getAllForms}")
	public ResponseEntity<String> getAllForms() {
		return mongoclient.mongoGetAllForms();
}
	
	@DeleteMapping("${path.deleteForm}")
	public String deleteForm(@PathVariable String email) {
		return mongoclient.deleteFormByEmail(email);
	}

}
