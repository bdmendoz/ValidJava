/**
 * 
 */
package com.valid.techtest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valid.techtest.model.Persona;

/**
 * @author boane
 *
 */
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
	/**
	 * Encuentra personas por su nombre
	 * @param nombre
	 * @return
	 */
	public List<Persona> findByNombre(String nombre); 
	public Persona findByApellido(String apellido);
	
	public Persona findById(int id);
	
	
	
}
