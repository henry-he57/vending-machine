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
     * Author: Adam
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
        Snack marsBar = new Snack("Reese's Crispy Crunchy Bar", "Candy Bar, 250 Calories, 50g Sodium", 1.50, 5, 0.05);
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
     * Author: Henry
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
     * Author: Adam
     * Puts given change into change object array
     *
     * @param arrayLocation Location of change object in array
     * @param change The change object to put into array
     */
    public void addNewCoin(int arrayLocation, Change change) {
        changeInfo[arrayLocation] = change;
    }

    /**
     * Author: Henry
     * Displays given snack name, price, and amount
     *
     * @param snack The snack object to display information about
     * @param arrayLocation The location of the snack object in the array
     * @param moneyIn The amount of money inserted by the user
     */
    public void displaySnack(Snack snack, int arrayLocation, double moneyIn) {

        //print current balance before listing snacks
        if (arrayLocation == 0) {
            System.out.println("Current Balance: $" + df.format(moneyIn));
        }

        System.out.println(arrayLocation + ". " + snack.getName() + "  Price: $" + df.format(snack.getPrice()) + "  Amount Available: " + snack.getQty());
    }

    /**
     * Author: Henry and Adam for Rounding
     * Asks user for amount of each coin and calculates money total
     *
     * @param moneyIn The current user's money in machine
     * @return The user's money in machine after coin insertion
     */
    public double promptInsert(double moneyIn) {
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

        //set amount of coins put in by user
        changeInfo[0].setUserCoin(toonieAmount);
        changeInfo[1].setUserCoin(loonieAmount);
        changeInfo[2].setUserCoin(quarterAmount);
        changeInfo[3].setUserCoin(dimeAmount);
        changeInfo[4].setUserCoin(nickelAmount);

        //add the coins given by the user to the machine
        changeInfo[0].add(toonieAmount);
        changeInfo[1].add(loonieAmount);
        changeInfo[2].add(quarterAmount);
        changeInfo[3].add(dimeAmount);
        changeInfo[4].add(nickelAmount);

        //calculate the user's balance
        for (int count = 0; count < 5; count++) {
            moneyIn += changeInfo[count].add(changeInfo[count]);
        }

        moneyIn = Math.round(moneyIn * 100d) / 100d;
        System.out.println("Your balance is: $" + df.format(moneyIn));
        return moneyIn;
    }

    /**
     * Author: Henry
     * Asks user for desired snack, checks if snack is in stock, and displays
     * snack information
     *
     * @param snack The snack array storing the available snack information
     * @return the desired snack selection
     */
    public int promptSelection(Snack[] snack) {

        char confirmation;  //user decisions
        int snackNumber;    //snack selection made by user

        do {
            do {
                System.out.println("Please enter the number associated with the desired snack.");
                snackNumber = kbScan.nextInt();

                //exit loop for maintenance when instructed by user
                if (snackNumber == 10) {
                    break;

                    //print error message when the snack runs out of stock
                } else if (snack[snackNumber].getQty() == 0) {
                    System.out.println("Item not in stock. Please another snack.");
                }
            } while (snack[snackNumber].getQty() == 0);

            //exit to maintenance menu when instructed by user
            if (snackNumber == 10) {
                break;
            }

            //print snack information if needed
            System.out.println("Do you want to see the snack information for " + snack[snackNumber].getName() + "? (y/n)");
            confirmation = kbScan.next().charAt(0);
            if (confirmation == 'y' || confirmation == 'Y') {
                System.out.println(snack[snackNumber].getSnackDescription());
            }

            System.out.println("Do you want " + snack[snackNumber].getName() + "? (y/n)");
            confirmation = kbScan.next().charAt(0);
        } while (confirmation == 'n' || confirmation == 'N');

        return snackNumber;
    }

    /**
     * Author: Adam
     * Opens maintenance menu for change emptying/refilling, snack restocking,
     * profit calculation, and machine shutdown
     *
     * @param snackArray The array holding all available snacks
     */
    public boolean maintenance(Snack snackArray[]) {
        int selection;  //user decisions
        System.out.println("What would you like to do? 1 = 'Empty Change', 2 = 'Restock Snacks', 3 = 'Add Change', 4 = 'Calculate Profit', or 5 = 'Shut Down Machine'");
        selection = kbScan.nextInt();

        //empty all change from machine
        if (selection == 1) {
            for (int count = 0; count < 5; count++) {
                changeInfo[count].empty(changeInfo[count]);
            }
            System.out.println("Change emptied.");

        } //restock snacks into machine
        else if (selection == 2) {
            for (int count = 0; count < 10; count++) {
                System.out.println("How many " + snackArray[count].getName() + "s are you adding?");
                int qty = kbScan.nextInt();
                snackArray[count].snackRestock(qty);    //restock snack object with the given amount
            }

        } //refill change in machine
        else if (selection == 3) {
            for (int count = 0; count < 5; count++) {
                System.out.println("How many " + changeInfo[count] + "s are you adding?");
                int qty = kbScan.nextInt();
                changeInfo[count].stockChange(changeInfo[count], qty);
            }

        } //show current profit
        else if (selection == 4) {
            double profit = 0;
            for (int count = 0; count < 10; count++) {

                //multiply snacks sold by factory production cost and sale price and subtract production cost from sale price
                profit += (snackArray[count].getSnacksSold() * snackArray[count].getPrice()) - (snackArray[count].getSnacksSold() * snackArray[count].getRealPrice());

            }
            System.out.println(profit);
        } //end program and shut down machine
        else {
            return true;
        }
        return false;
    }

    /**
     * Author: Adam
     * Asks user if they have finished with the vending machine
     *
     * @return if the user is finished using the machine
     */
    public boolean isThatAll() {
        boolean finished;
        char confirmation;  //user decision
        System.out.println("Is that all? (Y/N): ");
        confirmation = kbScan.next().charAt(0);
        if (confirmation == 'n' || confirmation == 'N') {
            finished = false;
        } else {
            finished = true;
        }
        return finished;
    }

    /**
     * Author: Henry
     * Returns remaining money to user after use in order of highest
     * denomination
     *
     * @param moneyIn The remaining user balance
     */
    public void returnMoney(double moneyIn) {
        int amountReturned; //amount of coin returned to user
        System.out.println("Returning your change: $" + df.format(moneyIn));
        for (int count = 0; count < 5; count++) {
            amountReturned = 0;

            //run when coin is in machine and its value is less than the user's balance
            while (changeInfo[count].getCoinValue() <= moneyIn && changeInfo[count].getChange() > 0) {

                //subtract returned coin value from user's balance, remove one coin from machine storage, and add one to returned amount
                moneyIn -= changeInfo[count].getCoinValue();
                changeInfo[count].remove(1);
                amountReturned++;
            }

            //print coin return statements if at least one coin is returned
            if (amountReturned > 1) {
                System.out.println("You get " + amountReturned + " " + changeInfo[count].getCoinDescription() + "s back");
            } else if (amountReturned == 1) {
                System.out.println("You get " + amountReturned + " " + changeInfo[count].getCoinDescription() + " back");
            }
        }

        //print statement if all available coins in machine do not return enough money
        if (moneyIn > 0.5) {    //set to 0.5 due to error with Java not returned nickels (asked Mr. RD about it)
            System.out.println("Sorry, the machine is out of coins. Ayyy lmao");
        }

    }
}
