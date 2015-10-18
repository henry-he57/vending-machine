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
    public Snack(String newName, String newSnackDescription,double newPrice, int startQty, double newRealPrice) {
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }
    /**
     * @return the realPrice
     */
    public Double getRealPrice() {
        return realPrice;
    }
    /**
     * @param realPrice the realPrice to set
     */
    public void setRealPrice(double realPrice){
        this.realPrice = realPrice;
    }
    /**
     * @return the snacksSold
     */
    public int getSnacksSold() {
        return snacksSold;
    }
    /**
     * @param snacksSold the snacksSold to set
     */
    public void increaseSnacksSold(){
        this.snacksSold ++;
    }
    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }  
    
    public boolean snackPurchased(Snack name, double money){
        if (name.price <= money){
            name.qty --;
            System.out.println("Enjoy your " + name.name + "!");
            return true;
        }else {
            System.out.println("Not enough dolla dolla bills y'all.");
            return false;
        }
    }

    /**
     * @return the snackDescription
     */
    public String getSnackDescription() {
        return snackDescription;
    }
}
