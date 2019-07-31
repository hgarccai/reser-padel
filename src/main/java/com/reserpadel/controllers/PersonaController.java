package com.reserpadel.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reserpadel.domain.Persona;
import com.reserpadel.dto.PersonDto;
import com.reserpadel.services.PersonService;

//import java.util.HashMap;
//import java.util.Map;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ResponseStatus;

//@Controller   //con controller espera que se devuelva una vista
@RestController // con restcontroller devuelve json
@RequestMapping("/personas")
public class PersonaController {

	private PersonService personService;

	public PersonaController(PersonService personService) {
		this.personService = personService;
	}

	@PostMapping
	public Persona create(@Valid @RequestBody Persona p) {
		return personService.create(p);
	}

	@GetMapping
	public List<Persona> findAll() {
		return new ArrayList<>();
	}
	
	// SOLO PUEDE HABER UN ÚNICO MÉTODO *MAPPING, PARA UNA MISMA DIRECCIÓN, SI NO
	// DARÁ ERROR MÉTODO AMBIGUO
	
	@GetMapping("/{email}")
	public Persona findByID(@PathVariable String email) {
		return personService.findById(email);
	}


	@PutMapping("/{email}")
	public Persona update(@PathVariable String email, @Valid @RequestBody PersonDto personDto) {
		return personService.update(email, personDto);
	}
	
	@DeleteMapping("/{email}")
	public Persona delete(@PathVariable String email) {
		return personService.delete(email);
	}
}
