package com.vehicles.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.vehicles.exceptions.VehiclePlateException;
import com.vehicles.exceptions.WheelDiameterException;
import com.vehicles.exceptions.WheelNotEqualsException;
import com.vehicles.exceptions.WheelNumberException;
import com.vehicles.project.Bike;
import com.vehicles.project.Car;
import com.vehicles.project.Vehicle;
import com.vehicles.project.Wheel;

public class Console {

	Scanner input;
	
	final int CONST_CAR = 1; //Indica que s'ha de crear un cotxe quan l'usuari selecciona vehicle
	final int CONST_BIKE = 2; //Indica que s'ha de crear una moto quan l'usuari selecciona vehicle
	
	public Console(){
		input = new Scanner(System.in);
	}
	
	public void close() {
		this.input.close();
	}
	
	// Es crea un nou vehicle a partir de les dades introduïdes per consola
	// Es retorna l'objecte vehicle (cotxe o moto)
	public Vehicle inputCreateVehicle() {
		
		// Es demana escollir a l'usuari entre crear una moto(2) o un cotxe(1)
		int tipusVehicle = this.askVehicleType();
		
		System.out.println("---------------------------------");
		System.out.println("Introdueix els dades del vehicle:");
		System.out.println("---------------------------------");

		String plate = this.askString("Introdueix la matrícula:");
		String brand = this.askString("Introdueix la marca:");
		String color = this.askString("Introdueix el color:");
		
		//Retorna un nou objecte vehicle amb els atributs "plate","brand" i "color"
		Vehicle vehicle = createVehicle(tipusVehicle,plate,brand,color);
				
		return vehicle;
		
	}
	
	//Retorna el tipus de vehicle que l'usuari vol crear (1:cotxe / 2:moto)
	private int askVehicleType() {
		
		int tipusVehicle = 0;
		
		tipusVehicle = this.askInt("Que vols crear un cotxe o una moto ? (1:cotxe / 2:moto)");
		
		while(tipusVehicle!=CONST_CAR && tipusVehicle!=CONST_BIKE) {
			tipusVehicle = this.askInt("Has d'introduir un '1' per seleccionar cotxe"+
									   " o '2' per seleccionar una moto");
		}
		
		return tipusVehicle;
	}
	
	//Crea i retorna un vehicle de tipus cotxe o moto segons el parametre "tipusVehicle"
	//També es comprova que la matricula "plate" tingui un format correcte
	private Vehicle createVehicle(int tipusVehicle, String plate, String brand, String color) {
		
		Vehicle vehicle = null;
		boolean plateFormat = false;
		
		// mentre el format de la matricula no sigui valid, demanar per consola a
		// l'usuari que introdueixi la matricula de nou
		while (plateFormat == false) {

			try {
				if (tipusVehicle == CONST_CAR) { // S'ha de crear un cotxe
					vehicle = new Car(plate, brand, color);
				} else { // tipusVehicle == CONST_BIKE ==>  S'ha de crear una moto
					vehicle = new Bike(plate, brand, color);
				}
				plateFormat = true;

			} catch (VehiclePlateException e) {

				System.out.println(e.getMessage());
				plate = this.askString("Introdueix la matrícula amb un format correcte:");

			}

		}
		return vehicle;
	}
	
	// Si el vehicle es un cotxe:
	// S'afegeixen dos rodes frontals identiques amb l'estat de la roda "frontWheel" 
	// i dos rodes posteriors identiques amb l'estat de la roda "backWheel"
	//
	// Si el vehicle es una moto:
	// S'afegeix com a roda frontal, la roda "frontWheel", i com a roda posterior, la roda "backWheel"
	public void inputAddWheels( Vehicle vehicle ) {
		
		System.out.println("----------------------------------");
		System.out.println("Introdueix les dades de les rodes:");
		System.out.println("----------------------------------");
		
		String labelFrontWheels = "rodes frontals";
		if(vehicle instanceof Bike)  labelFrontWheels = "roda frontal";
		String labelBackWheels = "rodes posteriors" ;
		if(vehicle instanceof Bike)  labelBackWheels = "roda posterior";
	
		//S'obté per consola una instancia Wheel com a model de la roda frontal
		Wheel frontWheel = inputCreateWheel(labelFrontWheels); 
		
		//S'obté per consola una instancia Wheel com a model de la roda posterior
		Wheel backWheel = inputCreateWheel(labelBackWheels);
		
		try {
			
			//Afegeix les rodes frontals i posteriors al "vehicle" referenciat per paràmetre
			vehicle.addWheels(frontWheel, backWheel);
			
		}catch(WheelNumberException e) {
			System.out.println(e.getMessage());
			
		}catch(WheelNotEqualsException e2) {
			System.out.println(e2.getMessage());
		}
	}
	
	// Es demana per consola introduir les dades d'una roda per a poder crear-la.
	// El diametre ha de estar dins del rang valid.
	public Wheel inputCreateWheel(String label) {
		
		System.out.println( label.toUpperCase() );

		String brand = this.askString("Introdueix la marca:");
		double diameter = this.askDouble("Introdueix el diàmetre:");
		
		Wheel wheel = null;
		boolean correctDiameter = false;
		
		//mentre el diametre de la roda no sigui valid, demanar per consola a l'usuari
		//que introdueixi el diametre de nou
		while (correctDiameter==false) {
			try {
				wheel = new Wheel(brand,diameter);
				correctDiameter = true;
				
			}catch(WheelDiameterException e) {
				System.out.println(e.getMessage());
				diameter = this.askDouble("Introdueix el diàmetre dins del rang vàlid:");
			}
		}
			
		return wheel;

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

	// Demana un número enter per consola mostrant previament el missatge passat per paràmetre
	// Si s'hi introdueix un número amb format no vàlid, es torna a demanar que l'usuari introdueixi un altre
	// cop el número
	// Retorna el valor introduït per l'usuari
	public int askInt(String questionMessage) {
		
		int answer = 0;	
		boolean numberFormat = false;
		
		System.out.println(questionMessage);
		
		do {
		
			try {	
			   answer = this.input.nextInt();
			   numberFormat = true;			   
			}catch (InputMismatchException e) {				
			   System.out.println("Tipus numèric invàlid! Torna a introduir el número:");
			   numberFormat = false;
			}		
			this.input.nextLine();
			
		} while (numberFormat==false);
		
		return answer;
	}
	
}
