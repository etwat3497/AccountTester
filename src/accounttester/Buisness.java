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
//Sublass of account class
public class Buisness extends Account{

    
    public Buisness(){
        super(0, "Unknown user name",500,10); //Return base values for variables
    }
    
    public Buisness(double bal, String name){
        super(bal, name,500,10); //Return the balance and name
    }
}
