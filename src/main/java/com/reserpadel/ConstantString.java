package com.reserpadel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration // marca la clase como origen y definición de beans
@EnableConfigurationProperties // habilita @ConfigurationProperties
@ConfigurationProperties //vincula y valida la clase de configuracion
public class ConstantString {


	@Value("${exceptions.email}")
	private String emailerror;

	@Value("${exceptions.user.notfound}")
	private String personnotfound;

	@Value("${exceptions.user.exist}")
	private String userexist;
	
	public String getEmailerror() {
		return emailerror;
	}

	public String getPersonnotfound() {
		return personnotfound;
	}

	public String getUserexist() {
		return userexist;
	}
	
	// Errores definidos en messages.properties
	@Value("${exceptions.floor.duplicate}")
	private String duplicatefloor;
	
	@Value("${exceptions.floor.noexist}")
	private String floornoexists;
	
	@Value("${exceptions.floor.nofill}")
	private String floornofill;

	public String getDuplicatefloor() {
		return duplicatefloor;
	}

	public String getFloornoexists() {
		return floornoexists;
	}

	public String getFloornofill() {
		return floornofill;
	}
}
