//A Java implementation of VendingMachine.
//Original by Jeff Offutt, January 2004
//Modified by Jianjin Deng
//Main added later for testing.  



/*
	Notes:
			-only accepts dimes, quarters and dollars
			-min of 90 cents to buy cholcate...?
			-max stock size of choco is 10
*/


import java.util.*;
import java.io.*;

public class vendingMachine
{
	private int credit;
	private LinkedList<String> stock;
	
	//Maximum size of vendingMachine
	private static final int MAX = 10;


//************************************************
//Constructor
//vendingmachine starts empty.
//************************************************
vendingMachine()
{
	credit = 0;
	stock  = new LinkedList<String>(); // Empty stock.

}

//************************************************
//A coin is given to the vendingMachine.
//Must be a dime, quarter or dollar.
//Ignores invalid input
//************************************************
public void coin (int coin)
{
	if (coin != 10 && coin != 25 && coin != 100)
	   return;
	if (credit >= 90)
	   return;
	credit = credit + coin;
	return;
}

//************************************************
//User asks for a specific chocolate.
//Returns the change and the sets the
//parameter StringBuffer variable Choc.
//If not enough money or no chocolates,
//returns money and a blank string.
//************************************************
public int getChoc (StringBuffer choc)
{
	int change;

	if (credit < 90)      //need to have min 90 cents
	{
	   change = 0;
	   choc.replace (0, choc.length(), "");
	   System.out.println("No enough money!!!");
	   return credit;  
	   
	}
	
	int idx = stock.indexOf(choc.toString());
	if (stock.size() <= 0 || idx == -1)
	{
	    change = 0;
		choc.replace (0, choc.length(), "");
		System.out.println("Sold out!");
		return credit;  
		   
	}
	
	choc.replace (0, choc.length(), (String) stock.remove(idx));
	
	
	change = credit - 90;
	credit = 0;
	
	return (change);
}

//************************************************
//Adds one new piece of chocolate to the machine
//If machine is full, nothing happens
// The Vending Machine can only accept three types
// of chocolate.  
//************************************************
public void addChoc (String choc)
{
	if (stock.size() >= MAX)
	{
		System.out.println("The machine is full !!!");
		return;
	}

if (choc == "c1" || choc == "c2" || choc == "c3")
{
	stock.add (choc);
	return;
}else
{
	System.out.println(choc + " is not accpted!!!");
	return;
}
}

//************************************************
//mainV1() for initial testing.
//************************************************
public static void main (String[] argv)
{
	StringBuffer choc = new StringBuffer ("xx"); //empty str used to hold chocolate values below('c2','c1',ect)
	vendingMachine v = new vendingMachine ();   //creates new vending machine object named v
	v.addChoc ("c1");                          //all these adds choclate tyoes to vending machine..... 
	v.addChoc ("c2");
	v.addChoc ("c2");
	v.addChoc ("c4");
	v.addChoc ("c3");
	
	// FIRST get.........first try at buying something
	v.coin (10);                            //enter 10 cents
	v.coin (25);                           //enter 25 cents
	v.coin (100);                         //enter 100 cents (aka a Dollar)

	choc.replace (0, choc.length(), "c1");   // choose a specific chocolate --> Replace the contents of choc ("xx") with "c1" 
	int change = v.getChoc (choc);          //tries to buy chocolate then return change
	System.out.println ("First get, chocolate type: " + choc + ", change: " + change + "\n");
	
	// SECOND get........seconf try buying something
	v.coin (100);							//enter a dollar
	choc.replace (0, choc.length(), "c1"); // choose a specific chocolate --> selects 'c1'
	change = v.getChoc (choc);			  //attempts at buying c1
	System.out.println ("Second get, chocolate type: " + choc + ", change: " + change + "\n");
	
	// THIRD get.........third try buying something
	v.coin (25);						       //enter 25 cents 	
	v.coin (25);						      //enter 25 cents 
	choc.replace (0, choc.length(), "c2");   // choose a specific chocolate --> selects 'c2' this time
	change = v.getChoc (choc);				//attempts to buy 'c2'
	System.out.println ("Third get, chocolate type: " + choc + ", change: " + change + "\n");
}

} // End class vendingMachine
