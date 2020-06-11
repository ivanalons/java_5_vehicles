package com.vehicles.exceptions;

//Excepció disparada quan el diametre de la roda no esta dins del rang correcte
public class WheelDiameterException extends Exception {

	private String message = "Error al crear una roda: "
							+ "Un diametre de la roda ha de ser superior a 0.4 i inferior a 4.";
	
	public String getMessage() {
		return this.message;
	}
	
}
