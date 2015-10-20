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
public class Snack {

    private String name;    //name of snack
    private String snackDescription;     //descrition of snack
    private Double price;   //price of snack in machine
    private int qty;    //amount of snack in machine
    private double realPrice;   //cost of actual snack production
    private int snacksSold; //number of snacks sold in machine

    //create snack object constructor
    public Snack(String newName, String newSnackDescription, double newPrice, int startQty, double newRealPrice) {
        name = newName;
        snackDescription = newSnackDescription;
        price = newPrice;
        qty = startQty;
        realPrice = newRealPrice;
        snacksSold = 0;
    }

    /**
     * increases the quantity of snack by the amount specified
     *
     * @param a the quantity added
     */
    public void snackRestock(int a) {
        qty += a;
    }

    /**
     * Checks to see if user has enough money to buy the snack
     * 
     * @param snack The desired snack of user  
     * @param money Current user balance in machine
     * @return whether or not the user has enough money to buy the snack
     */
    public boolean snackPurchased(Snack snack, double money) {
        if (snack.price <= money) {
            snack.qty--;
            System.out.println("Enjoy your " + snack.name + "!");
            return true;
        } else {
            System.out.println("Not enough dolla dolla bills y'all.");
            return false;
        }
    }

    /**
     * @return the name of the snack
     */
    public String getName() {
        return name;
    }

    /**
     * @return the price of the snack
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @return the qty of snack in vending machine
     */
    public int getQty() {
        return qty;
    }

    /**
     * @return the factory production price of the snack
     */
    public Double getRealPrice() {
        return realPrice;
    }

    /**
     * @return the total amount of snacks sold
     */
    public int getSnacksSold() {
        return snacksSold;
    }

    /**
     * Increase the snack sold amount of a snack by one
     */
    public void increaseSnacksSold() {
        snacksSold++;
    }

    /**
     * @return the name of the snack
     */
    public String getSnackDescription() {
        return snackDescription;
    }
}
