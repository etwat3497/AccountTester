/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package accounttester;

import java.text.DecimalFormat;

/**
 *
 * @author etwat3497
 */
abstract public class Account {
    //Declare global variables
    private String name;
    private double bal;
    private double minBalance;
    private double accountCharge;
    DecimalFormat x = new DecimalFormat("##.##");

  /**
   * pre: Initial balance, customer name, minimum balance, account charge
   * post: none
   * Constructor of superclass to assign values to variables for object
   */
    public Account(double initialBal, String userNme, double minBal, double accCharge){
        bal = initialBal;
        name = userNme;
        minBalance = minBal;
        accountCharge = accCharge; 
    }
    
  /**
   * pre: the amount being deposited
   * post: void
   * Method to calculate how much is deposited into the account
   */
    public void deposit(double depositAmount){
        if(depositAmount<0){
            //Catch bad user input
            System.out.println("\nInsufficient funds to deposit");
        }
        else{
            //Set the new balance
            bal += depositAmount;
            System.out.println("\nDeposit recorded successfully");
        }
        
        if(bal<minBalance){
                bal -= accountCharge;
                System.out.println("You are lower than your minimum balance, "+name+"! Your account has been deducted $"+accountCharge+". Your new "
                        + "balance is $"+bal+".");
            }
    }
    
    
  /**
   * pre: the amount being withdrawn
   * post: void
   * Method to calculate how much is withdrawn from the account
   */
    public void withdrawl(double withdrawlAmount){
        if(withdrawlAmount<0){
            //Catch bad user input
            System.out.println("\nPlease choose a positive value to withdraw");
        }
        else if(withdrawlAmount>bal){
            //Catch if the user is withdrawing more than what is in the balance
            System.out.println("\nInsufficient funds to withdraw");
        }
        else{
            //Set the new balance
            bal -= withdrawlAmount;
            System.out.println("\nWithdrawl recorded successfully");
        }

        if(bal<minBalance){
            bal -= accountCharge;
            System.out.println("You are lower than your minimum balance, "+name+"! Your account has been deducted $"+accountCharge+". Your new "
                    + "balance is $"+bal+".");
        }
            
        
    }
    
    
  /**
   * pre: void
   * post: void
   * Method to display the current balance
   */
    public void displayBalance(){
        System.out.println("The current balance is $"+x.format(bal)+", "+name+".");
    }
        
}