
import ChainOfResponsibilities.SnickersHandler;
import Classes.Snack;
import Classes.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnickersHandlerTests {
    private VendingMachine machine;
    private Snack snack;
    private SnickersHandler handler;

    @BeforeEach
    public void setUp() {
        machine = new VendingMachine();
        snack = new Snack("snickers", 1.5, 2);
        machine.addSnack(snack);
        handler = new SnickersHandler(null);
    }

    @Test
    public void testHandleDispense() {
        Snack actual = handler.handleDispense("snickers", machine);
        assertEquals(snack, actual);
    }
}
