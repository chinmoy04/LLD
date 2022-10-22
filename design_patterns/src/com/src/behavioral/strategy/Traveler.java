package com.src.behavioral.strategy;

import java.util.Scanner;

interface TravelStrategy
{
	public void gotoAirport();
}



class AutoTravelStrategy implements TravelStrategy
{

	public void gotoAirport()
	{
		System.out.println("Traveler is going to Airport by Auto and will be charged 600 Rs");
	}

}



class BusTravelStrategy implements TravelStrategy
{

	public void gotoAirport()
	{
		System.out.println("Traveler is going to Airport by bus and will be charged 200 Rs");
	}

}



class TaxiTravelStrategy implements TravelStrategy
{

	public void gotoAirport()
	{
		System.out.println("Traveler is going to Airport by Taxi and will be charged 1000 Rs");
	}

}




class TrainTravelStrategy implements TravelStrategy
{

	public void gotoAirport()
	{
		System.out.println("Traveler is going to Airport by Train and will be charged 300 Rs");
	}

}




class TravelContext
{
	private TravelStrategy travelStrategy;

	// Client will set what TravelStrategy to use by calling this method
	public void setTravelStrategy(TravelStrategy strategy)
	{
		this.travelStrategy = strategy;
	}

	public TravelStrategy getTravelStrategy()
	{
		return travelStrategy;
	}

	public void gotoAirport()
	{
		travelStrategy.gotoAirport();
	}

}






public class Traveler
{

	public static void main( String[] args )
	{

		System.out.println("Please enter Travel Type : 'Bus' or 'Train' or 'Taxi' or 'Auto' ");
		Scanner scanner = new Scanner(System.in);
		String travelType = scanner.next();
		System.out.println("Travel type is : " + travelType);

		TravelContext ctx = null;
		ctx = new TravelContext();

		if( "Bus".equalsIgnoreCase(travelType) )
		{
			ctx.setTravelStrategy(new BusTravelStrategy());
		}
		else if("Train".equalsIgnoreCase(travelType))
		{
			ctx.setTravelStrategy(new TrainTravelStrategy());
		}
		else if("Taxi".equalsIgnoreCase(travelType))
		{
			ctx.setTravelStrategy(new TaxiTravelStrategy());
		}
		else if("Auto".equalsIgnoreCase(travelType))
		{
			ctx.setTravelStrategy(new AutoTravelStrategy());
		}
		System.out.println("Travel context has : "+ctx.getTravelStrategy());
		ctx.gotoAirport();

	}
}
