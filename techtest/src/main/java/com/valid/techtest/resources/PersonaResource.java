/**
 * 
 */
package com.valid.techtest.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.valid.techtest.model.Persona;
import com.valid.techtest.resources.VO.PersonaVO;
import com.valid.techtest.services.PersonaService;

/**
 * Servicio web de persona: incluye las operaciones de create , read y update
 * @author boane
 *
 */
@RestController
@RequestMapping("/api/persona")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT})
public class PersonaResource {
	private final PersonaService personaService;
	
	public PersonaResource(PersonaService personaService) {
		// TODO Auto-generated constructor stub
		this.personaService= personaService;
		
	}
	
	@PostMapping
	public ResponseEntity<Persona> createPersona(@RequestBody PersonaVO personaVO){
		Persona persona= new Persona(personaVO);
		return new ResponseEntity<>(this.personaService.create(persona), HttpStatus.CREATED);
	}
	
	@PutMapping("/estado/{id}")
	public ResponseEntity<Persona> updatePersonaEstado(@PathVariable("id") int id, @RequestBody PersonaVO personaVO){
		Persona persona= this.personaService.findById(id);
		if(persona == null) {
			return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
		}else {
			persona.setEstado(personaVO.getEstado());
			return new ResponseEntity<>(this.personaService.update(persona), HttpStatus.OK);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Persona>>findAll(){
		return ResponseEntity.ok(this.personaService.findAll());
	}
}
