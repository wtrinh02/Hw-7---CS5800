import ChainOfResponsibilities.*;
import Classes.*;
import States.*;

public class Driver {

    public static void main(String[] args) {

        VendingMachine machine = new VendingMachine();

        machine.addSnack(new Snack("coke",1.25,6));
        machine.addSnack(new Snack("pepsi",1.25,5));
        machine.addSnack(new Snack("cheetos",1.50,4));
        machine.addSnack(new Snack("doritos",1.50,3));
        machine.addSnack(new Snack("kitkat",1.00,2));
        machine.addSnack(new Snack("snickers",1.00,1));

        machine.insertMoney(5.00);

        machine.selectSnack("snickers");
        machine.insertMoney(.50);
        machine.insertMoney(.50);

        machine.selectSnack("snickers");
        machine.insertMoney(1.00);

        machine.selectSnack("kitkat");
        machine.insertMoney(1.00);

        machine.selectSnack("doritos");
        machine.insertMoney(1.50);

        machine.selectSnack("cheetos");
        machine.insertMoney(1.50);

        machine.selectSnack("pepsi");
        machine.insertMoney(1.25);

        machine.selectSnack("coke");
        machine.insertMoney(1.25);


    }
}
