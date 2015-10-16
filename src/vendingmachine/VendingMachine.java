/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

/**
 *
 * @author 341167922
 */
public class VendingMachine {

    private double moneyIn;
    private Snack[] snackInfo = new Snack[10];
    Display disp = new Display();

    public void displaySnacks() {
        for (int count = 0; count < 10; count++) {
            System.out.print(count + ". ");
            disp.displaySnack(snackInfo[count]);
        }
    }

    public void insertMoney() {
        disp.loadCoins();
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

    public void addNewSnack(int i, Snack s) {
        snackInfo[i] = s;
    }

    public void loadSnacks(VendingMachine vm) {
        disp.loadStartingSnacks(vm);
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

        vm.loadSnacks(vm);
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
    }
}
