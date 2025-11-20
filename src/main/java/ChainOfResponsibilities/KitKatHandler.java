package ChainOfResponsibilities;

import Classes.Snack;
import Classes.VendingMachine;

public class KitKatHandler extends SnackDispenseHandler{
    public KitKatHandler(SnackDispenseHandler next) {
        super(next);
    }
    public Snack handleDispense(String snackName, VendingMachine machine){
        if(snackName.equals("kitkat")){
            return machine.getSnackInVendingMachine(snackName);
        }
        return next.handleDispense(snackName,machine);
    }
}
