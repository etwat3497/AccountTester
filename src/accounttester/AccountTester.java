/*
 * Created by Ethan Watt
 * On October 28,2016
 * Designed to demonstrate superclasses and subclasses in the creation of an account program
 */

package accounttester;

import java.util.Scanner;

/**
 *
 * @author etwat3497
 */
public class AccountTester {

    public static Account assignAccount(){
        //Declare variables
        int accountType = 0;
        Scanner input = new Scanner(System.in);
        double initialBalance = 0;
        
        String userName;
        Boolean accountTypeLoop = true;

        try{
            //Run while loop to catch bad user input
            while(accountTypeLoop){
                System.out.println("What type of account do you have? Input 1 for a personal account"
                        + " or 2 for a buisness account.");
                accountType = Integer.parseInt(input.nextLine());

                //If the account type is not 1 or 2
                if(accountType<1 || accountType>2){
                    System.out.println("\nPlease input 1 or 2");
                }
                //End the while loop
                else{
                    accountTypeLoop = false;
                }
            }
        }
        catch(NumberFormatException e){
            //Catch bad user input
            System.out.println("Please input an integer value.");
        }
        
        
        Boolean initialBalLoop = true;
        //Determine initial balance
        while(initialBalLoop){
            try{
                System.out.println("What is your initial balance?");
                initialBalance = Double.parseDouble(input.nextLine());

                //Initial balance isn't high enough; continue while loop
                if(accountType == 1 && initialBalance<100){
                     System.out.println("Please input $100 or more.");
                }
                else if(accountType == 2 && initialBalance<500){
                    System.out.println("Please input $500 or more.");
                }

                //Stop the while loop
                else if(accountType == 1 && initialBalance>=100){
                    initialBalLoop = false;
                }
                else if(accountType == 2 && initialBalance>=500){
                    initialBalLoop = false;
                }
            }
            catch(NumberFormatException e){
                System.out.println("Invalid input!");
            }
        }
        

        //Get name
        System.out.println("What is your name?");
        userName = input.nextLine();
        
        //Assign the type of account to customer object
        if(accountType == 1){
            return(new Personal(initialBalance,userName));
        }
        else{
            return(new Buisness(initialBalance, userName));        
        }
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //Create a customer object in the class account and then assign it to a subclass
        Account customer;
        customer = assignAccount();


       
        String userChoice = "";
        boolean done = false;
        //Run in a while loop to catch bad user input and continually run this until done is typed
        while(!done){
            System.out.println("Please input 'Deposit' to put money into your account, 'Withdrawl' to withdraw money from the account, "
            + "'Display' to display the current balance, or 'Done' to close the program");

            userChoice = sc.nextLine();

            if(userChoice.equalsIgnoreCase("Deposit")){
                System.out.println("Please input the deposit amount");
                
                try{
                    //If good user input run deposit method in specific account class
                    double depositValue = Double.parseDouble(sc.nextLine());
                    customer.deposit(depositValue);
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
                    customer.withdrawl(withdrawlValue);
                }
                catch(NumberFormatException e){
                    System.out.println("Please enter a numeric value");
                } 
            }

            else if(userChoice.equalsIgnoreCase("Display")){
                customer.displayBalance();
                System.out.println("Balance displayed successfully!");
            }

            else if(userChoice.equalsIgnoreCase("Done")){
                //End program
                System.out.println("Good bye!");
                done = true;
            }
            else{
                System.out.println("\nUnknown command. Please type in one of the identified keywords.");
            }
        }
    }

    
}
