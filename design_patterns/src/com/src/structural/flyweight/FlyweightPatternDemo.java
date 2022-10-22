package com.src.structural.flyweight;

import java.util.HashMap;


interface Shape
{
 void draw();
}



class Circle implements Shape
{
 private String    color;
 private final int x      = 10;
 private final int y      = 20;
 private final int radius = 30;

 public Circle()
 {
 }

 public Circle( String color )
 {
   this.color = color;
 }

 public String getColor()
 {
   return color;
 }

 public void setColor( String color )
 {
   this.color = color;
 }

 @Override
 public void draw()
 {
   System.out.println(this+" : Circle: Draw() [Color : " + color + ", x : " + x + ", y :" + y + ", radius :"
                  + radius);
 }
}




class ShapeFactory
{
  private static final HashMap<String, Shape> shapeMap = new HashMap<String, Shape>();

  public static Shape getShape( String shapeType )
  {
    Shape shape=null;
    if( shapeType.equalsIgnoreCase("circle") )
    {
      shape = (Circle) shapeMap.get("circle");

      if( shape == null )
      {
        shape = new Circle();
        shapeMap.put("circle", shape);
        System.out.println("Creating circle object with out any color in shapefactory : " + shape
                       + "\n");
      }
    }
    return shape;
  }
}


public class FlyweightPatternDemo
{
  private static final String colors[] = { "Red", "Green", "Blue", "Orange", "Black" };

  public static void main( String[] args )
  {

    System.out.println("\n################ Red color Circles ####################");
    for( int i = 0; i < 10; ++i )
    {
      Circle circle = (Circle) ShapeFactory.getShape("circle");
      circle.setColor(colors[0]);
      circle.draw();
    }
    System.out.println("\n############### Green color Circles ####################");
    for( int i = 0; i < 10; ++i )
    {
      Circle circle = (Circle) ShapeFactory.getShape("circle");
      circle.setColor(colors[1]);
      circle.draw();
    }
    System.out.println("\n################ Blue color Circles ####################");
    
    for( int i = 0; i < 10; ++i )
    {
      Circle circle = (Circle) ShapeFactory.getShape("circle");
      circle.setColor(colors[2]);
      circle.draw();
    }
    System.out.println("\n################ Orange color Circles ####################");
    for( int i = 0; i < 10; ++i )
    {
      Circle circle = (Circle) ShapeFactory.getShape("circle");
      circle.setColor(colors[3]);
      circle.draw();
    }
    System.out.println("\n################ Black color Circles ####################");
    for( int i = 0; i < 10; ++i )
    {
      Circle circle = (Circle) ShapeFactory.getShape("circle");
      circle.setColor(colors[4]);
      circle.draw();
    }
  }
}

