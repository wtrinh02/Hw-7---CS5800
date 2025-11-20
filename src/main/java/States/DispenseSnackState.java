package States;

import Classes.Snack;
import Classes.VendingMachine;

public class DispenseSnackState implements StateOfVendingMachine{
    @Override
    public void selectSnack(VendingMachine machine, String snackName) {
        System.out.println("Snack currently being dispensed");
    }

    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        System.out.println("Snack currently being dispensed");
    }

    @Override
    public void dispenseSnack(VendingMachine machine) {
        String selectedSnack = machine.getSelectedSnack();
        Snack snack = machine.findSnackInVendingMachine(selectedSnack);

        snack.reduceQuantity();
        System.out.println("Dispensing: " + snack.getName());
        machine.resetMoney();
        machine.setSelectedSnack(null);
        machine.setState(new IdleState());
    }
}
