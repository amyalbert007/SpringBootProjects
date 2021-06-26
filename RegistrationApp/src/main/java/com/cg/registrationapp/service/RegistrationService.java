package com.cg.registrationapp.service;
import java.util.List;

import com.cg.registrationapp.exception.RegistrationNotFoundException;
import com.cg.registrationapp.model.Registration;

public interface RegistrationService {
	public Registration addRegistration(Registration register)throws RegistrationNotFoundException;

	public List<Registration> viewAllRegistrations();

	public Registration viewRegistrationById(Integer regId)throws RegistrationNotFoundException;

	public Registration updateRegistration(Registration register)throws RegistrationNotFoundException;

	public Boolean deleteRegistration(Integer regId)throws RegistrationNotFoundException;

	public Registration validateRegistration(Integer regId);

}
