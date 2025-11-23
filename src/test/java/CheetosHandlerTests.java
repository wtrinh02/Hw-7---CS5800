import ChainOfResponsibilities.CheetosHandler;
import Classes.Snack;
import Classes.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheetosHandlerTests {
    private VendingMachine machine;
    private Snack snack;
    private CheetosHandler handler;

    @BeforeEach
    public void setUp() {
        machine = new VendingMachine();
        snack = new Snack("cheetos", 1.5, 2);
        machine.addSnack(snack);
        handler = new CheetosHandler(null);
    }

    @Test
    public void testHandleDispense() {
        Snack actual = handler.handleDispense("cheetos", machine);
        assertEquals(snack, actual);
    }
}
