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

    private String[] coinDescription = new String[5];   //name of coin
    private double[] coinValue = new double[5]; //value of coin
    private int[] change = new int[5];  //amount of coin type in machine

    public Change(int newArrayValue, String newDescription, double newValue, int newChange) {
        coinDescription[newArrayValue] = newDescription;
        coinValue[newArrayValue] = newValue;
        change[newArrayValue] = newChange;
    }

    public double add() {
        
    }
    
    public void addCoinType(int type, int amount){
        change[0]+= toonieAmount;
    }
    
    public void add(int type){
        change[type]++;
    }
    
    public void add(int type, int qty){
        change[type] += qty;
    }

    public void empty() {
        for (int count = 0; count < 5; count++) {
            change[count] = 0;
        }
    }
    
    public void remove(int type, int qty){
        change[type] -= qty;
    }
    
    
    
    
}
