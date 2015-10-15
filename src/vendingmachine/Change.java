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
public class Change {

    private String coinDescription;   //name of coin
    private double coinValue; //value of coin
    private int change;  //amount of coin type in machine
    private int userChange;  //amount of coin type inserted by user

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

    public void empty() {
        change = 0;
    }

    public void remove(int qty) {
        userChange -= qty;
    }
    
    public void remove(double amt){
        
    }
    
    public String toString(){
        String description = coinDescription;
        return description;
    }
    
    public void stockChange(Change c, int qty){
        c.change += qty;
    }
}
