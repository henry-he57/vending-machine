package vendingmachine;

/**
 *
 * @author Adam Morrison and Henry He
 */
public class Snack {

    private String name;    //name of snack
    private String snackDescription;     //description of snack
    private Double price;   //price of snack in machine
    private int qty;    //amount of snack in machine
    private double realPrice;   //cost of actual snack production
    private int snacksSold; //number of snacks sold in machine

    //create snack object constructor (Author: Henry)
    public Snack(String newName, String newSnackDescription, double newPrice, int startQty, double newRealPrice) {
        name = newName;
        snackDescription = newSnackDescription;
        price = newPrice;
        qty = startQty;
        realPrice = newRealPrice;
        snacksSold = 0;
    }

    /**
     * Author: Henry
     * Increases the quantity of snack by the amount specified
     *
     * @param a the quantity added
     */
    public void snackRestock(int a) {
        qty += a;
    }

    /**
     * Author: Henry
     * Checks to see if user has enough money to buy the snack and changes snack amount values accordingly
     * 
     * @param snack The desired snack of user  
     * @param money Current user balance in machine
     * @return if the user has enough money to buy the snack
     */
    public boolean snackPurchased(Snack snack, double money) {
        if (snack.price <= money) {
            
            //decrease snack amount by one and increase the snack sold amount by one
            snack.qty--;
            snack.snacksSold++;
            
            System.out.println("Enjoy your " + snack.name + "!");
            return true;
        } else {
            System.out.println("Not enough dolla dolla bills y'all.");
            return false;
        }
    }

    /**
     * @return the name of the snack
     */
    public String getName() {
        return name;
    }

    /**
     * @return the price of the snack
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @return the qty of snack in vending machine
     */
    public int getQty() {
        return qty;
    }

    /**
     * @return the factory production price of the snack
     */
    public Double getRealPrice() {
        return realPrice;
    }

    /**
     * @return the total amount of snacks sold
     */
    public int getSnacksSold() {
        return snacksSold;
    }

    /**
     * @return the name of the snack
     */
    public String getSnackDescription() {
        return snackDescription;
    }
}
