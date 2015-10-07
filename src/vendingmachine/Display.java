/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import java.io.Console;
import java.text.DecimalFormat;

/**
 *
 * @author 341167922
 */
public class Display {
    DecimalFormat f = new DecimalFormat("0.##");
    VendingMachine machine = new VendingMachine(20);
    
    public Display(){
        
    }
    
    public void displaySnack(Snack item){
        item.
    }
    
    public void displaySnacks(){
        System.out.println();
    }
    
    public void displayBalance(){
        System.out.println(machine.getMoneyIn());
    }
    
    
    
}
