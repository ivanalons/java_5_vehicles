package com.vehicles.main;

import com.vehicles.project.Vehicle;
import com.vehicles.ui.Console;

public class Main {

	public static void main(String[] args) {

		Console console = new Console(); //Encapsula la gestió de entrada de dades per consola
		
		//Es crea un objecte Vehicle a partir de les dades introduïdes per consola
		Vehicle vehicle = console.inputCreateVehicle(); 		
		
		//S'afegeixen les rodes frontals i posteriors a l'objecte "car" a partir de les dades introduïdes per consola
		//console.inputAddWheels(car); 
		
		//Es mostra per consola els valors de tots els atributs de l'objecte "car"
		//car.print();
		
		System.out.println(vehicle.toString());
		
		console.close();
	}

}
