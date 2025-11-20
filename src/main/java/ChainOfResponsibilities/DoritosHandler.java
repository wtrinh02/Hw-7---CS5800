package ChainOfResponsibilities;

import Classes.Snack;
import Classes.VendingMachine;

public class DoritosHandler extends SnackDispenseHandler{
    public DoritosHandler(SnackDispenseHandler next) {
        super(next);
    }
    public Snack handleDispense(String snackName, VendingMachine machine){
        if(snackName.equals("doritos")){
            return machine.getSnackInVendingMachine(snackName);
        }
        return next.handleDispense(snackName,machine);
    }
}
