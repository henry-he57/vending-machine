/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import java.text.DecimalFormat;
import java.util.*;

/**
 *
 * @author Adam Morrison and Henry He
 */
public class Display {

    Scanner kbScan = new Scanner(System.in);    //scanner for user input
    Change changeInfo[] = new Change[5];    //array for change objects
    DecimalFormat df = new DecimalFormat("0.00");   //object to round price values

    /**
     * Declares all snacks and and places them in snack array for vending
     * machine
     *
     * @param vm The vending machine to load the snacks into
     */
    public void loadStartingSnacks(VendingMachine vm) {
        //create snack objects
        Snack lays = new Snack("Lays", "Chips, 400 Calories, 100g Sodium(per chip)", 2.00, 5, 0.10);
        Snack doritos = new Snack("Doritos - Sweet Chili Heat", "Chips, 405 Calories, 60g Sodium", 2.00, 5, 0.10);
        Snack ruffles = new Snack("Ruffles All Dressed", "Chips, 350 Calories, 75g Sodium, 'so wavy'", 2.00, 5, 0.10);
        Snack marsBar = new Snack("Mars Bar", "Candy Bar, 250 Calories, 50g Sodium", 1.50, 5, 0.05);
        Snack coffeeCrisp = new Snack("Coffee Crisp", "Candy Bar, 275 Calories, 50g Sodium", 1.50, 5, 0.05);
        Snack hersheys = new Snack("Hershey's Chocolate", "Candy Bar, 300 Calories, 60g Sodium", 1.50, 5, 0.05);
        Snack mentos = new Snack("Mentos", "Candy Pieces, 250 Calories, 50g Sodium", 2.00, 5, 0.07);
        Snack twizzlers = new Snack("Twizzlers", "Candy Pieces, 200 Calories, 50g Sodium", 1.50, 5, 0.07);
        Snack fuzzyPeaches = new Snack("Fuzzy Peaches", "Candy Pieces, 300 Calories, 75g Sodium", 2.50, 5, 0.25);
        Snack nerds = new Snack("Nerds", "God Candy, 0 Calories, 0g Sodium, '3 good 5 me'", 3.00, 5, 0.30);

        //load snack objects into snack array
        vm.addNewSnack(0, lays);
        vm.addNewSnack(1, doritos);
        vm.addNewSnack(2, ruffles);
        vm.addNewSnack(3, marsBar);
        vm.addNewSnack(4, coffeeCrisp);
        vm.addNewSnack(5, hersheys);
        vm.addNewSnack(6, mentos);
        vm.addNewSnack(7, twizzlers);
        vm.addNewSnack(8, fuzzyPeaches);
        vm.addNewSnack(9, nerds);
    }

    /**
     * Declares all coins and places them in change array
     */
    public void loadCoins() {
        //create change objects
        Change toonie = new Change("Toonie", 2.00, 10);     
        Change loonie = new Change("Loonie", 1.00, 10);      
        Change quarter = new Change("Quarter", 0.25, 10);     
        Change dime = new Change("Dime", 0.10, 10);        
        Change nickel = new Change("Nickel", 0.05, 10);   
        
        //load change objects into change array
        addNewCoin(0, toonie);
        addNewCoin(1, loonie);
        addNewCoin(2, quarter);
        addNewCoin(3, dime);
        addNewCoin(4, nickel);
    }

    /**
     * Puts given change into change object array
     * 
     * @param arrayLocation Location of change object in array
     * @param change The change object to put into array
     */
    public void addNewCoin(int arrayLocation, Change change) {
        changeInfo[arrayLocation] = change;
    }

    public void displaySnack(Snack a) {
        System.out.println(a.getName() + "  Price: $" + df.format(a.getPrice()) + "  Amount Available: " + a.getQty());
    }

