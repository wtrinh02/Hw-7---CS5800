import ChainOfResponsibilities.CokeHandler;
import Classes.Snack;
import Classes.VendingMachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CokeHandlerTests {


    private VendingMachine machine;
    private Snack snack;
    private CokeHandler handler;

    @BeforeEach
    public void setUp() {
        machine = new VendingMachine();
        snack = new Snack("coke", 1.5, 2);
        machine.addSnack(snack);
        handler = new CokeHandler(null);
    }

    @Test
    public void testHandleDispense() {
        Snack actual = handler.handleDispense("coke", machine);
        assertEquals(snack, actual);
    }

}
