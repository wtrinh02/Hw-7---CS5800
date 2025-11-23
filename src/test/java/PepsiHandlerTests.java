
import ChainOfResponsibilities.PepsiHandler;
import Classes.Snack;
import Classes.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PepsiHandlerTests {
    private VendingMachine machine;
    private Snack snack;
    private PepsiHandler handler;

    @BeforeEach
    public void setUp() {
        machine = new VendingMachine();
        snack = new Snack("pepsi", 1.5, 2);
        machine.addSnack(snack);
        handler = new PepsiHandler(null);
    }

    @Test
    public void testHandleDispense() {
        Snack actual = handler.handleDispense("pepsi", machine);
        assertEquals(snack, actual);
    }
}
