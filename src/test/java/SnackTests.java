
import Classes.Snack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnackTests {

   private Snack snack;
    @BeforeEach
    public void setUp()
    {
        snack = new Snack("coke", 1.5,2);
    }


    @Test
    public void testGetName(){
        String actual = snack.getName();
        String expected = "coke";
        assertEquals(expected,actual);
    }
    @Test
    public void testGetPrice(){
        double actual = snack.getPrice();
        double expected = 1.5;
        assertEquals(expected,actual);
    }
    @Test
    public void testGetQuantity(){
        int actual = snack.getQuantity();
        int expected = 2;
        assertEquals(expected,actual);
    }

    @Test
    public void testReduceQuantity(){
        snack.reduceQuantity();
        int actual = snack.getQuantity();
        int expected = 1;
        assertEquals(expected,actual);
    }

}
