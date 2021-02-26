package com.valid.techtest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.valid.techtest.resources.VO.PersonaVO;

/**
 * Clase que representa a la tabla Persona
 * @author boane
 *
 */
@Entity
@Table(name = "persona")
@NamedQuery(name = "Persona.findByApellido", 
query="Select p from Persona p where p.apellido = ?1")
public class Persona {
	@Id
	@GeneratedValue
	private int idPersona;
	private String nombre;
	private String apellido;
	private boolean estado;
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}
	public Persona(PersonaVO personaVO) {
		this.nombre=personaVO.getNombre();
		this.apellido= personaVO.getApellido();
		this.estado= personaVO.getEstado();		
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellidoCliente) {
		this.apellido = apellidoCliente;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
