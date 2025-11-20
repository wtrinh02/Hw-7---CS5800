package ChainOfResponsibilities;

import Classes.Snack;
import Classes.VendingMachine;

public class PepsiHandler extends SnackDispenseHandler {
    public PepsiHandler(SnackDispenseHandler next) {
        super(next);
    }
    public Snack handleDispense(String snackName, VendingMachine machine){
        if(snackName.equals("pepsi")){
            return machine.getSnackInVendingMachine(snackName);
        }
        return next.handleDispense(snackName,machine);
    }
}
