/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

/**
 *
 * @author Adam
 */
public class Snack {

    private String name;
    private Double price;
    private int qty;

    public Snack(String newName, double newPrice, int startQty) {
        name = newName;
        price = newPrice;
        qty = startQty;
    }

    /**
     * increases the quantity of snack by the amount specified
     *
     * @param a the quantity added
     */
    public void snackRestock(int a) {
        setQty(+a);
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
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }
    
    /**
     * 
     * @param name Snack that has its qty being decreased by 1
     */
    public void snackPurchased(Snack name){
        name.qty --;
    }
}
