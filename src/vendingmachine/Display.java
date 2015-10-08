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
    
    public void displaySnack(Snack a){
        System.out.println(a.getName() + "  " + a.getPrice() + "  " + a.getQty());
    }
    
}
