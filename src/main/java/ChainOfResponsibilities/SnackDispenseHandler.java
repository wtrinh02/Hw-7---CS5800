package ChainOfResponsibilities;

import Classes.Snack;
import Classes.VendingMachine;

public abstract class SnackDispenseHandler {
    protected SnackDispenseHandler next;
    public SnackDispenseHandler(SnackDispenseHandler next) {
        this.next = next;
    }
    public Snack handleDispense(String snackName, VendingMachine machine){
        if(next != null){
            return next.handleDispense(snackName,machine);
        }
        return null;
    }
}
