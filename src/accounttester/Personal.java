/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package accounttester;

/**
 *
 * @author etwat3497
 */
//Subclass of Account class
public class Personal extends Account{

  /**
   * pre: none
   * post: none
   * Default constructor to assign base values to variables
   */
    public Personal(){
        super(0,"Unknown user name",100,2); //Return base values for variables
    }
    
    
  /**
   * pre: Initial balance and customer name
   * post: none
   * Constructor to look for initial balance and customer name and return to the account superclass
   */
    public Personal(double bal, String name){
        super(bal, name,100,2);
    }
    
    
    
    
    
    
}
