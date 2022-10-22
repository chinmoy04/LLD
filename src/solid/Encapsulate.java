package com.src.solid;

class Pancake{
	
	public Pancake orderPancake(String type) {
		Pancake pan = null;
		//this will change if new pancake is added
		//or any pancake is removed
		//move this to PancakeFactory
		if(type.equals("classic")) {
			pan = new ClassicPancake();
		}else if(type.equals("blueberry")) {
			pan = new BlueberryPancake();
		}
		
		return pan;
	}
}

public class Encapsulate {

}
