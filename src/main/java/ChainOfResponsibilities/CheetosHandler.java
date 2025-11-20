package ChainOfResponsibilities;

import Classes.Snack;
import Classes.VendingMachine;

public class CheetosHandler extends SnackDispenseHandler{
    public CheetosHandler(SnackDispenseHandler next) {
        super(next);
    }
    public Snack handleDispense(String snackName, VendingMachine machine){
        if(snackName.equals("cheetos")){
            return machine.getSnackInVendingMachine(snackName);
        }
        return next.handleDispense(snackName,machine);
    }
}
