package com.vehicles.exceptions;

// Excepció llansada quan les rodes d'una mateix eix són diferents
public class WheelNotEqualsException extends Exception {

	private String message = "Error: Les rodes del mateix eix han de ser iguals";
	
	public String getMessage() {
		return this.message;
	}

}
