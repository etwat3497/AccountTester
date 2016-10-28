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

        
        
        System.out.println("What is your name?");
        String userName = "";
        Boolean nameLoop = false;

        //Run while loop to catch bad user input
        while(!nameLoop){
            System.out.println("What is the name of your bank?");
            userName = sc.nextLine();
            
            //If the user name is only numbers catch bad user input
            if(isNumeric(userName)){
                System.out.println("\nPlease input a valid bank name");
            }
            //If the user name is empty
            else if (userName.equals("")) {
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
            Personal object = new Personal(initialBalance, userName);
        }
        
        else if(accountType == 2){
            Buisness object = new Buisness(initialBalance, userName);
        }
        
        
        String userChoice = "";
        boolean done = false;
        //Run in a while loop to catch bad user input and continually run this until done is typed
        while(!done){
            System.out.println("Please input 'Deposit' to put money into your account, 'Withdrawl' to withdraw money from the account, "
            + "'Display' to display the current balance, or 'Interest' to calculate interest over a certain interval of time, and 'Done' to close the program");

            userChoice = sc.nextLine();

            if(userChoice.equalsIgnoreCase("Deposit")){
                System.out.println("Please input the deposit amount");
                
                try{
                    //If good user input run deposit method in specific account class
                    double depositValue = Double.parseDouble(sc.nextLine());
                    object.deposit(depositValue);
                }
                catch(NumberFormatException e){
                    System.out.println("Please enter a numeric value");
                }
                
            }

            else if(userChoice.equalsIgnoreCase("Withdrawl")){
                System.out.println("Please input the withdrawl amount");

                try{
                    //If good user input run withdraw method in specific account class
                    double withdrawlValue = Double.parseDouble(sc.nextLine()); 
                    object.withdrawl(withdrawlValue);
                }
                catch(NumberFormatException e){
                    System.out.println("Please enter a numeric value");
                } 
            }

            else if(userChoice.equalsIgnoreCase("Display")){
                object.displayBalance();
                System.out.println("Balance displayed successfully!");
            }

            else if(userChoice.equalsIgnoreCase("Done")){
                //End program
                System.out.println("Thank you, "+userName);
                done = true;
            }
            else{
                System.out.println("\nUnknown command. Please type in one of the identified keywords.");
            }
        }
    
        
        
    }
   /**
    * pre: String bank name
    * post: Boolean true or false
    * Method to check if the bank name string has only numbers in it
    */
    public static boolean isNumeric(String str){
    try{
        double d = Double.parseDouble(str);
    }
    catch(NumberFormatException e){
        return false;
    }
    return true;
    }
    
}
