package com.src.solid;

class Calculator{
	
	//Violates open closed
	//if new data type or operation is needed in future
	public void calculate(int a, int b, String op) {
		
	}
}

//Do something like this instead
interface Calculator1{
	public void calculate(Object a, Object b);
}

class AddCalculator{
	
}

public class OpenClosed {

}
