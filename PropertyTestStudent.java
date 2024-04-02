import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PropertyTestStudent {

    private Property property;

    @Before
    public void setUp() {
        property = new Property("Golf Course", "Maryland", 800, "Guerlain Darisme", 1, 2, 5, 5);
    }

    @Test
    public void testRentAmount() {
        assertEquals("Rent is supposed to be 1200", 800, property.getRentAmount(), 0.0);
    }

    @Test
    public void testPropertyName() {
        assertEquals("Property name should be 'Golf Course'", "Golf Course", property.getPropertyName());
    }
}
