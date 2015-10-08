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
    private Snack[] name = new Snack[10];
    Display disp = new Display();

    public VendingMachine(double m) {
        moneyIn = m;
    }

    public void insertMoney() {
    moneyIn = disp.promptInsert();
    }

    public void addNewSnack(int i, Snack s){
        name[i] = s;
    }
    
    public void displaySnacks(){
        for (int count = 0; count <10; count++){
            disp.displaySnack(name[count]);
        }
    }
    
    /**
     * declares all the snacks and sets them all to a spot in the 'name' array
     * @param vm    the vending machine that the snacks are all in
     */
    public static void loadStartingSnacks(VendingMachine m){
        Snack lays = new Snack("Lays", 2.00, 5);
        m.addNewSnack(0, lays);
        Snack doritos = new Snack("Doritos - Sweet Chili Heat", 2.00, 5);
        m.addNewSnack(1, doritos);
        Snack ruffles = new Snack("Ruffles All Dressed", 2.00, 5);
        m.addNewSnack(2, ruffles);
        Snack marsBar = new Snack("Mars Bar", 1.50, 5);
        m.addNewSnack(3, marsBar);
        Snack coffeeCrisp = new Snack("Coffee Crisp", 1.50, 5);
        m.addNewSnack(4, coffeeCrisp);
        Snack hersheys = new Snack("Hershey's Chocolate", 1.50, 5);
        m.addNewSnack(5, hersheys);
        Snack mentos = new Snack("Mentos", 2.00, 5);
        m.addNewSnack(6, mentos);
        Snack twizzlers = new Snack("Twizzlers", 1.50, 5);
        m.addNewSnack(7, twizzlers);
        Snack fuzzyPeaches = new Snack("Fuzzy Peaches", 2.50, 5);
        m.addNewSnack(8, fuzzyPeaches);
        Snack nerds = new Snack("Nerds", 3.00, 5);
        m.addNewSnack(9, nerds);
    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine(20.00);
        loadStartingSnacks(vm);
        vm.displaySnacks();
        vm.insertMoney();
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
}
