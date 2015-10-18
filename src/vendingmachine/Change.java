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

    //create constructor
    public Change(String newDescription, double newValue, int newChange) {
        coinDescription = newDescription;
        coinValue = newValue;
        change = newChange;
        userChange = 0;
    }

    public double add(Change c) {
        double changeValue = 0;
        changeValue += c.coinValue * c.userChange;
        
        return changeValue;
    }

    public void addUserCoin(int qty) {
        userChange = qty;
    }

    public void add() {
       change++;
    }

    public void add(int qty) {
        change += qty;
    }

    public void empty(Change c) {
        c.change = 0;
    }

    public void remove(int qty) {
        userChange -= qty;
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
