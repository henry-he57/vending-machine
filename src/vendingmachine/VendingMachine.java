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
    private int[] snackQty = new int[10];
    private Snack[] name = new Snack[10];

            
            
            
    Snack[0] = new Snack[0]("Lays", 2.00, 5);
    Snack doritos = new Snack("Doritos - Sweet Chili Heat", 2.00, 5);
    Snack ruffles = new Snack("Ruffles All Dressed", 2.00, 5);
    Snack marsBar = new Snack("Mars Bar", 1.50, 5);
    Snack coffeeCrisp = new Snack("Coffee Crisp", 1.50, 5);
    Snack hersheys = new Snack("Hershey's Chocolate", 1.50, 5);
    Snack mentos = new Snack("Mentos", 2.00, 5);
    Snack twizzlers = new Snack("Twizzlers", 1.50, 5);
    Snack fuzzyPeaches = new Snack("Fuzzy Peaches", 2.50, 5);
    Snack nerds = new Snack("Nerds", 3.00, 5);

    public VendingMachine(double m) {
        moneyIn = m;
    }

    public void insertMoney() {

    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Display disp = new Display();
        disp.displayBalance();

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
    public void setMoneyIn(int currentMoneyIn) {
        moneyIn = currentMoneyIn;
    }

    /**
     * @return the snackQty
     */
    public int[] getSnackQty() {
        return snackQty;
    }

    /**
     * @param snackQty the snackQty to set
     */
    public void setSnackQty(int[] newSnackQty) {
        snackQty = newSnackQty;
    }
}
