import Classes.Snack;
import Classes.VendingMachine;
import States.IdleState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IdleStateTests {

    private VendingMachine machine;
    private Snack snack;
    private IdleState state;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    @BeforeEach
    public void setUp()
    {
        machine = new VendingMachine();
        snack = new Snack("coke",1.5,1);
        machine.addSnack(snack);
        state = new IdleState();
    }

    @Test
    public void testSelectSnack(){
        state.selectSnack(machine,"coke");
        String expected = "coke";
        String actual = machine.getSelectedSnack();
        assertEquals(expected,actual);
    }
    @Test
    public void testInsertMoney(){
        System.setOut(new PrintStream(outContent));
        state.insertMoney(machine,1.5);
        String actual = outContent.toString();
        String expected = "Select Snack First!\r\n";
        assertEquals(expected,actual);
    }

    @Test
    public void testDispenseSnack(){
        System.setOut(new PrintStream(outContent));
        state.dispenseSnack(machine);
        String actual = outContent.toString();
        String expected = "Select Snack First!\r\n";
        assertEquals(expected,actual);
    }
}
