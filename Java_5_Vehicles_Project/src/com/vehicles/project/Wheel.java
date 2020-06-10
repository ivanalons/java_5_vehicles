package com.vehicles.project;

public class Wheel {
	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter) {
		this.brand = brand;
		this.diameter = diameter;
	}

	public String getBrand() {
		return brand;
	}

	public double getDiameter() {
		return diameter;
	}
	
	public boolean equals(Wheel wheel) { //IAG sobreescriu el mètode equals per a comparar dos rodes
		
		boolean yes = this.brand.equals(wheel.brand) && this.diameter==wheel.diameter;
		
		return ( yes );
	}
	
}
