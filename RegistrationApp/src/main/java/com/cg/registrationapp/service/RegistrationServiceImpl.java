package com.cg.registrationapp.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.registrationapp.dao.RegistrationJpaDao;
import com.cg.registrationapp.exception.RegistrationNotFoundException;
import com.cg.registrationapp.model.Registration;
@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService{
	@Autowired
	private RegistrationJpaDao itenantdao;

	String RegistrationNotFound="Registration with given id was not found";

	@Override
	public Registration addRegistration(Registration register)throws RegistrationNotFoundException {
		// TODO Auto-generated method stub
		
		validateRegistration(register);
		
		return itenantdao.save(register);
	}

	@Override
	public List<Registration> viewAllRegistrations() {
		// TODO Auto-generated method stub
		
		return itenantdao.findAll();
	}
	@Override
	public Registration viewRegistrationById(Integer regId)throws RegistrationNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Registration> optional= itenantdao.findById(regId);
		if(optional.isPresent())
		{

			Registration register=optional.get();
			
			return register;

		}
		else
		{
			throw new RegistrationNotFoundException("Registration ID not found");
		}
	}

	@Override
	public Registration updateRegistration(Registration register)throws RegistrationNotFoundException {
		
		Optional<Registration> optional= itenantdao.findById(register.getRegId());
		if(optional.isPresent())
		{
			validateRegistration(register);
			
			return itenantdao.save(register);

		}
		else
			throw new RegistrationNotFoundException("Tenant ID not found");
	}



	@Override
	public Boolean deleteRegistration(Integer regId)throws RegistrationNotFoundException {
		
		Optional<Registration> optional=itenantdao.findById(regId);
		itenantdao.deleteById(regId);

		if(optional.isPresent())
		{
			
			return true;
		}

		throw new RegistrationNotFoundException("registration ID not found");

	}


	@Override
	public Registration validateRegistration(Integer regId) {
		return null;
	}

	public static void validateRegistration(Registration register)throws RegistrationNotFoundException
	{
		

		validateRegistrationId(register.getRegId());
		validateRegistrationAge(register.getAge());
		validateRegistrationCity(register.getCity());
		validateRegistrationState(register.getState());
		validateRegistrationCountry(register.getCountry());
		validateRegistrationPin(register.getPin());
		
	}

	public static Boolean validateRegistrationCountry(String country)throws RegistrationNotFoundException {

		
		boolean flag=false;
		if(country.isEmpty())
		{
			
			throw new RegistrationNotFoundException("Country cannot be Empty");
		}
		else if (!country.matches("^[a-zA-Z ][A-Za-z\\s]+$"))
		{
			
			throw new RegistrationNotFoundException("Country cannot contain Numbers or Special Characters");
		}
		else
		{
			
			flag=true;
		}
		
		return flag;

	}

	private static Boolean validateRegistrationPin(Integer pin)throws RegistrationNotFoundException {

		
		boolean flag=false;
		if(pin<=0)
		{
			
			throw new RegistrationNotFoundException("PinCode cannot be negative");	
		}
		else if(Integer.toString(pin).length() != 6)
		{
			
			throw new RegistrationNotFoundException("PinCode should be of length 6");		
		}
		else if(!Integer.toString(pin).matches("^[0-9]+$"))
		{
			
			throw new RegistrationNotFoundException("PinCode cannot contain Alphabets or Special Characters");	
		}
		else
		{
			
			flag=true;
		}
		
		return flag;

	}

	private static Boolean validateRegistrationState(String state)throws RegistrationNotFoundException {

		//LOGGER.info("validateTenantState() is initiated");
		boolean flag=false;
		if(state.isEmpty())
		{
			//LOGGER.error("State cannot be empty");
			throw new RegistrationNotFoundException("State cannot be Empty");
		}
		else if (!state.matches("^[a-zA-Z ][A-Za-z\\s]+$"))
		{
			//LOGGER.error("State cannot contain Numbers or Special Characters");
			throw new RegistrationNotFoundException("State cannot contain Numbers or Special Characters");
		}
		else
		{
			//LOGGER.info("validation Successful");
			flag=true;
		}
		//LOGGER.info("validateTenantState() has executed");
		return flag;	
	}

	private static Boolean validateRegistrationCity(String city)throws RegistrationNotFoundException {

		//LOGGER.info("validateTenantCity() is initiated");
		boolean flag=false;
		if(city.isEmpty())
		{
			//LOGGER.error("City cannot be empty");
			throw new RegistrationNotFoundException("City cannot be Empty");
		}
		else if (!city.matches("^[a-zA-Z ][A-Za-z\\s]+$"))
		{
			//LOGGER.error("City cannot contain Numbers or Special Characters");
			throw new RegistrationNotFoundException("City cannot contain Numbers or Special Characters");
		}
		else
		{
			//LOGGER.info("validation Successful");
			flag=true;
		}
		//LOGGER.info("validateTenantCity() has executed");
		return flag;	

	}

	

	


	private static Boolean validateRegistrationAge(Integer age)throws RegistrationNotFoundException {
		//LOGGER.info("validateTenantAge() is initiated");
		boolean flag=false;
		if(age<18)
		{
			//LOGGER.error("Age less than 18 is not allowed");
			throw new RegistrationNotFoundException("Tenant age should be greater than 18");
		}
		if(age>100)
		{
			//LOGGER.error("Age greater than 100 is not allowed");
			throw new RegistrationNotFoundException("Tenant age should not be greater than 100");
		}
		else
		{
			//LOGGER.info("validation Successful");
			flag=true;
		}
		//LOGGER.info("validateTenantAge() has executed");
		return flag;
	}

	private static Boolean validateRegistrationId(int tenantId)throws RegistrationNotFoundException {

		//LOGGER.info("validateTenantId() is initiated");
		boolean flag=false;
		if(tenantId > 0 && tenantId<1000)
		{
			//LOGGER.info("validation Successful");
			flag=true;			
		}
		else
		{
			throw new RegistrationNotFoundException("Tenant ID cannot be 0 or negative or greater than 1000");
		}
		//LOGGER.info("validateTenantId() has executed");
		return flag;

	}

}
