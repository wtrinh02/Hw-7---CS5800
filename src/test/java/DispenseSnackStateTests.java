import Classes.Snack;
import Classes.VendingMachine;
import States.DispenseSnackState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DispenseSnackStateTests {

    private VendingMachine machine;
    private Snack snack;
    private DispenseSnackState state;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    @BeforeEach
    public void setUp()
    {
        machine = new VendingMachine();
        snack = new Snack("coke",1.5,1);
        machine.addSnack(snack);
        state = new DispenseSnackState();
    }

    @Test
    public void testSelectSnack(){
        System.setOut(new PrintStream(outContent));
        state.selectSnack(machine,"coke");
        String actual = outContent.toString();
        String expected = "Snack currently being dispensed\r\n";
        assertEquals(expected,actual);
    }
    @Test
    public void testInsertMoney(){
        System.setOut(new PrintStream(outContent));
        state.insertMoney(machine,1.5);
        String actual = outContent.toString();
        String expected = "Snack currently being dispensed\r\n";
        assertEquals(expected,actual);
    }

    @Test
    public void testDispenseSnack(){
        machine.setSelectedSnack("coke");
        System.setOut(new PrintStream(outContent));
        state.dispenseSnack(machine);
        String actual = outContent.toString();
        String expected = "Dispensing: coke\r\n";
        assertEquals(expected,actual);
    }
}
