package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

import com.vehicles.exceptions.VehiclePlateException;

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

	public String toString() {
		return "matricula: ["+plate+"], marca: ["+brand+"], color: ["+color+"]";
	}
	
	public void print() {
		System.out.println("plate: "+this.plate);
		System.out.println("brand: "+this.brand);
		System.out.println("color: "+this.color);
	}
	
}
