import Classes.Snack;
import Classes.VendingMachine;
import States.DispenseSnackState;
import States.IdleState;
import States.StateOfVendingMachine;
import States.WaitingForMoneyState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class WaitingForMoneyStateTests {
    private VendingMachine machine;
    private Snack snack;
    private WaitingForMoneyState state;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    @BeforeEach
    public void setUp()
    {
        machine = new VendingMachine();
        snack = new Snack("coke",1.5,1);
        machine.addSnack(snack);
        state = new WaitingForMoneyState();
    }

    @Test
    public void testSelectSnack()
    {
        System.setOut(new PrintStream(outContent));
        state.selectSnack(machine,"coke");
        String actual = outContent.toString();
        String expected = "Snack Already Chosen! Insert Money!\r\n";
        assertEquals(expected,actual);
    }

    @Test
    public void testInsertMoney(){
        machine.selectSnack("coke");
        machine.insertMoney(1.5);
        StateOfVendingMachine actual =  machine.getState();
        assertTrue(actual instanceof IdleState);

    }

    @Test
    public void testDispenseSnack()
    {
        System.setOut(new PrintStream(outContent));
        state.dispenseSnack(machine);
        String actual = outContent.toString();
        String expected = "Insert Required Money First!\r\n";
        assertEquals(expected,actual);
    }
}
