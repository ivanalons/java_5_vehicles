package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

import com.vehicles.exceptions.VehiclePlateException;
import com.vehicles.exceptions.WheelNotEqualsException;
import com.vehicles.exceptions.WheelNumberException;

public class Car extends Vehicle {

	public Car(String plate, String brand, String color) throws VehiclePlateException{
		super(plate, brand, color);

	}
	//Afegeix les rodes a la llista wheels de la superclasse Vehicle per ordre:
	//1 roda_frontal_esquerra, 2 roda_frontal_dreta, 3 roda_posterior_esquerra, 4 roda_posterior_dreta
	public void addWheels(Wheel frontWheel, Wheel backWheel) throws WheelNumberException, WheelNotEqualsException {
		
		this.addPairOfWheels(frontWheel);  //S'afegeixen les dues rodes frontals
		this.addPairOfWheels(backWheel);   //S'afegeixen les dues rodes posteriors
	}
    
	//a partir d'un objecte Wheel, es crea una copia i s'afegeixen les dues rodes a la llista wheel
	//de la superclasse
	public void addPairOfWheels(Wheel wheel) throws WheelNumberException, WheelNotEqualsException{
		List<Wheel> list = new ArrayList<>();
		Wheel leftWheel = wheel;
		Wheel rightWheel = new Wheel(wheel);
		list.add(leftWheel);
		list.add(rightWheel);
		
		this.addTwoWheels(list);
	}
	
	// mostra todes les dades de l'objecte "Car" per pantalla
	public void print() {
		
		System.out.println("-----");
		System.out.println("COTXE");
		System.out.println("-----");
		
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
	
	// retorna un String amb l'estat dels atributs de la superclasse
	public String toString() {
		return "{COTXE} : " + super.toString();
	}
	
}
