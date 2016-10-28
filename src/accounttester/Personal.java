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
    
    public Personal(){
        super(0,"Unknown user name",100,2); //Return base values for variables
    }
    
    public Personal(double bal, String name){
        super(bal, name,100,2);
    }
    
    
    
    
    
    
}
