package com.reserpadel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reserpadel.domain.Pista;
/*
 * Se crea una interfaz, que hereda de JpaRepository, para aprovechar los métodos CRUD
 * que ya tiene, y para permitir que spring cree el bean al inicio 
 */
public interface PadelFloorRepository extends JpaRepository<Pista, Integer> {

}
