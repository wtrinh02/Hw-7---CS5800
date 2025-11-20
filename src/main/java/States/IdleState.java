package States;

import Classes.VendingMachine;

public class IdleState implements StateOfVendingMachine{
    @Override
    public void selectSnack(VendingMachine machine, String snackName) {
        System.out.println("Snack selected: " + snackName);
        machine.setSelectedSnack(snackName);
        machine.setState(new WaitingForMoneyState());
    }

    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        System.out.println("Select Snack First!");
    }

    @Override
    public void dispenseSnack(VendingMachine machine) {
        System.out.println("Select Snack First!");
    }

}
