package States;

import Classes.Snack;
import Classes.VendingMachine;

public class WaitingForMoneyState implements StateOfVendingMachine {
    @Override
    public void selectSnack(VendingMachine machine, String snackName) {
        System.out.println("Snack Already Chosen! Insert Money!");
    }

    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        machine.addMoney(amount);
        System.out.println("Inserted: $" + amount);

        String selectedSnack = machine.getSelectedSnack();
        Snack snack = machine.findSnackInVendingMachine(selectedSnack);

        if (snack == null) {
            System.out.println("Snack Not Found!");
            machine.refund();
            return;
        }

        if(snack.getQuantity() <= 0) {
            System.out.println(snack.getName() + " Out of Stock!");
            machine.refund();
            machine.setState(new IdleState());
            return;
        }

        if(machine.getAmountInserted() >= snack.getPrice()) {
            machine.setState(new DispenseSnackState());
            machine.dispenseSnack();
        }
        else{
            System.out.println("Not enough money!");
        }
    }

    @Override
    public void dispenseSnack(VendingMachine machine) {
        System.out.println("Insert Required Money First!");
    }
}
