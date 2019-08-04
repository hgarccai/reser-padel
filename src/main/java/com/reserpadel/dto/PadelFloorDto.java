package com.reserpadel.dto;

import java.time.LocalTime;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class PadelFloorDto {
	
	@NotEmpty(message = "Nombre no puede ir vacio.")
	@NotNull(message = "Debe ir informado.")
	private String nombre;
	
	@NotEmpty(message = "La pista debe tener una hora de apertura.")
	@NotNull(message = "Hora de apertura debe ir informada.")
	private LocalTime apertura;
	
	@NotEmpty(message = "La pista debe tener una hora de cierre.")
	@NotNull(message = "Hora de cierre debe ir informada.")
	@DateTimeFormat(pattern = "hh:mm")
	private LocalTime cierre;
	
	@NotEmpty(message = "La pista no puede ser gratis.")
	@DecimalMin(message = "El minimo valor de la pista es de ", value = "1.00")
	@DecimalMin(message = "La pista no puede valer mas de ", value = "10.00")
	private Double precio;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalTime getApertura() {
		return apertura;
	}
	public void setApertura(LocalTime apertura) {
		this.apertura = apertura;
	}
	public LocalTime getCierre() {
		return cierre;
	}
	public void setCierre(LocalTime cierre) {
		this.cierre = cierre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	

}
