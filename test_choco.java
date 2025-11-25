/*
this file is to test choco

keep noted:
    -need 90 cents to buy
    -max stock is 10 chocos(can be out of stock)
    -4 diff types of choco


*/



public class test_choco
{
    public static void main(String[] args)
    {
        //try to buy choclate w less than 90 cents 
        System.out.println("test 1: try to buy chocolate with less than 90 cents");
        vendingMachine v_1 = new vendingMachine();
        v_1.addChoc("c1");
        StringBuffer choc1 = new StringBuffer("c1");

        v_1.coin(25); //keep balane below 90 cents
        v_1.coin(25);

        int change1 = v_1.getChoc(choc1);   //wont be able to get choco and will message out w low balance
        System.out.println("Return change: "+change1+ ", chocolate buff: "+choc1 + "\n");
        /*
            should get error that we have a low balance below 90 cents 
        */


       //try to buy choclate with more than 90 cents but thats out of stock........
       System.out.println("test 2: more than 90 cents but choclate type out of stock");
       vendingMachine v_2 = new vendingMachine();
       StringBuffer choc2 = new StringBuffer("c1");
       v_2.coin(25);
       v_2.coin(25);
       v_2.coin(25);
       v_2.coin(25);

       int change2 = v_2.getChoc(choc2);//selected to get choco that has no stock so -->sold out
       System.out.println("return change: "+change2 +" ,choc buffer: "+choc2+ "\n");
        /*
            we should get message saying sld out due to the selected chocolate being empty(aka out of stock)
        
        */

       //test where we do everythng right and we get choclste 
       System.out.println("test 3: we have enough funds AND choclate is in stock");
       vendingMachine v_3 = new vendingMachine();
       v_3.addChoc("c2");       //c2 is now stocked and another one to have rm
       v_3.addChoc("c2");
       StringBuffer choc3 = new StringBuffer("c2");
       v_3.coin(100);          //we have >=90
       int change3 = v_3.getChoc(choc3);  //getting c2 and dispense change 
       System.out.println("returned change: "+change3 + " ,choc buffer: "+choc3 +" \n");
       /* 
        we should see a successful run where c2 is avaible and purchased w a change of 10
       */

    }

}