/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

/**
 *
 * @author Adam
 */
public class Snack {
     String name;
     Double price;
     int qty;
     
     public Snack (String newName, double newPrice, int startQty){
         name = newName;
         price = newPrice;
         qty = startQty;
     }
     
     public int snackRestock(int a){
         qty =+ a;
         return qty;
     }
     
     
     
     
}
