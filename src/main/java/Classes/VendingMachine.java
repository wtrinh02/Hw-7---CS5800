package Classes;
import States.*;
import ChainOfResponsibilities.*;

import javax.swing.plaf.nimbus.State;
import java.util.HashMap;

public class VendingMachine {

    private StateOfVendingMachine state = new IdleState();
    private double amountInserted;
    private String selectedSnack;

    private SnackDispenseHandler chain;

    private HashMap<String, Snack> snacksInVendingMachine = new HashMap<>();

    public VendingMachine() {
        amountInserted = 0;

        chain = new CokeHandler(new PepsiHandler(new CheetosHandler(new DoritosHandler(new KitKatHandler(new SnickersHandler(null)))))) ;

    }

    public void addSnack(Snack snack) {
        snacksInVendingMachine.put(snack.getName(), snack);
    }

    public Snack getSnackInVendingMachine(String snackName) {
        return snacksInVendingMachine.get(snackName);
    }

    public Snack findSnackInVendingMachine(String snackName) {
        return chain.handleDispense(snackName, this);
    }

    public void addMoney(double amount){
        amountInserted += amount;
    }

    public double getAmountInserted(){
        return amountInserted;
    }

    public void refund(){
        System.out.println("Refunding Money!");
        resetMoney();
    }

    public void resetMoney(){
        amountInserted = 0;
    }

    public String getSelectedSnack(){
        return selectedSnack;
    }
    public void setSelectedSnack(String selectedSnack){
        this.selectedSnack = selectedSnack;
    }

    public void setState(StateOfVendingMachine newState){
        state = newState;
    }

    public void selectSnack(String snackName){
       state.selectSnack(this,snackName);
    }

    public void insertMoney(double amount){
        state.insertMoney(this,amount);
    }

    public void dispenseSnack(){
        state.dispenseSnack(this);
    }
    public StateOfVendingMachine getState(){
        return state;
    }

}
