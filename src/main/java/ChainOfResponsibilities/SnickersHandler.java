package ChainOfResponsibilities;

import Classes.Snack;
import Classes.VendingMachine;

public class SnickersHandler extends SnackDispenseHandler{
    public SnickersHandler(SnackDispenseHandler next) {
        super(next);
    }
    public Snack handleDispense(String snackName, VendingMachine machine){
        if(snackName.equals("snickers")){
            return machine.getSnackInVendingMachine(snackName);
        }
        return next.handleDispense(snackName,machine);
    }
}
