package com.reserpadel.services;

import java.util.List;

import com.reserpadel.domain.Persona;

public interface PersonlService{
	
	Persona create(Persona p);
	List<Persona> findAll();
	Persona findById(String email);
	Persona update(String email, Persona p);
	Persona delete(String email);

}