package com.vehicles.project;

import com.vehicles.exceptions.WheelDiameterException;

public class Wheel {
	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter) throws WheelDiameterException{
		this.brand = brand;
		this.diameter = diameter;
		
		//Dispara una excepcio WheelDiameterException si el diametre del constructor es incorrecte
		if (this.checkDiameter()==false) throw new WheelDiameterException();
	}

	public Wheel(Wheel wheel) {
		this.brand=wheel.brand;
		this.diameter=wheel.diameter;
	}
	
	public String getBrand() {
		return brand;
	}

	public double getDiameter() {
		return diameter;
	}
	
	//sobreescriu el mètode equals per a comparar dues rodes
	public boolean equals(Wheel wheel) { 
		
		boolean yes = this.brand.equalsIgnoreCase(wheel.brand) && this.diameter==wheel.diameter;
		
		return ( yes );
	}
	
	//Si el diametre esta dins d'un rang valid superior a 0.4 i inferior a 4 retorna true
	//en cas contrari, retorna false
	private boolean checkDiameter() {
		
		boolean res = false;
		
		if(this.diameter > 0.4 && this.diameter < 4) {
			res = true;
		}else {
			res = false;
		}
		
		return res;
	}
}
