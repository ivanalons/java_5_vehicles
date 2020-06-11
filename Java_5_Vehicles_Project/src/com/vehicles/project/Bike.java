package com.vehicles.project;

import com.vehicles.exceptions.VehiclePlateException;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) throws VehiclePlateException{
		super(plate, brand, color);
	}

	public String toString() {
		return "{MOTO} : " + super.toString();
	}
	
}
