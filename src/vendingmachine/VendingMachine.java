//Assume the user provides correct input when asked

//NOTE: Press 10 to access maintenance menu

package vendingmachine;

/**
 *
 * @author Adam Morrison and Henry He
 */
public class VendingMachine {

    private double moneyIn; //amount of money input by user
    private Snack[] snackInfo = new Snack[10];  //array for snack objects
    Display disp = new Display();   //display of vending machine

    /**
     * Author: Adam
     * Calls method in display to load assets such as snacks and coins into
     * vending machine
     *
     * @param vm The vending machine to load the snacks and coins into
     */
    public void loadAssets(VendingMachine vm) {
        disp.loadStartingSnacks(vm);
        disp.loadCoins();
    }

    /**
     * Author: Adam
     * Puts given snack into snack object array
     *
     * @param arrayLocation Location of snack object in array
     * @param snack The snack object to put into array
     */
    public void addNewSnack(int arrayLocation, Snack snack) {
        snackInfo[arrayLocation] = snack;
    }

    /**
     * Author: Adam and Henry
     * Displays all available snacks in machine
     */
    public void displaySnacks() {
        for (int count = 0; count < 10; count++) {
            disp.displaySnack(snackInfo[count], count, moneyIn);
        }
    }

    /**
     * Author: Adam
     * Calls display method to ask user for money insertion
     */
    public void insertMoney() {
        moneyIn = disp.promptInsert(moneyIn);
    }

    /**
     * Author: Adam
     * Calls display method to receive snack selection and either buy snack or
     * open maintenance menu
     */
    public boolean getSelection() {
        int snackSelection = disp.promptSelection(snackInfo);
        boolean shutdown = false;
        if (snackSelection != 10) {
            boolean enoughMoney = snackInfo[snackSelection].snackPurchased(snackInfo[snackSelection], moneyIn);

            //subtract cost of snack from user balance if user has enough to buy the snack
            if (enoughMoney == true) {
                moneyIn -= snackInfo[snackSelection].getPrice();
            }

        } else {
            shutdown = disp.maintenance(snackInfo);    //display the maintenance menu
            return shutdown;
        }
        return shutdown;
    }

    /**
     * Author: Henry
     * Returns unused money back to user
     */
    public void returnMoney() {
        disp.returnMoney(moneyIn);
        moneyIn = 0;    //reset balance to zero for next user
    }

    /**
     * Author: Adam
     * Asks user if they are finished using the vending machine
     *
     * @return if they are finished
     */
    public boolean isThatAll() {
        boolean isThatAll = disp.isThatAll();
        return isThatAll;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();   //create new vending machine
        boolean shutdown;   //when true shuts down machine
        vm.loadAssets(vm);  //load snack and coin objects into vending machine vm

        do {
            do {
                vm.displaySnacks(); //show user all snacks available for purchase
                vm.insertMoney();   //prompt user to insert money 
                shutdown = vm.getSelection();  //get user snack selection
            } while (vm.isThatAll() == false);  //exit when current user has finished using machine
            vm.returnMoney();   //return remaining balance to user
        } while (shutdown == false);    //shut down machine when specified by user
    }
}
