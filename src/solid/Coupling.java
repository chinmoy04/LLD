package com.src.solid;

class WeatherApp{
	//Dependent on concrete class 
	//causes tight coupling
	//should be changed to Interface Screen
	//Programming to intterface is also appluied
	LCDScreen screen;
}

interface Screen{
	
}

class LCDScreen implements Screen{
	
}

public class Coupling {

}
