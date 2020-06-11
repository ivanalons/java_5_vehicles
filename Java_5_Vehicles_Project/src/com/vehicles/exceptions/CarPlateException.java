package com.vehicles.exceptions;

//Excepció llansada quan s'afegeix un numero de rodes (frontals o posteriors) diferent de 2 
public class CarPlateException extends Exception {

	private String message = "Error en el format de la matrícula: una matrícula ha de tenir "
			+ "4 números i dues o tres lletres.";
	
	public String getMessage() {
		return this.message;
	}
	
}
