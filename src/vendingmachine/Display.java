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

    public void displaySnack(Snack a) {
        System.out.println(a.getName() + "  " + a.getPrice() + "  " + a.getQty());
    }

    public void loadCoins() {
        Change toonie = new Change(0, "Toonie", 2.00, 0);
        Change loonie = new Change(1, "Loonie", 1.00, 0);
        Change quarter = new Change(2, "Quarter", 0.25, 0);
        Change dime = new Change(3, "Dime", 0.10, 0);
        Change nickel = new Change(4, "Nickel", 0.05, 0);

    }

    public double promptInsert() {
        System.out.println("Please input number of toonies");
        int toonieAmount = kbScan.nextInt();
        System.out.println("Please input number of loonies");
        int loonieAmount = kbScan.nextInt();
        System.out.println("Please input number of quarters");
        int quarterAmount = kbScan.nextInt();
        System.out.println("Please input number of dimes");
        int dimeAmount = kbScan.nextInt();
        System.out.println("Please input number of nickels");
        int nickelAmount = kbScan.nextInt();

        
        
        addChange(toonieAmount, loonieAmount, quarterAmount, dimeAmount, nickelAmount);
    }

    public int promptSelection(Snack[] s) {

        char confirmation = 'n';
        int snackNumber = 0;

        do {
            System.out.println("Please enter the number associated with the desired snack.");
            snackNumber = kbScan.nextInt();
            System.out.println("Do you want a " + s[snackNumber].getName() + "? (y/n)");
            confirmation = kbScan.next().charAt(0);
        } while (confirmation == 'n' || confirmation == 'N');

        return snackNumber;
    }

}
