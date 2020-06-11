package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

import com.vehicles.exceptions.VehiclePlateException;
import com.vehicles.exceptions.WheelNotEqualsException;
import com.vehicles.exceptions.WheelNumberException;

public abstract class Vehicle {

	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();

	public Vehicle(String plate, String brand, String color) throws VehiclePlateException{
		this.plate = plate;
		this.brand = brand;
		this.color = color;
		if (this.checkPlate()==false) throw new VehiclePlateException();

	}
	
	// Comprova si la matrícula te 4 números i dues o tres lletres
	// Si es compleix retorna true, en cas contrari retorna false
	protected boolean checkPlate() {

		int numCharacters = 0, numNumbers = 0;
		boolean b1 = false, b2 = false, res = false;

		// Bucle for: Es fa un recorregut dels caracters de l'atribut plate (matricula)
		// i s'incrementa la variable "numCharacter" cada cop que el caracter es una
		// lletra i s'incrementa la variable "numNumbers" cada cop que el caracter es un numero
		for (int i = 0; i < plate.length(); i++) {

			char c = this.plate.charAt(i);

			b1 = "abcdefghijklmnñopqrstuvwxyz".contains(String.valueOf(c).toLowerCase());
			b2 = "0123456789".contains(String.valueOf(c));

			if (b1 == true) {
				numCharacters++;
			} else if (b2 == true) {
				numNumbers++;
			}
		}

		if (numNumbers == 4 && (numCharacters == 2 || numCharacters == 3)) {
			res = true; // Format de matricula correcte
		} else {
			res = false;
		}

		return res;
	}

	// Afegeix un parell de rodes al vehicle. Codi original. Pot ser reutilitzable en un futur per
	// noves subclasses de Vehicle, com per exemple, una classe camió 
	public void addTwoWheels(List<Wheel> wheels) throws WheelNumberException, WheelNotEqualsException {
		
		if (wheels.size() != 2) throw new WheelNumberException();

		Wheel wheel1 = wheels.get(0);
		Wheel wheel2 = wheels.get(1);

		if (!wheel1.equals(wheel2)) throw new WheelNotEqualsException();

		this.wheels.add(wheel1);
		this.wheels.add(wheel2);
		
	}
	
	public String toString() {
		return "matricula: ["+plate+"], marca: ["+brand+"], color: ["+color+"]";
	}
	
	public void print() {
		System.out.println("plate: "+this.plate);
		System.out.println("brand: "+this.brand);
		System.out.println("color: "+this.color);
	}
	
	//Afegeix les rodes del vehicle
	//Actualment es un metode diferent a cada subclasse: un cotxe afegeix 2 rodes posteriors i 2 rodes
	//frontals mentre que una moto afegeix 1 roda posterior i 1 roda frontal
	public abstract void addWheels(Wheel frontWheels, Wheel backWheels) throws WheelNumberException, WheelNotEqualsException;
}
