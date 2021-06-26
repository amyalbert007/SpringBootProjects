package com.cg.registrationapp.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.registrationapp.exception.RegistrationNotFoundException;
import com.cg.registrationapp.model.Registration;
import com.cg.registrationapp.service.RegistrationService;

@RestController
@RequestMapping("/register")
public class RegistrationController {
	@Autowired 
	private RegistrationService iRegistrationService;
	
	@GetMapping("/viewAllRegistrations")
	public List<Registration> viewAllRegistrations(){
		
		return  iRegistrationService.viewAllRegistrations();
	} 
	
	@GetMapping("/viewRegistrationById/{regId}")
	public ResponseEntity viewRegistrationById(@PathVariable Integer regId) throws RegistrationNotFoundException {
		Registration register= iRegistrationService.viewRegistrationById(regId);
		
		return new ResponseEntity(register,HttpStatus.OK); 
		
	}
	
	@PostMapping("/addRegistration")
	public Registration addRegistration(@RequestBody Registration register) throws RegistrationNotFoundException{
		
		return iRegistrationService.addRegistration(register);
	}
	
	@DeleteMapping("/deleteRegistration/{regId}")
	public ResponseEntity deleteRegistration(@PathVariable Integer regId ) throws RegistrationNotFoundException {
		
		iRegistrationService.deleteRegistration(regId);
				
				return new ResponseEntity("Registration data deleted succesfully",HttpStatus.OK);
	}	
	
	
	
	@Validated
	public Registration validateRegistration(@RequestBody Integer regId ) {
		return iRegistrationService.validateRegistration(regId);
	} 
	
	@PutMapping("/updateRegistration")
	public Registration updateRegistration(@RequestBody Registration register) throws RegistrationNotFoundException {
		Registration register1=iRegistrationService.updateRegistration(register);
		
		return register1; 
	}
	

}
