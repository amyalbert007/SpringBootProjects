package com.cg.registrationapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.registrationapp.model.Registration;

@Repository
public interface RegistrationJpaDao extends JpaRepository<Registration,Integer>{

}
