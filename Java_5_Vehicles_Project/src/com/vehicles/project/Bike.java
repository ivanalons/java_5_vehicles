package com.vehicles.project;

import com.vehicles.exceptions.VehiclePlateException;
import com.vehicles.exceptions.WheelNotEqualsException;
import com.vehicles.exceptions.WheelNumberException;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) throws VehiclePlateException{
		super(plate, brand, color);
	}

	//Afegeix les rodes a la llista wheels de la superclasse Vehicle per ordre:
	//primer la roda frontal i despres la roda posterior
	public void addWheels(Wheel frontWheel, Wheel backWheel) throws WheelNumberException, WheelNotEqualsException{
		
		this.wheels.add(frontWheel);
		this.wheels.add(backWheel);
	}
	
	// retorna un String amb l'estat dels atributs de la superclasse
	public String toString() {
		return "{MOTO} : " + super.toString();
	}
	
	// mostra todes les dades de l'objecte "Bike" per pantalla
	public void print() {

		System.out.println("----");
		System.out.println("MOTO");
		System.out.println("----");

		super.print();

		String[] labelWheels = { "roda frontal", "roda darrera" };
		int i = 0;
		for (Wheel w : this.wheels) {
			System.out.print(labelWheels[i] + " : ");
			System.out.print(" brand: " + w.getBrand());
			System.out.println(" / diameter: " + w.getDiameter());
			i++;
		}

	}
}
