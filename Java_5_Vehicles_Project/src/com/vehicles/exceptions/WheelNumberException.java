package com.vehicles.exceptions;

//Excepció llansada quan s'afegeix un numero de rodes (frontals o posteriors) diferent de 2 
public class WheelNumberException extends Exception {

	private String message = "Error al afegir rodes al cotxe."
							+"S'han de afegir 2 rodes frontals o 2 rodes posteriors";
	
	public String getMessage() {
		return this.message;
	}
	
}
