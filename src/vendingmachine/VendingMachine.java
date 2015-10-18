/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

/**
 *
 * @author Adam Morrison and Henry He
 */
public class VendingMachine {

    private double moneyIn; //amount of money input by user
    private Snack[] snackInfo = new Snack[10];  //array for snack objects
    Display disp = new Display();   //display of vending machine (pretty much LED LIGHTS AND PLEXIGLASS)

    /**
     * Calls method in display to load assets such as snacks and coins into vending machine
     *
     * @param vm The vending machine to load the snacks and coins into
     */
    public void loadAssets(VendingMachine vm) {
        disp.loadStartingSnacks(vm);
        disp.loadCoins();
    }

    /**
     * Puts given snack into snack object array
     * 
     * @param arrayLocation Location of snack object in array
     * @param snack The snack object to put into array
     */
    public void addNewSnack(int arrayLocation, Snack snack) {
        snackInfo[arrayLocation] = snack;
    }

    /**
     * Displays all available snacks
     */
    public void displaySnacks() {
        for (int count = 0; count < 10; count++) {
            System.out.print(count + ". ");
            disp.displaySnack(snackInfo[count]);
        }
    }

    public void insertMoney() {
        moneyIn = disp.promptInsert(moneyIn);
    }

    public void getSelection() {
        int snackSelection = disp.promptSelection(snackInfo);
        if (snackSelection != 10) {
            boolean enoughMoney = snackInfo[snackSelection].snackPurchased(snackInfo[snackSelection], moneyIn);
            if (enoughMoney == true) {
                moneyIn -= snackInfo[snackSelection].getPrice();
            }
        } else {
            disp.maintenance(snackInfo);
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();   //create new vending machine

        vm.loadAssets(vm);  //loads snack and coin objects into vending machine vm
        do {
            do {
                vm.displaySnacks();
                vm.insertMoney();
                vm.getSelection();
            } while (vm.isThatAll() == false);
            vm.returnMoney();
        } while (1 > 0);
        // I changed the maintenance calling so it will only be called if 10 if given when selecting a snack - Adam
    }

    /**
     * @return the moneyIn
     */
    public double getMoneyIn() {
        return moneyIn;
    }

    /**
     * @param moneyIn the moneyIn to set
     */
    public void setMoneyIn(int newMoneyIn) {
        moneyIn = newMoneyIn;
    }

    public boolean isThatAll() {
        boolean isThatAll = disp.isThatAll();
        return isThatAll;
    }

    public void returnMoney() {
        disp.returnMoney(moneyIn);
        moneyIn = 0;
    }
}
