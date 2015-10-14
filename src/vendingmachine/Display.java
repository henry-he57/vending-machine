/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import java.util.*;

/**
 *
 * @author 341167922
 */
public class Display {

    Scanner kbScan = new Scanner(System.in);
    Change changeInfo[] = new Change[5];

        /**
     * declares all the snacks and sets them all to a spot in the 'name' array
     *
     * @param vm the vending machine that the snacks are all in
     */
    public void loadStartingSnacks(VendingMachine vm) {
        Snack lays = new Snack("Lays", 2.00, 5, 0.10);
        vm.addNewSnack(0, lays);
        Snack doritos = new Snack("Doritos - Sweet Chili Heat", 2.00, 5, 0.10);
        vm.addNewSnack(1, doritos);
        Snack ruffles = new Snack("Ruffles All Dressed", 2.00, 5, 0.10);
        vm.addNewSnack(2, ruffles);
        Snack marsBar = new Snack("Mars Bar", 1.50, 5, 0.05);
        vm.addNewSnack(3, marsBar);
        Snack coffeeCrisp = new Snack("Coffee Crisp", 1.50, 5, 0.05);
        vm.addNewSnack(4, coffeeCrisp);
        Snack hersheys = new Snack("Hershey's Chocolate", 1.50, 5, 0.05);
        vm.addNewSnack(5, hersheys);
        Snack mentos = new Snack("Mentos", 2.00, 5, 0.07);
        vm.addNewSnack(6, mentos);
        Snack twizzlers = new Snack("Twizzlers", 1.50, 5, 0.07);
        vm.addNewSnack(7, twizzlers);
        Snack fuzzyPeaches = new Snack("Fuzzy Peaches", 2.50, 5, 0.25);
        vm.addNewSnack(8, fuzzyPeaches);
        Snack nerds = new Snack("Nerds", 3.00, 5, 0.30);
        vm.addNewSnack(9, nerds);
    }
    
    public void displaySnack(Snack a) {
        System.out.println(a.getName() + "  Price: $" + a.getPrice() + "  Amount Available: " + a.getQty());
    }

    public void addNewCoin(int i, Change s) {
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

    public double promptInsert(double moneyIn) {
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
        for (int count = 0; count < 5; count++) {
            moneyIn += changeInfo[count].add(changeInfo[count]);
        }
        return moneyIn;
    }

    public int promptSelection(Snack[] s) {

        char confirmation;
        int snackNumber;

        do {
            do {
                System.out.println("Please enter the number associated with the desired snack.");
                snackNumber = kbScan.nextInt();
                if (s[snackNumber].getQty() == 0) {
                    System.out.println("Item not in stock. Please try again.");
                }
            } while (s[snackNumber].getQty() == 0);

            System.out.println("Do you want a " + s[snackNumber].getName() + "? (y/n)");
            confirmation = kbScan.next().charAt(0);
        } while (confirmation == 'n' || confirmation == 'N');   
        s[snackNumber].increaseSnacksSold();
        return snackNumber;
    }

    public void maintenance(Snack snackArray[]) {
        int selection = 0;
        System.out.println("What would you like to do? 1 = 'empty change', 2 = 'restock', 3 = 'add change' or 4 = 'calculate profit'");
        selection = kbScan.nextInt();
        if (selection == 1){
            for (int count = 0; count < 5; count ++){
                changeInfo[count].empty();
            }
        }else if(selection == 2){
            for (int count = 0; count < 10; count ++){
                System.out.println("How many " + snackArray[count] + "s are you adding?");
                int qty = kbScan.nextInt();
                snackArray[count].snackRestock(qty);
            }
        }else if (selection == 30){
            for (int count = 0; count < 5; count ++){
                System.out.println("How many " + changeInfo[count] + "s are you adding?");
                int qty = kbScan.nextInt();
                changeInfo[count].stockChange(changeInfo[count], qty);
            }
        }else{
            double proffit = 0;
            for (int count = 0; count < 10; count ++){
                proffit += (snackArray[count].getSnacksSold() * snackArray[count].getPrice())-(snackArray[count].getSnacksSold() * snackArray[count].getRealPrice());
            }
            System.out.println(proffit);
        }
    }
}
