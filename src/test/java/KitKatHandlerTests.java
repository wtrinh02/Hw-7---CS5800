
import ChainOfResponsibilities.KitKatHandler;
import Classes.Snack;
import Classes.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KitKatHandlerTests {
    private VendingMachine machine;
    private Snack snack;
    private KitKatHandler handler;

    @BeforeEach
    public void setUp() {
        machine = new VendingMachine();
        snack = new Snack("kitkat", 1.5, 2);
        machine.addSnack(snack);
        handler = new KitKatHandler(null);
    }

    @Test
    public void testHandleDispense() {
        Snack actual = handler.handleDispense("kitkat", machine);
        assertEquals(snack, actual);
    }
}
