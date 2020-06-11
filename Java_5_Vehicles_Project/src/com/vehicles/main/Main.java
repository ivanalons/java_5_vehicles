package com.vehicles.main;

import com.vehicles.project.Car;

import com.vehicles.ui.Console;

public class Main {

	public static void main(String[] args) {

		Console console = new Console(); //Encapsula la gestió de entrada de dades per consola
		
		//Es crea un objecte Car a partir de les dades introduïdes per consola
		Car car = console.inputCreateCar(); 		
		
		//S'afegeixen les rodes frontals i posteriors a l'objecte "car" a partir de les dades introduïdes per consola
		console.inputAddWheels(car); 
		
		//Es mostra per consola els valors de tots els atributs de l'objecte "car"
		car.print();
		
		console.close();
	}

}
