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
    private String[] coinDescription = new String[5];
    private double[] coinValue = new double[5];
    private int[] change = new int[5];
    
    public Change(int newArrayValue, String newDescription, double newValue, int newChange){
        coinDescription[newArrayValue] = newDescription;
        coinValue[newArrayValue] = newValue;
        change[newArrayValue] = newChange;
    }
    
    public double add(){
        double changeValue = 0;
        for (int count = 0; count < 5; count ++){
        changeValue = changeValue + coinValue[count] * change[count];
        }
        return changeValue;
    }
}
