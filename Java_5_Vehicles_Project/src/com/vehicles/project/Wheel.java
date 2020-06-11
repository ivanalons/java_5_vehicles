package com.vehicles.project;

import com.vehicles.exceptions.WheelDiameterException;

public class Wheel {
	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter) throws WheelDiameterException{
		this.brand = brand;
		this.diameter = diameter;
		
		if (this.checkDiameter()==false) throw new WheelDiameterException();
	}

	public String getBrand() {
		return brand;
	}

	public double getDiameter() {
		return diameter;
	}
	
	public boolean equals(Wheel wheel) { //IAG sobreescriu el mètode equals per a comparar dos rodes
		
		boolean yes = this.brand.equalsIgnoreCase(wheel.brand) && this.diameter==wheel.diameter;
		
		return ( yes );
	}
	
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
