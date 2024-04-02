import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ManagementCompanyTestStudent {

    private ManagementCompany mgmtCo;

    @Before
    public void setUp() {
        mgmtCo = new ManagementCompany("Bank of Maryland", "123-777777", 6);
    }

    @Test
    public void tesAtdd() {
        Property p1 = new Property("Golf Course", "Maryland", 800, "Guerlain Darisme");
        assertEquals("First property should be added at index 0", 0, mgmtCo.addProperty(p1));
    }

    @Test
    public void testRent() {
        mgmtCo.addProperty(new Property("Golf Course", "Maryland", 800, "Guerlain Darisme"));
        mgmtCo.addProperty(new Property("Mountain Resort", "Maryland", 800, "Mary Jane"));
    }
}