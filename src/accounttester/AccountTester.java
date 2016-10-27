/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package accounttester;

import java.util.Scanner;

/**
 *
 * @author etwat3497
 */
public class AccountTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("What is the name of your bank?");
        int accountType = 0;
        Boolean bankNameLoop = false;

        try{
            //Run while loop to catch bad user input
            while(!bankNameLoop){
                System.out.println("What type of account do you have? Input 1 for a personal account"
                        + "or 2 for a buisness account.");
                accountType = Integer.parseInt(sc.nextLine());

                //If the bank name is only numbers catch bad user input
                if(accountType<1 || accountType>2){
                    System.out.println("\nPlease input 1 or 2");
                }
                //End the while loop
                else{
                    bankNameLoop = true;
                }
            }
        }
        catch(NumberFormatException e){
            //Catch bad user input
            System.out.println("Please input an integer value.");
        }


        double initialBalance = 0;
        Boolean run = false;

        //Run in while loop to catch bad user input when getting initial balance
        while(!run){
            try{
                System.out.println("What is your initial balance?");
                initialBalance = Double.parseDouble(sc.nextLine());

                if(initialBalance<0){
                    System.out.println("\nPlease input a positive value.");
                }
                else{
                    //End while loop
                    System.out.println("Initial balance recorded successfully.");
                    run = true;
                }
            }
            catch(NumberFormatException e){
                System.out.println("\nPlease input a number value");
            }
        }
        
        if(accountType == 1){
            Personal object = new Personal(initialBalance);
        }
        
        else if(accountType == 2){
            Buisness object = new Buisness(initialBalance);
        }
    
    }
    
}