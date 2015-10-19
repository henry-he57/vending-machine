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
public class Change {

    private String coinDescription;   //name of coin
    private double coinValue; //value of coin
    private int change;  //amount of coin type in machine
    private int userChange;  //amount of coin type inserted by user

    //create constructor to set Change properties
    public Change(String newDescription, double newValue, int newChange) {
        coinDescription = newDescription;
        coinValue = newValue;
        change = newChange;
        userChange = 0;
    }

    /**
     * Sets the amount of coin the user has inserted
     * 
     * @param qty Amount of coin
     */
    public void setUserCoin(int qty) {
        userChange = qty;
    }
    
    /**
     * Adds specified number of coins to machine storage
     * 
     * @param qty The amount of coins to add to the machine
     */
    public void add(int qty) {
        change += qty;
    }
    
    /*
     * 
     * @param c
     * @return 
     */
    public double add(Change c) {
        double changeValue = 0;
        changeValue += c.coinValue * c.userChange;
        
        return changeValue;
    }

    public void add() {
       change++;
    }

    

    public void empty(Change c) {
        c.change = 0;
    }

    public void remove(int qty) {
        change -= qty;
    }
    
    public void remove(double amt){
        
    }
    public double getCoinValue(){
        return coinValue;
    }
    public String getCoinDescription(){
        return coinDescription;
    }
    
    public void stockChange(Change c, int qty){
        c.change += qty;
    }
    public void setUserChange (int qty){
        this.userChange = qty;
    }
    public int getUserChange (){
        return userChange;
    }

    /**
     * @return the change
     */
    public int getChange() {
        return change;
    }
}
