package com.petclinic.shawn.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {
	
	HashMap<String, Object> visits = new HashMap<String, Object>();

	@PostMapping("/mark-visit")
	public HashMap<String, Object> markVisit(@RequestParam String petOwnerName, @RequestParam String petOwnerPhone, 
			@RequestParam String petName, @RequestParam String petBreed) {
		
		HashMap<String, Object> response = new HashMap<String, Object>();
		response.put("code", 1);
		String dateTimeStamp = new Date().toString();
		response.put("visit", dateTimeStamp);
		response.put("message", "Thank you "+petOwnerName+" for visiting Dr Shawn for your pet "+petName);
		
		visits.put(dateTimeStamp, response);
		
		return response;
	}
	
	@GetMapping("/visits")
	public HashMap<String, Object> getVisits() {
		
		HashMap<String, Object> response = new HashMap<String, Object>();
		response.put("code", 1);
		response.put("total", visits.size());
		response.put("visits", visits);
				
		return response;
	}
	
}
