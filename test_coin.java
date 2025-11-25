/*
this file tests coin and for vending machine, assignmment states to have 2+ cases 

what we know: 
    -machine only takes dimes, quarters and dollars and we need min 90 cents 

*/


public class test_coin
{
    public static void main(String[] args)
    {   //we will enter an invalid coin..........
        vendingMachine v1  = new vendingMachine();  
        System.out.println("test 1: entering invalid coin.......");
        v1.coin(50);     //kennedy quarter entered 
                        //expected to be ignored and returned 
        

        //we will try to enter accepted coins but keep balance below 90 cents........
        vendingMachine v2 = new vendingMachine(); 
        System.out.println("test 2: entering valid coins but balance will be below 90 cents.......");
        v2.coin(25);
        v2.coin(25);      //50 cents is entered but doesnt reach required 90 cents 


        //we will enter valid and invalid coins..............
        vendingMachine v3 = new vendingMachine();
        System.out.println("test 3: entering valid and invalid coins......");
        v3.coin(10);
        v3.coin(1);
        v3.coin(25);
        v3.coin(5);                 
        v3.coin(100);           //entered penny,nickle,dime,quarter, dollop 




    }






}