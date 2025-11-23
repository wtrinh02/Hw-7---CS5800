import Classes.Snack;
import Classes.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendingMachineTests {

    private Snack testSnack;
    private VendingMachine testVendingMachine;

    @BeforeEach
    public void setUp() {
        testSnack = new Snack("test", 1.0, 1);
        testVendingMachine = new VendingMachine();
    }

    @Test
    public void testAddSnack() {
        testVendingMachine.addSnack(testSnack);
        Snack actual = testVendingMachine.getSnackInVendingMachine(testSnack.getName());
        assertEquals(testSnack, actual);
    }

    @Test
    public void testGetSnackInVendingMachine() {
        testVendingMachine.addSnack(testSnack);
        Snack actual = testVendingMachine.getSnackInVendingMachine(testSnack.getName());
        assertEquals(testSnack, actual);
    }

    @Test
    public void testFindCokeInVendingMachine() {
        testSnack = new Snack("coke", 1.0, 1);
        testVendingMachine.addSnack(testSnack);
        Snack actual = testVendingMachine.findSnackInVendingMachine(testSnack.getName());
        assertEquals(testSnack, actual);

    }

    @Test
    public void testFindPepsiInVendingMachine() {
        testSnack = new Snack("pepsi", 1.0, 1);
        testVendingMachine.addSnack(testSnack);
        Snack actual = testVendingMachine.findSnackInVendingMachine(testSnack.getName());
        assertEquals(testSnack, actual);

    }

    @Test
    public void testFindDoritosInVendingMachine() {
        testSnack = new Snack("doritos", 1.0, 1);
        testVendingMachine.addSnack(testSnack);
        Snack actual = testVendingMachine.findSnackInVendingMachine(testSnack.getName());
        assertEquals(testSnack, actual);

    }

    @Test
    public void testFindCheetosInVendingMachine() {
        testSnack = new Snack("cheetos", 1.0, 1);
        testVendingMachine.addSnack(testSnack);
        Snack actual = testVendingMachine.findSnackInVendingMachine(testSnack.getName());
        assertEquals(testSnack, actual);

    }

    @Test
    public void testFindKitKatInVendingMachine() {
        testSnack = new Snack("kitkat", 1.0, 1);
        testVendingMachine.addSnack(testSnack);
        Snack actual = testVendingMachine.findSnackInVendingMachine(testSnack.getName());
        assertEquals(testSnack, actual);

    }

    @Test
    public void testFindSnickersInVendingMachine() {
        testSnack = new Snack("snickers", 1.0, 1);
        testVendingMachine.addSnack(testSnack);
        Snack actual = testVendingMachine.findSnackInVendingMachine(testSnack.getName());
        assertEquals(testSnack, actual);

    }

    @Test
    public void testGetAmountInserted() {
        double expected = 0;
        double actual = testVendingMachine.getAmountInserted();
        assertEquals(expected, actual);

    }

    @Test
    public void testaddAmount() {
        double expected = 1.5;
        testVendingMachine.addMoney(expected);
        double actual = testVendingMachine.getAmountInserted();
        assertEquals(expected, actual);

    }

    @Test
    public void testResetMoney() {
        double expected = 0;
        testVendingMachine.addMoney(1.5);
        testVendingMachine.resetMoney();
        double actual = testVendingMachine.getAmountInserted();
        assertEquals(expected, actual);

    }

    @Test
    public void testRefund() {
        double expected = 0;
        testVendingMachine.addMoney(1.5);
        testVendingMachine.refund();
        double actual = testVendingMachine.getAmountInserted();
        assertEquals(expected, actual);

    }

    @Test
    public void testGetSelectedSnack() {
        String actual = testVendingMachine.getSelectedSnack();
        assertEquals(null, actual);
    }

    @Test
    public void testSetSelectedSnack() {
        String expected = "coke";
        testVendingMachine.setSelectedSnack(expected);
        String actual = testVendingMachine.getSelectedSnack();
        assertEquals(expected, actual);
    }

    @Test
    public void testSelectSnack() {
        testSnack = new Snack("kitkat", 1.0, 1);
        testVendingMachine.addSnack(testSnack);
        testVendingMachine.selectSnack(testSnack.getName());
        String actual = testVendingMachine.getSelectedSnack();
        String expected = "kitkat";
        assertEquals(expected, actual);
    }

    @Test
    public void testInsertMoney() {
        testSnack =new Snack("kitkat",1.0,1);
        testVendingMachine.addSnack(testSnack);
        testVendingMachine.selectSnack(testSnack.getName());
        testVendingMachine.insertMoney(1.5);
        double actual = testVendingMachine.getAmountInserted();
        assertEquals(0, actual);
    }

    @Test
    public void testDispenseSnack(){
        testSnack =new Snack("kitkat",1.0,1);
        testVendingMachine.addSnack(testSnack);
        testVendingMachine.selectSnack(testSnack.getName());
        testVendingMachine.insertMoney(1.5);
        String actual = testVendingMachine.getSelectedSnack();
        String expected = null;
        assertEquals(expected, actual);
    }
}
