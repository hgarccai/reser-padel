package com.reserpadel.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "persona") //Solo sirve para la creación de la tabla y no tiene ningún funcionamiento en tiempo de ejecución
public class Persona {

	@Id
	@NotEmpty(message = "{field.notnull}")
	@Email(message = "{email.notempty}") 
	private String email;
	
	@NotEmpty(message = "{field.notnull}")
	private String nombre;
	
	@Min(message = "{padel.minlevel}", value = 1)
	@Max(message = "{padel.maxlevel}", value = 5)
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
