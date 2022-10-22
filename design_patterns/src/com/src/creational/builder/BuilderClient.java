package com.src.creational.builder;


class Beverage
{

 private int    water;
 private int    milk;
 private int    sugar;
 private int    powderQuantity;
 private String beverageName;

 public int getWater()
 {
 return water;
 }

 public void setWater( int water )
 {
 this.water = water;
 }

 public int getMilk()
 {
 return milk;
 }

 public void setMilk( int milk )
 {
 this.milk = milk;
 }

 public int getSugar()
 {
 return sugar;
 }

 public void setSugar( int sugar )
 {
 this.sugar = sugar;
 }

 public int getPowderQuantity()
 {
 return powderQuantity;
 }

 public void setPowderQuantity( int powderQuantity )
 {
 this.powderQuantity = powderQuantity;
 }

 public String getBeverageName()
 {
 return beverageName;
 }

 public void setBeverageName( String beverageName )
 {
 this.beverageName = beverageName;
 }

 public String toString()
 {
 return "Hot " + beverageName + "!!!!  [" + water + " ml of water, " + milk + "ml of milk, " + sugar
                + " gm of sugar, " + powderQuantity + " gm of " + beverageName + "]\n";
 }

}




/**
 * 
 * BeverageBuilder is a blue print for any Class that wants to create
 * Beverage. It will have different subClass implementations of BeverageBuilder
 * for different beverages[e.g. coffee,tea,Horlicks etc].
 */
abstract class BeverageBuilder
{

 private Beverage beverage;

 public Beverage getBeverage()
 {
 return beverage;
 }

 public void setBeverage( Beverage beverage )
 {
 this.beverage = beverage;
 }

 /*
 * Template method that creates Beverage Object and returns Beverage
 * Object after adding components in required proportion.
 */
 public final Beverage buildBeverage()
 {
 Beverage beverage = createBeverage();
 setBeverage(beverage);
 setBeverageType();
 setWater();
 setMilk();
 setSugar();
 setPowderQuantity();
 return beverage;
 }

 abstract void setBeverageType();

 abstract void setWater();

 abstract void setMilk();

 abstract void setSugar();

 abstract void setPowderQuantity();

 abstract Beverage createBeverage();

}




/* 
 * CoffeeBuilder creates coffee by mixing the components[water,milk,sugar,coffee powder]. 
 * CoffeeBuilder implements BeverageBuilder which is bluePrint for creating beverage objects.
 * */
class CoffeeBuilder extends BeverageBuilder
{
 Beverage createBeverage()
 {
 return new Beverage();
 }

 public void setWater()
 {
 System.out.println("Step 1 : Boiling water");
 getBeverage().setWater(40);
 }

 public void setMilk()
 {
 System.out.println("Step 2 : Adding milk");
 getBeverage().setMilk(50);
 }

 void setSugar()
 {
 System.out.println("Step 3 : Adding sugar");
 getBeverage().setSugar(10);
 }

 void setPowderQuantity()
 {
 System.out.println("Step 4 : Adding 9 Grams of coffee powder");
 getBeverage().setPowderQuantity(9);
 }

 void setBeverageType()
 {
 System.out.println("Coffee");
 getBeverage().setBeverageName("Coffee");
 }

}




/* 
 * TeaBuilder creates Tea by mixing the components[water,milk,sugar,tea powder]. 
 * It implements BeverageBuilder which is bluePrint for creating beverage objects.
 * */
class TeaBuider extends BeverageBuilder
{

 Beverage createBeverage()
 {
 return new Beverage();
 }

 public void setWater()
 {
 System.out.println("Step 1 : Boiling water");
 getBeverage().setWater(40);
 }

 public void setMilk()
 {
 System.out.println("Step 2 : Adding milk");
 getBeverage().setMilk(50);
 }

 void setSugar()
 {
 System.out.println("Step 3 : Adding sugar");
 getBeverage().setSugar(10);
 }

 void setPowderQuantity()
 {
 System.out.println("Step 4 : Adding 9 Grams of tea powder");
 getBeverage().setPowderQuantity(9);
 }


 void setBeverageType()
 {
 System.out.println("Tea");
 getBeverage().setBeverageName("Tea");
 }

}




class HotelWaiter
{

 public static Beverage takeOrder( String beverageType )
 {

 BeverageBuilder beverageBuilder = null;

 if( beverageType.equalsIgnoreCase("tea") )
 {
 beverageBuilder = new TeaBuider();
 }
 else if( beverageType.equalsIgnoreCase("coffee") )
 {
 beverageBuilder = new CoffeeBuilder();
 }
 else
 {
 System.out.println("Sorry we don't take order for  " + beverageType);
 }
 return beverageBuilder.buildBeverage();
 }

}


/*
 *  Customer who is in hotel and customer can place order to 
 *  HotelWaiter or Servant.
 */
public class BuilderClient
{
 public static void main( String[] args )
 {

 Beverage tea = HotelWaiter.takeOrder("tea");
 System.out.println(tea);
 
 Beverage coffee = HotelWaiter.takeOrder("coffee");
 System.out.println(coffee);
 }
}

