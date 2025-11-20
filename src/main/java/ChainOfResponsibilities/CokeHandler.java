package ChainOfResponsibilities;

import Classes.Snack;
import Classes.VendingMachine;

public class CokeHandler extends SnackDispenseHandler {
    public CokeHandler(SnackDispenseHandler next) {
        super(next);
    }

    public Snack handleDispense(String snackName, VendingMachine machine){
        if(snackName.equals("coke")){
            return machine.getSnackInVendingMachine(snackName);
        }
        return next.handleDispense(snackName,machine);
    }
}
