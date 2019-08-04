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

import com.reserpadel.domain.Pista;
import com.reserpadel.dto.PadelFloorDto;
import com.reserpadel.services.FloorService;

@RestController
@RequestMapping("/pistas")
public class PistaController {
	
	private FloorService floorservice;

	public PistaController(FloorService floorservice) {
		this.floorservice = floorservice;
	}

	@PostMapping
	public Pista create(@Valid @RequestBody Pista p) {
		return floorservice.create(p);
	}

	@GetMapping
	public List<Pista> findAll() {
		return new ArrayList<>();
	}
	
	@GetMapping("/{id}")
	public Pista findByID(@PathVariable Integer floorid) {
		return floorservice.findById(floorid);
	}


	@PutMapping("/{id}")
	public Pista update(@PathVariable Integer id, @Valid @RequestBody PadelFloorDto padelfloordto) {
		return floorservice.update(id, padelfloordto);
	}
	
	@DeleteMapping("/{id}")
	public Pista delete(@PathVariable Integer id) {
		return floorservice.delete(id);
	}

}
