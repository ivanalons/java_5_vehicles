package com.vehicles.exceptions;

//Excepci� llansada quan s'afegeix un numero de rodes (frontals o posteriors) diferent de 2 
public class CarPlateException extends Exception {

	private String message = "Error en el format de la matr�cula: una matr�cula ha de tenir "
			+ "4 n�meros i dues o tres lletres.";
	
	public String getMessage() {
		return this.message;
	}
	
}
