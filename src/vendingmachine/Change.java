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

    //create constructor to set Change properties (Author: Henry)
    public Change(String newDescription, double newValue, int newChange) {
        coinDescription = newDescription;
        coinValue = newValue;
        change = newChange;
        userChange = 0;
    }

    /**
     * Author: Henry
     * Sets the amount of coin the user has inserted
     * 
     * @param qty Amount of coin
     */
    public void setUserCoin(int qty) {
        userChange = qty;
    }
    
    /**
     * Author: Henry
     * Adds specified number of coins to machine storage
     * 
     * @param qty The amount of coins to add to the machine
     */
    public void add(int qty) {
        change += qty;
    }

    /**
     * Author: Adam
     * Calculates total value of user inserted change for one coin
     * 
     * @param change The coin object to calculate balance for
     * @return The total value of the specific coin object inserted by user           
     */
    public double add(Change change) {
        double changeValue = 0;
        changeValue += change.coinValue * change.userChange;
        return changeValue;
    }

    /**
     * Author: Henry
     * Empties a specific change object from the machine
     * 
     * @param c The change object to empty
     */
    public void empty(Change c) {
        c.change = 0;
    }

    /**
     * Author: Henry
     * Removes a specified number of specific coin from machine
     * 
     * @param qty The amount of coins to remove from machine
     */
    public void remove(int qty) {
        change -= qty;
    }
    
    /**
     * 
     * @return the value of the coin
     */
    public double getCoinValue(){
        return coinValue;
    }
    
    /**
     * 
     * @return the name of the coin
     */
    public String getCoinDescription(){
        return coinDescription;
    }
    
    /**
     * Author: Henry
     * Refills change object in machine
     * 
     * @param c The change object to stock
     * @param qty The amount of coins to add to machine storage
     */
    public void stockChange(Change c, int qty){
        c.change += qty;
    }

    /**
     * @return the change
     */
    public int getChange() {
        return change;
    }
}
