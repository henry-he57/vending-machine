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
    Change changeInfo[] = new Change[5];
    double userBalance =0;
    public void displaySnack(Snack a) {
        System.out.println(a.getName() + "  " + a.getPrice() + "  " + a.getQty());
    }

    public void addNewCoin(int i, Change s){
        changeInfo[i] = s;
    }
    
    public void loadCoins() {
        Change toonie = new Change("Toonie", 2.00, 0);
        addNewCoin(0, toonie);
        Change loonie = new Change("Loonie", 1.00, 0);
        addNewCoin(1, loonie);
        Change quarter = new Change("Quarter", 0.25, 0);
        addNewCoin(2, quarter);
        Change dime = new Change("Dime", 0.10, 0);
        addNewCoin(3, dime);
        Change nickel = new Change("Nickel", 0.05, 0);
        addNewCoin(4, nickel);
    }

    public double promptInsert() {
        System.out.println("Please input number of toonies");
        int toonieAmount = kbScan.nextInt();
        changeInfo[0].addUserCoin(toonieAmount);
        System.out.println("Please input number of loonies");
        int loonieAmount = kbScan.nextInt();
        changeInfo[1].addUserCoin(loonieAmount);
        System.out.println("Please input number of quarters");
        int quarterAmount = kbScan.nextInt();
        changeInfo[2].addUserCoin(quarterAmount);
        System.out.println("Please input number of dimes");
        int dimeAmount = kbScan.nextInt();
        changeInfo[3].addUserCoin(dimeAmount);
        System.out.println("Please input number of nickels");
        int nickelAmount = kbScan.nextInt();
        changeInfo[4].addUserCoin(nickelAmount);
        for (int count = 0; count < 5; count ++){
            userBalance += changeInfo[count].add(changeInfo[count]);
        }
        return userBalance;
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
