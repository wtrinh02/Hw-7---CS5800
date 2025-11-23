
import ChainOfResponsibilities.DoritosHandler;
import Classes.Snack;
import Classes.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoritosHandlerTests {
    private VendingMachine machine;
    private Snack snack;
    private DoritosHandler handler;

    @BeforeEach
    public void setUp() {
        machine = new VendingMachine();
        snack = new Snack("doritos", 1.5, 2);
        machine.addSnack(snack);
        handler = new DoritosHandler(null);
    }

    @Test
    public void testHandleDispense() {
        Snack actual = handler.handleDispense("doritos", machine);
        assertEquals(snack, actual);
    }
}
