package com.vehicles.project;

import java.util.List;

import com.vehicles.exceptions.CarPlateException;
import com.vehicles.exceptions.WheelNotEqualsException;
import com.vehicles.exceptions.WheelNumberException;

public class Car extends Vehicle {

	public Car(String plate, String brand, String color) throws CarPlateException{
		super(plate, brand, color);
		
		if (this.checkPlate()==false) throw new CarPlateException();
	}

	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws WheelNumberException, WheelNotEqualsException {
		addTwoWheels(frontWheels);
		addTwoWheels(backWheels);
	}

	public void addTwoWheels(List<Wheel> wheels) throws WheelNumberException, WheelNotEqualsException {
				
		if (wheels.size() != 2) throw new WheelNumberException();

		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);

		if (!rightWheel.equals(leftWheel)) throw new WheelNotEqualsException();

		this.wheels.add(leftWheel);
		this.wheels.add(rightWheel);
	}

	
    //Comprova si la matrícula te 4 números i dues o tres lletres
	//Si es compleix retorna true, en cas contrari retorna false
	private boolean checkPlate(){
		
		int numCharacters = 0, numNumbers = 0;
		boolean b1=false, b2=false, res=false;
		
		//Bucle for: Es fa un recorregut dels caracters de l'atribut plate (matricula) i
		//s'incrementa la variable "numCharacter" cada cop que el caracter es una lletra
		//i s'incrementa la variable "numNumbers" cada cop que el caracter es un numero
		for(int i=0;i<plate.length();i++) { 
			
			char c = this.plate.charAt(i);
			
			b1 = "abcdefghijklmnñopqrstuvwxyz".contains(String.valueOf(c).toLowerCase());
			b2 = "0123456789".contains(String.valueOf(c));
			
			if (b1==true) {
				numCharacters++;
			}else if(b2==true) {
				numNumbers++;
			}

		}
		
		if (numNumbers==4 && (numCharacters==2 || numCharacters==3) ) {
			res = true; //Format de matricula correcte
		}else {
			res = false;
		}
		
		return res;
	}
	
	//IAG mostra todes les dades de l'objecte "Car" per pantalla
	public void print() {
		
		System.out.println("CAR");
		System.out.println("---");
		
		System.out.println("plate: "+this.plate);
		System.out.println("brand: "+this.brand);
		System.out.println("color: "+this.color);

		String[] labelWheels = {"roda esquerra frontal", "roda dreta frontal", 
									 "roda esquerra darrera", "roda dreta darrera" };
		int i=0;
		for (Wheel w : this.wheels) {
			System.out.print(labelWheels[i]+" : ");
			System.out.print(" brand: "+ w.getBrand());
			System.out.println(" / diameter: "+ w.getDiameter());
			i++;
		}
		
	}
	
	
}
