package com.reserpadel.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reserva") //Solo sirve para la creación de la tabla y no tiene ningún funcionamiento en tiempo de ejecución
public class Reserva {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToOne //una reserva pertenece a una sola persona
	private Persona persona;
	
	@OneToOne //una reserva, solo puede ser de una sola pista
	private Pista pista;
	
	private LocalDateTime fecha;
	private Boolean pagada;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Pista getPista() {
		return pista;
	}

	public void setPista(Pista pista) {
		this.pista = pista;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Boolean getPagada() {
		return pagada;
	}

	public void setPagada(Boolean pagada) {
		this.pagada = pagada;
	}
}
