package com.reserpadel.services;

import java.util.List;

import com.reserpadel.domain.Pista;
import com.reserpadel.dto.PadelFloorDto;

public interface FloorService {

	Pista create(Pista p);

	List<Pista> findAll();

	Pista findById(Integer floorid);

	Pista update(Integer floorid, PadelFloorDto persondto);

	Pista delete(Integer floorid);

}
