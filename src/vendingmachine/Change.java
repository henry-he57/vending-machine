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
    
    public Change(int newNickel, int newDime, int newQuarter, int newLoonie, int newToonie){
        nickel = newNickel;
        dime = newDime;
        quarter = newQuarter;
        loonie = newLoonie;
        toonie = newToonie;
    }
    
    public double Add(){
        
    }
}
