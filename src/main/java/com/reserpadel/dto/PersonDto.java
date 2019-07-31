package com.reserpadel.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class PersonDto{
	
	@NotEmpty(message = "{field.notnull}")
	private String nombre;
	
	@Min(message = "{padel.minlevel}", value = 1)
	@Max(message = "{padel.maxlevel}", value = 5)
	private Integer nivelPadel;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getNivelPadel() {
		return nivelPadel;
	}
	public void setNivelPadel(Integer nivelPadel) {
		this.nivelPadel = nivelPadel;
	}
}
