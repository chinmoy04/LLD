package com.src.solid;

class Book{
	private int name;
	private int pageNumber;
	
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	//Violates Single Responsibility
	/*void printBookDetais() {
		
	}*/
}

class BookPrinter{
	//Do this instead
	void printBookDetais() {
		
	}
}

public class SingleResponsibility {
	
	public static void main(String[] args) {
		
	}

}
