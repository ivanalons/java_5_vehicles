package com.vehicles.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.vehicles.exceptions.CarPlateException;
import com.vehicles.exceptions.WheelDiameterException;
import com.vehicles.exceptions.WheelNotEqualsException;
import com.vehicles.exceptions.WheelNumberException;
import com.vehicles.project.Bike;
import com.vehicles.project.Car;
import com.vehicles.project.Vehicle;
import com.vehicles.project.Wheel;

public class Console {

	Scanner input;
	
	public Console(){
		input = new Scanner(System.in);
	}
	
	public void close() {
		this.input.close();
	}
	
	// Es crea un nou cotxe a partir de les dades introdu�des per consola
	public Vehicle inputCreateVehicle() {
		
		int tipusVehicle = this.askInt("Que vols crear un cotxe o una moto ? (1:cotxe / 2:moto)");
		
		//Falta controlar que s'introdueixi 1 o 2 per consola
		
		System.out.println("---------------------------------");
		System.out.println("Introdueix els dades del vehicle:");
		System.out.println("---------------------------------");

		String plate = this.askString("Introdueix la matr�cula:");
		String brand = this.askString("Introdueix la marca:");
		String color = this.askString("Introdueix el color:");
		
		Vehicle vehicle = null;
		boolean plateFormat = false;
		
		//mentre el format de la matricula no sigui valid, demanar per consola a l'usuari
		//que introdueixi la matricula de nou
		while(plateFormat==false) { 
			
			try {
				if(tipusVehicle==1) {
					vehicle = new Car(plate,brand,color);
				}else {
					vehicle = new Bike(plate,brand,color);
				}
				plateFormat=true;
				
			}catch(CarPlateException e) {

				System.out.println(e.getMessage());
				plate = this.askString("Introdueix la matr�cula amb un format correcte:");

			}
			
		}	
			
		return vehicle;
		
	}
	
	// S'afegeixen dos rodes frontals i dos rodes posteriors al cotxe referenciat per par�metre
	// a partir de les dades introdu�des per consola
	public void inputAddWheels( Car car ) {
		
		System.out.println("----------------------------------");
		System.out.println("Introdueix les dades de les rodes:");
		System.out.println("----------------------------------");
		
		String labelFrontWheels = "rodes frontals";
		String labelBackWheels = "rodes posteriors" ;
		
		List<Wheel> frontWheels = new ArrayList<>();
		List<Wheel> backWheels = new ArrayList<>();
		
		//actualitza la llista "backWheels" afegint les rodes posteriors i els seus atributs introdu�ts per consola
		inputAddWheelsList(labelBackWheels, backWheels); 
		
		//actualitza la llista "frontWheels" afegint les rodes posteriors i els seus atributs introdu�ts per consola
		inputAddWheelsList(labelFrontWheels, frontWheels);
		
		try {
			
			//Afegeix les rodes frontals i posteriors al cotxe referenciat per par�metre
			car.addWheels(frontWheels, backWheels);
			
		}catch(WheelNumberException e) {
			System.out.println(e.getMessage());
			
		}catch(WheelNotEqualsException e2) {
			System.out.println(e2.getMessage());
		}
	}
	
	// Afegeix dos rodes a la llista "wheelsList" referenciada per par�metre 
	// amb la mateixa marca i di�metre introdu�ts per consola
	public void inputAddWheelsList(String label, List<Wheel> wheelsList) {
		
		System.out.println( label.toUpperCase() );

		String brand = this.askString("Introdueix la marca:");
		double diameter = this.askDouble("Introdueix el di�metre:");
		
		Wheel wheelLeft = null;
		Wheel wheelRight = null;
		boolean correctDiameter = false;
		
		//mentre el diametre de la roda no sigui valid, demanar per consola a l'usuari
		//que introdueixi el diametre de nou
		while (correctDiameter==false) {
			try {
				wheelLeft = new Wheel(brand,diameter);
				wheelRight = new Wheel(brand,diameter);
				correctDiameter = true;
				
			}catch(WheelDiameterException e) {
				System.out.println(e.getMessage());
				diameter = this.askDouble("Introdueix el di�metre dins del rang v�lid:");
			}
		}
			
		wheelsList.add(wheelLeft);
		wheelsList.add(wheelRight);

	}
	
	// Demana un n�mero (amb decimals o no) per consola mostrant previament el missatge passat per par�metre
	// Si s'hi introdueix un n�mero amb format no v�lid, es torna a demanar que l'usuari introdueixi un altre
	// cop el n�mero
	// Retorna el valor introdu�t per l'usuari
	public double askDouble(String questionMessage) {
		
		double answer = 0.0;	
		boolean numberFormat = false;
		
		System.out.println(questionMessage);
		
		do {
		
			try {	
			   answer = this.input.nextDouble();
			   numberFormat = true;			   
			}catch (InputMismatchException e) {				
			   System.out.println("Tipus num�ric inv�lid! Torna a introduir el n�mero:");
			   numberFormat = false;
			}		
			this.input.nextLine();
			
		} while (numberFormat==false);
		
		return answer;
	}
	
	// Demana un String per consola mostrant previament el missatge passat per par�metre
	// Retorna el valor introdu�t per l'usuari
	public String askString(String questionMessage) {
				
		System.out.println(questionMessage);
		String answer = this.input.nextLine();
		
		return answer;
	}

	// Demana un n�mero enter per consola mostrant previament el missatge passat per par�metre
	// Si s'hi introdueix un n�mero amb format no v�lid, es torna a demanar que l'usuari introdueixi un altre
	// cop el n�mero
	// Retorna el valor introdu�t per l'usuari
	public int askInt(String questionMessage) {
		
		int answer = 0;	
		boolean numberFormat = false;
		
		System.out.println(questionMessage);
		
		do {
		
			try {	
			   answer = this.input.nextInt();
			   numberFormat = true;			   
			}catch (InputMismatchException e) {				
			   System.out.println("Tipus num�ric inv�lid! Torna a introduir el n�mero:");
			   numberFormat = false;
			}		
			this.input.nextLine();
			
		} while (numberFormat==false);
		
		return answer;
	}
	
}
