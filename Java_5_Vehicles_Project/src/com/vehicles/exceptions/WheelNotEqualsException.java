package com.vehicles.exceptions;

// Excepci� llansada quan les rodes d'una mateix eix s�n diferents
public class WheelNotEqualsException extends Exception {

	private String message = "Error: Les rodes del mateix eix han de ser iguals";
	
	public String getMessage() {
		return this.message;
	}

}
