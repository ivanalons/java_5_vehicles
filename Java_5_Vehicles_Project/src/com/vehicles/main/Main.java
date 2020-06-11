package com.vehicles.main;

import com.vehicles.project.Vehicle;
import com.vehicles.ui.Console;

public class Main {

	public static void main(String[] args) {

		Console console = new Console(); //Encapsula la gestió de entrada de dades per consola
		
		// Es crea un objecte de tipus Vehicle a partir de les dades introduïdes per consola
		Vehicle vehicle = console.inputCreateVehicle(); 		
		
		// S'afegeixen les rodes a l'objecte vehicle partir de les dades introduïdes per consola
		console.inputAddWheels(vehicle); 
		
		// Es mostra per consola el tipus subclasse de l'objecte vehicle i tots els valors dels 
		// seus atributs
		vehicle.print();
		
		//System.out.println(vehicle.toString());
		
		console.close();
	}

}
