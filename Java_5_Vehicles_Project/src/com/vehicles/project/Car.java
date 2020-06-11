package com.vehicles.project;

import java.util.List;

import com.vehicles.exceptions.VehiclePlateException;
import com.vehicles.exceptions.WheelNotEqualsException;
import com.vehicles.exceptions.WheelNumberException;

public class Car extends Vehicle {

	public Car(String plate, String brand, String color) throws VehiclePlateException{
		super(plate, brand, color);

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

	
    
	
	//IAG mostra todes les dades de l'objecte "Car" per pantalla
	public void print() {
		
		System.out.println("CAR");
		System.out.println("---");
		
		super.print();

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
	
	public String toString() {
		return "{COTXE} : " + super.toString();
	}
	
}
