package com.vehicles.exceptions;

//Excepció disparada quan la matricula no te el format correcte 
public class VehiclePlateException extends Exception {

	private String message = "Error en el format de la matrícula: una matrícula ha de tenir "
			+ "4 números i dues o tres lletres.";
	
	public String getMessage() {
		return this.message;
	}
	
}
