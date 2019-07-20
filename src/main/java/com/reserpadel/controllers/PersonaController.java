package com.reserpadel.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reserpadel.domain.Persona;
import com.reserpadel.services.PersonService;


//@Controller   //con controller espera que se devuelva una vista
@RestController //con restcontroller devuelve json
@RequestMapping("/personas")
public class PersonaController {

	private PersonService personService;
	
	public PersonaController(PersonService personService) {
		this.personService = personService;
		
	}
	
	//SOLO PUEDE HABER UN ÚNICO MÉTODO *MAPPING, PARA UNA MISMA DIRECCIÓN, SI NO DARÁ ERROR MÉTODO AMBIGUO
	
	@GetMapping
	public List<Persona> findAll() {
		return new ArrayList<>();
	}
	
	@GetMapping("/{email}")
	public Persona findByID(@PathVariable String email){
		return personService.findById(email);
	}
	
	@PostMapping
	public Persona create(@RequestBody Persona p) {
		return personService.create(p);
	}
	
	@DeleteMapping("/{email}")
	public void delete(/*byId*/) {
		
	}
	
	@PutMapping("/{email}")
	public void update(/*byId*/) {
		
	}
}
