/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;
import java.util.*;
import java.io.Console;
import java.text.DecimalFormat;

/**
 *
 * @author 341167922
 */
public class Display {
    Scanner kbScan = new Scanner(System.in);
    public void displaySnack(Snack a){
        System.out.println(a.getName() + "  " + a.getPrice() + "  " + a.getQty());
    }
    
    public double promptInsert(){
        System.out.println("Please insert amount of money: ");
        double amount = kbScan.nextDouble();
        return amount;
    }
}
