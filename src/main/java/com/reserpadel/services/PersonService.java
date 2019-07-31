package com.reserpadel.services;

import java.util.List;

import com.reserpadel.domain.Persona;
import com.reserpadel.dto.PersonDto;

public interface PersonService{
	
	Persona create(Persona p);
	List<Persona> findAll();
	Persona findById(String email);
	Persona update(String email, PersonDto p);
	Persona delete(String email);

}