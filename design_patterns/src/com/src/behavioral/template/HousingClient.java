package com.src.behavioral.template;


abstract class HouseTemplate
{

	// Template method is final so subclasses can't override
	public final void buildHouse()
	{
		buildFoundation();
		buildPillars();
		buildWalls();
		buildWindows();
		System.out.println("House is built.");
	}

	// Methods to be implemented by subclasses

	public abstract void buildFoundation();

	public abstract void buildPillars();

	public abstract void buildWalls();

	public abstract void buildWindows();

}



class GlassHouse extends HouseTemplate
{

	@Override
	public void buildFoundation()
	{
		System.out.println("Building foundation with cement,iron rods and sand");
	}

	@Override
	public void buildPillars()
	{
		System.out.println("Building Pillars with glass coating");
	}

	@Override
	public void buildWalls()
	{
		System.out.println("Building Glass Walls");
	}

	@Override
	public void buildWindows()
	{
		System.out.println("Building Glass Windows");

	}

}



class WoodenHouse extends HouseTemplate
{

	@Override
	public void buildFoundation()
	{
		System.out.println("Building foundation with cement,iron rods,sand and wood");
	}

	@Override
	public void buildPillars()
	{
		System.out.println("Building Pillars with Wood coating");
	}

	@Override
	public void buildWalls()
	{
		System.out.println("Building Wooden Walls");
	}

	@Override
	public void buildWindows()
	{
		System.out.println("Building Wooden Windows");

	}

}



public class HousingClient
{

	public static void main( String[] args )
	{

		System.out.println("Build a WoodenHouse\n");
		HouseTemplate houseType = new WoodenHouse();

		// using template method
		houseType.buildHouse();
		System.out.println("************************************************************");

		System.out.println("Build a GlassHouse\n");
		houseType = new GlassHouse();

		houseType.buildHouse();
	}

}

