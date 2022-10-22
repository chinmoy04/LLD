package com.src.structural.decorator;



interface Shape
{
 void draw();
}



class Circle implements Shape
{

 @Override
 public void draw()
 {
 System.out.println("Shape: Circle has been drawn");
 }
}



class Rectangle implements Shape
{

 @Override
 public void draw()
 {
 System.out.println("Shape: Rectangle has been drawn");
 }
}



abstract class ShapeDecorator implements Shape
{
 protected Shape decoratedShape;

 public ShapeDecorator( Shape decoratedShape )
 {
 this.decoratedShape = decoratedShape;
 }

 public void draw()
 {
 decoratedShape.draw();
 }
}



class BlueShapeDecorator extends ShapeDecorator
{

 public BlueShapeDecorator( Shape decoratedShape )
 {
 super(decoratedShape);
 }

 @Override
 public void draw()
 {
 decoratedShape.draw();
 setColor(decoratedShape);
 }

 private void setColor( Shape decoratedShape )
 {
 System.out.println("Color: Blue has been applied to "+decoratedShape);
 }
}



public class DecoratorPatternDemo
{
 public static void main(String[] args)
 {

 Shape blueCircle = new BlueShapeDecorator(new Circle());

 Shape blueRectangle = new BlueShapeDecorator(new Rectangle());

 System.out.println("\nCreate Blue color Circle using BlueShapeDecorator");
 blueCircle.draw();

 System.out.println("\nCreate Blue color Rectangle using BlueShapeDecorator");
 blueRectangle.draw();
 }
}
