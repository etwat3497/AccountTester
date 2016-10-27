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

        
        //EDIT COMMENTS FOR THE NAME OF CUSTOMER AND FIX ISNUMERIC - COPIED FROM MYBANKTESTER ON GIT HUB
        System.out.println("What is your name?");
        String bankName = "";
        Boolean nameLoop = false;

        //Run while loop to catch bad user input
        while(!nameLoop){
            System.out.println("What is the name of your bank?");
            bankName = sc.nextLine();
            
            //If the bank name is only numbers catch bad user input
            if(isNumeric(bankName)){
                System.out.println("\nPlease input a valid bank name");
            }
            //If the bank name is empty
            else if (bankName.equals("")) {
                System.out.println("\nPlease input a bank name");
            }
            //End the while loop
            else{
                nameLoop = true;
            }
        }
        

        int accountType = 0;
        Boolean accountTypeLoop = false;

        try{
            //Run while loop to catch bad user input
            while(!accountTypeLoop){
                System.out.println("What type of account do you have? Input 1 for a personal account"
                        + "or 2 for a buisness account.");
                accountType = Integer.parseInt(sc.nextLine());

                //If the account type is not 1 or 2
                if(accountType<1 || accountType>2){
                    System.out.println("\nPlease input 1 or 2");
                }
                //End the while loop
                else{
                    accountTypeLoop = true;
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
