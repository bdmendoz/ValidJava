package com.valid.techtest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.valid.techtest.model.Persona;
import com.valid.techtest.repository.PersonaRepository;

/**
 * Definicion de servicios para persona
 * @author boane
 *
 */
@Service
public class PersonaService {
	private final PersonaRepository personaRepository;
	
	public PersonaService(PersonaRepository personaRepository) {
		// TODO Auto-generated constructor stub
		this.personaRepository=personaRepository;
	}
	/**
	 * 
	 * @param persona
	 * @return
	 */
	public Persona create(Persona persona) {
		return this.personaRepository.save(persona);
	}
	
	public Persona update(Persona persona) {
		return this.personaRepository.save(persona);
	}
	public void delete(Persona persona) {
		this.personaRepository.delete(persona);
	}
	public Persona findById(int id) {
		return this.personaRepository.findById(id);
	}
	public List<Persona> findAll(){
		return this.personaRepository.findAll();
	}
}
