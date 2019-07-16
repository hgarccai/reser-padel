package com.reserpadel.controllers;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reserpadel.domain.Persona;


//@Controller   //con controller espera que se devuelva una vista
@RestController //con restcontroller devuelve json
@RequestMapping("/personas")
public class PersonaController {
	
	//SOLO PUEDE HABER UN ÚNICO MÉTODO *MAPPING, PARA UNA MISMA DIRECCIÓN, SI NO DARÁ ERROR MÉTODO AMBIGUO
	
	@GetMapping
	public List<Persona> findAll() {
		return new ArrayList<>();
	}
	
	@GetMapping("/{email}")
	public Persona findByID(@PathVariable String email){
		return new Persona();
	}
	
	@PostMapping
	public void create() {
		
	}
	
	@DeleteMapping
	public void delete(/*byId*/) {
		
	}
	
	@PutMapping
	public void update(/*byId*/) {
		
	}
}
