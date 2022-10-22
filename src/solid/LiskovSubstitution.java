package com.src.solid;

import java.util.ArrayList;
import java.util.List;

class Vehicle{
	public void startEngine() {
		
	}
}

class Car extends Vehicle{
	@Override
	public void startEngine() {
		
	}
}

class Bicycle extends Vehicle{
	@Override
	public void startEngine() {
		
	}
}

public class LiskovSubstitution {
	public void startVehicles() {
		List<Vehicle> v = new ArrayList();
		
		//causes
		v.forEach(veh->veh.startEngine());
	}
}
