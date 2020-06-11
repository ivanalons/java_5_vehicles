package com.vehicles.exceptions;

//Excepció llansada quan s'afegeix un numero de rodes (frontals o posteriors) diferent de 2 
public class WheelDiameterException extends Exception {

	private String message = "Error al crear una roda: "
							+ "Un diametre de la roda ha de ser superior a 0.4 i inferior a 4.";
	
	public String getMessage() {
		return this.message;
	}
	
}
