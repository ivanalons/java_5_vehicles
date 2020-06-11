package com.vehicles.exceptions;

//Excepci� disparada quan la matricula no te el format correcte 
public class CarPlateException extends Exception {

	private String message = "Error en el format de la matr�cula: una matr�cula ha de tenir "
			+ "4 n�meros i dues o tres lletres.";
	
	public String getMessage() {
		return this.message;
	}
	
}
