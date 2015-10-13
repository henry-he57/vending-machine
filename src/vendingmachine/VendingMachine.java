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

    private int bank;
    private double moneyIn;
    private Snack[] snackInfo = new Snack[10];
    Display disp = new Display();

    public void insertMoney() {
        disp.loadCoins();
        moneyIn = disp.promptInsert(moneyIn);
        System.out.println("Your balance is: $" + moneyIn);
    }

    public void addNewSnack(int i, Snack s) {
        snackInfo[i] = s;
    }

    public void displaySnacks() {
        for (int count = 0; count < 10; count++) {
            System.out.print(count + ". ");
            disp.displaySnack(snackInfo[count]);
        }
    }

    public void getSelection() {
        int snackSelection = disp.promptSelection(snackInfo);
        snackInfo[snackSelection].snackPurchased(snackInfo[snackSelection], moneyIn);
    }

    public void loadSnacks(VendingMachine vm) {
        disp.loadStartingSnacks(vm);
    }

    public void maintenance() {
        disp.maintenance();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

        vm.loadSnacks(vm);
        vm.displaySnacks();
        vm.insertMoney();
        vm.getSelection();
        vm.maintenance();
    }

    /**
     * @return the bank
     */
    public int getBank() {
        return bank;
    }

    /**
     * @param bank the bank to set
     */
    public void setBank(int newBank) {
        bank = newBank;
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

}
