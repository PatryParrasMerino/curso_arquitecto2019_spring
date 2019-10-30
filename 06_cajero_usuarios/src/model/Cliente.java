package model;

import java.io.Serializable;


/**
 * The persistent class for the clientes database table.
 * 
 */

public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int dni;

	private String direccion;

	private String nombre;

	private int telefono;

	

	public Cliente(int dni, String direccion, String nombre, int telefono) {
		super();
		this.dni = dni;
		this.direccion = direccion;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public Cliente() {
	}

	public int getDni() {
		return this.dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	

}