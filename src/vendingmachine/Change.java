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
    private int change;  //amount of coin type in machine]
    private int userChange;  //amount of coin type inserted by user

    public Change() {

    }

    public Change(String newDescription, double newValue, int newChange) {
        coinDescription = newDescription;
        coinValue = newValue;
        change = newChange;
    }

    public double add() {
        double changeValue = 0;      
        System.out.println(coinValue);
        System.out.println(userChange);
        changeValue += coinValue * userChange;
        return changeValue;
    }

    public void addUserCoin(int type, int qty) {
        userChange = qty;
        System.out.println(userChange);
    }

    public void add(int type) {
        changeInfo[].change;
    }

    public void add(int type, int qty) {
        change += qty;
    }

    public void empty() {
        for (int count = 0; count < 5; count++) {
            change = 0;
        }
    }

    public void remove(int type, int qty) {
        change -= qty;
    }

}
