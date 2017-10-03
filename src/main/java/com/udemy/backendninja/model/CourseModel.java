package com.udemy.backendninja.model;

public class CourseModel {

	// Esta clase tiene los mismos atributos que la entidad (refencia a tabla)
	// pero sin el id,
	// es con la que vamos a trabajar en el componente
	private String name;
	private String description;
	private int hours;
	private int price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "CourseModel [name=" + name + ", description=" + description
				+ ", hours=" + hours + ", price=" + price + "]";
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public CourseModel(String name, String description, int hours, int price) {
		super();
		this.name = name;
		this.description = description;
		this.hours = hours;
		this.price = price;
	}

	public CourseModel() {
	}

}
