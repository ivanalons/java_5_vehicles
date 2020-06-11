package com.vehicles.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.vehicles.exceptions.CarPlateException;
import com.vehicles.exceptions.WheelDiameterException;
import com.vehicles.exceptions.WheelNotEqualsException;
import com.vehicles.exceptions.WheelNumberException;
import com.vehicles.project.Car;
import com.vehicles.project.Wheel;

public class Console {

	Scanner input;
	
	public Console(){
		input = new Scanner(System.in);
	}
	
	public void close() {
		this.input.close();
	}
	
	// Es crea un nou cotxe a partir de les dades introduïdes per consola
	public Car inputCreateCar() {
		
		System.out.println("-------------------------------");
		System.out.println("Introdueix els dades del cotxe:");
		System.out.println("-------------------------------");

		String plate = this.askString("Introdueix la matrícula:");
		String brand = this.askString("Introdueix la marca:");
		String color = this.askString("Introdueix el color:");
		
		Car car = null;
		boolean plateFormat = false;
		
		while(plateFormat==false) {
			
			try {
				car = new Car(plate,brand,color);
				plateFormat=true;
				
			}catch(CarPlateException e) {

				System.out.println(e.getMessage());
				plate = this.askString("Introdueix la matrícula amb un format correcte:");

			}
			
		}	
			
		return car;
		
	}
	
	// S'afegeixen dos rodes frontals i dos rodes posteriors al cotxe referenciat per paràmetre
	// a partir de les dades introduïdes per consola
	public void inputAddWheels( Car car ) {
		
		System.out.println("----------------------------------");
		System.out.println("Introdueix les dades de les rodes:");
		System.out.println("----------------------------------");
		
		String labelFrontWheels = "rodes frontals";
		String labelBackWheels = "rodes posteriors" ;
		
		List<Wheel> frontWheels = new ArrayList<>();
		List<Wheel> backWheels = new ArrayList<>();
		
		//actualitza la llista "backWheels" afegint les rodes posteriors i els seus atributs introduïts per consola
		inputAddWheelsList(labelBackWheels, backWheels); 
		
		//actualitza la llista "frontWheels" afegint les rodes posteriors i els seus atributs introduïts per consola
		inputAddWheelsList(labelFrontWheels, frontWheels);
		
		try {
			
			//Afegeix les rodes frontals i posteriors al cotxe referenciat per paràmetre
			car.addWheels(frontWheels, backWheels);
			
		}catch(WheelNumberException e) {
			System.out.println(e.getMessage());
			
		}catch(WheelNotEqualsException e2) {
			System.out.println(e2.getMessage());
		}
	}
	
	// Afegeix dos rodes a la llista "wheelsList" referenciada per paràmetre 
	// amb la mateixa marca i diàmetre introduïts per consola
	public void inputAddWheelsList(String label, List<Wheel> wheelsList) {
		
		System.out.println( label.toUpperCase() );

		String brand = this.askString("Introdueix la marca:");
		double diameter = this.askDouble("Introdueix el diàmetre:");
		
		Wheel wheelLeft = null;
		Wheel wheelRight = null;
		boolean correctDiameter = false;
		
		while (correctDiameter==false) {
			try {
				wheelLeft = new Wheel(brand,diameter);
				wheelRight = new Wheel(brand,diameter);
				correctDiameter = true;
				
			}catch(WheelDiameterException e) {
				System.out.println(e.getMessage());
				diameter = this.askDouble("Introdueix el diàmetre dins del rang vàlid:");
			}
		}
			
		wheelsList.add(wheelLeft);
		wheelsList.add(wheelRight);

	}
	
	// Demana un número (amb decimals o no) per consola mostrant previament el missatge passat per paràmetre
	// Si s'hi introdueix un número amb format no vàlid, es torna a demanar que l'usuari introdueixi un altre
	// cop el número
	// Retorna el valor introduït per l'usuari
	public double askDouble(String questionMessage) {
		
		double answer = 0.0;	
		boolean numberFormat = false;
		
		System.out.println(questionMessage);
		
		do {
		
			try {	
			   answer = this.input.nextDouble();
			   numberFormat = true;			   
			}catch (InputMismatchException e) {				
			   System.out.println("Tipus numèric invàlid! Torna a introduir el número:");
			   numberFormat = false;
			}		
			this.input.nextLine();
			
		} while (numberFormat==false);
		
		return answer;
	}
	
	// Demana un String per consola mostrant previament el missatge passat per paràmetre
	// Retorna el valor introduït per l'usuari
	public String askString(String questionMessage) {
				
		System.out.println(questionMessage);
		String answer = this.input.nextLine();
		
		return answer;
	}

}
