package com.reserpadel.domain;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persona") //Solo sirve para la creación de la tabla y no tiene ningún funcionamiento en tiempo de ejecución
public class Persona {

	@Id
	private String email;
	
	private String nombre;
	private Integer nivelPadel;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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
