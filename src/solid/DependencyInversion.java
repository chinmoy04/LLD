package com.src.solid;

class Desktop{
	private Monitor mon;
	private Keyboard key;
	
	//tight coupling of creating mon and key with Desktop
	public Desktop() {
		this.mon = new Monitor();
		this.key = (Keyboard) new QwertKeyboard();
	}
	
	//allow client to create m and k and pass to Desktop
	//Use Keyboard instead of QwertyKeyboard to allow dependency on interface
	public Desktop(Monitor m, Keyboard k) {
		this.mon = m;
		this.key = k;
	}
}


class Monitor{
	
}

interface Keyboard{
	
}

class QwertKeyboard{
	
}

public class DependencyInversion {

}
