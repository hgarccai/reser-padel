
package com.reserpadel.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.reserpadel.ConstantString;
import com.reserpadel.domain.Pista;
import com.reserpadel.dto.PadelFloorDto;
import com.reserpadel.repositories.PadelFloorRepository;

@Service
public class FloorServiceImpl implements FloorService {
	
	final static Logger logger = Logger.getLogger(PersonServiceImpl.class);

	private PadelFloorRepository floorrepository;
	private ConstantString constants;

	public FloorServiceImpl(PadelFloorRepository p, ConstantString m) {
		this.floorrepository = p;
		this.constants = m;
	}

	@Override
	public Pista create(Pista p) {
		// Lambda Consumer (con este parámetro -> hazme esto, o recibe parámetros,
		// haz algo y no devuelvas nada)
		floorrepository.findById(p.getId()).ifPresent(a -> {
			throw new RuntimeException("La pista " + a.getId().toString() + constants.getDuplicatefloor());
		});
		
		return floorrepository.save(p);
	}

	@Override
	public List<Pista> findAll() {
		return floorrepository.findAll();
	}

	@Override
	public Pista findById(Integer floorid) {

		if (!floorid.equals(null)) {
			// Lambda Supplier (con ningún paramétro -> haz esto, o no recibe parámetros y
			// haz algo)
			return floorrepository.findById(floorid).orElseThrow(() -> new RuntimeException("La pista " + floorid.toString() + constants.getFloornoexists()));
		} else {
			throw new RuntimeException(constants.getFloornofill());
		}
	}

	@Override
	public Pista update(Integer floorid, PadelFloorDto persondto) {
		
		Pista p = findById(floorid);
		BeanUtils.copyProperties(persondto, p, "id");
		
		return floorrepository.save(p);
	}

	@Override
	public Pista delete(Integer floorid) {
		Pista p = findById(floorid);
		floorrepository.deleteById(floorid);
		return p;
	}
}
