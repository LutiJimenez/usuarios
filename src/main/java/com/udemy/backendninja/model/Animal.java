package com.udemy.backendninja.model;

public class Animal {

	private String Nombre;

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	} 
	
	public Animal(){}

	@Override
	public String toString() {
		return "Animal [Nombre=" + Nombre + "]";
	}
	
}