    public double promptInsert(double moneyIn) {
        System.out.println("Please input number of toonies");
        int toonieAmount = kbScan.nextInt();
        changeInfo[0].addUserCoin(toonieAmount);
        changeInfo[0].add(toonieAmount);
        System.out.println("Please input number of loonies");
        int loonieAmount = kbScan.nextInt();
        changeInfo[1].addUserCoin(loonieAmount);
        changeInfo[1].add(loonieAmount);
        System.out.println("Please input number of quarters");
        int quarterAmount = kbScan.nextInt();
        changeInfo[2].addUserCoin(quarterAmount);
        changeInfo[2].add(quarterAmount);
        System.out.println("Please input number of dimes");
        int dimeAmount = kbScan.nextInt();
        changeInfo[3].addUserCoin(dimeAmount);
        changeInfo[3].add(dimeAmount);
        System.out.println("Please input number of nickels");
        int nickelAmount = kbScan.nextInt();
        changeInfo[4].addUserCoin(nickelAmount);
        changeInfo[4].add(nickelAmount);
        for (int count = 0; count < 5; count++) {
            moneyIn += changeInfo[count].add(changeInfo[count]);
        }
        moneyIn = Math.round(moneyIn * 100d) / 100d;
        System.out.println("Your balance is: $" + df.format(moneyIn));
        return moneyIn;
    }

    public int promptSelection(Snack[] s) {

        char confirmation;
        int snackNumber;

        do {
            do {
                System.out.println("Please enter the number associated with the desired snack.");
                snackNumber = kbScan.nextInt();
                if (snackNumber == 10) {
                    break;
                } else if (s[snackNumber].getQty() == 0) {
                    System.out.println("Item not in stock. Please another snack.");
                }
            } while (s[snackNumber].getQty() == 0);
            if (snackNumber == 10) {
                break;
            }
            System.out.println("Do you want to see the snack information for " + s[snackNumber].getName() + "? (y/n)");
            confirmation = kbScan.next().charAt(0);
            if (confirmation == 'y' || confirmation == 'Y') {
                System.out.println(s[snackNumber].getSnackDescription());
            }
            System.out.println("Do you want a " + s[snackNumber].getName() + "? (y/n)");
            confirmation = kbScan.next().charAt(0);
        } while (confirmation == 'n' || confirmation == 'N');
        if (snackNumber != 10) {
            s[snackNumber].increaseSnacksSold();
        }
        return snackNumber;
    }

    public void maintenance(Snack snackArray[]) {
        int selection;
        System.out.println("What would you like to do? 1 = 'Empty Change', 2 = 'Restock', 3 = 'Add Change' or 4 = 'Calculate Profit'");
        selection = kbScan.nextInt();
        if (selection == 1) {
            for (int count = 0; count < 5; count++) {
                changeInfo[count].empty(changeInfo[count]);
            }
            System.out.println("Change emptied.");
        } else if (selection == 2) {
            for (int count = 0; count < 10; count++) {
                System.out.println("How many " + snackArray[count].getName() + "s are you adding?");
                int qty = kbScan.nextInt();
                snackArray[count].snackRestock(qty);
            }
        } else if (selection == 3) {
            for (int count = 0; count < 5; count++) {
                System.out.println("How many " + changeInfo[count] + "s are you adding?");
                int qty = kbScan.nextInt();
                changeInfo[count].stockChange(changeInfo[count], qty);
            }
        } else {
            double profit = 0;
            for (int count = 0; count < 10; count++) {
                profit += (snackArray[count].getSnacksSold() * snackArray[count].getPrice()) - (snackArray[count].getSnacksSold() * snackArray[count].getRealPrice());
            }
            System.out.println(profit);
        }
    }

    public boolean isThatAll() {
        boolean isThatAllBool;
        char isThatAllChar;
        System.out.println("Is that all? (Y/N): ");
        isThatAllChar = kbScan.next().charAt(0);
        if (isThatAllChar == 'n' || isThatAllChar == 'N') {
            isThatAllBool = false;
        } else {
            isThatAllBool = true;
        }
        return isThatAllBool;
    }

    public void returnMoney(double moneyIn) {
        int a;
        System.out.println("Returning your change: $" + df.format(moneyIn));
        for (int count = 0; count < 5; count++) {
            a = 0;
            while (changeInfo[count].getCoinValue() <= moneyIn && changeInfo[count].getChange() > 0) {
                moneyIn -= changeInfo[count].getCoinValue();
                changeInfo[count].remove(1);
                a++;
            }
            if (a > 1) {
                System.out.println("You get " + a + " " + changeInfo[count].getCoinDescription() + "s back");
            } else if (a == 1) {
                System.out.println("You get " + a + " " + changeInfo[count].getCoinDescription() + " back");
            }
        }

        if (moneyIn > 0.5) {
            System.out.println("Sorry, the machine is out of coins. Ayyy lmao");
        }

    }
}
