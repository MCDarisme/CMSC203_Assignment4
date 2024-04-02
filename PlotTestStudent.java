import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlotTestStudent {

    private Plot plot;

    @Before
    public void setUp() {
        plot = new Plot(1, 2, 5, 5);
    }

    @Test
    public void testOverlaps() {
        Plot testsPlot = new Plot(3, 4, 5, 5);
        assertTrue("Plots should overlap", plot.overlaps(testsPlot));
    }

    @Test
    public void testEncompasses() {
        Plot tests2Plot = new Plot(2, 3, 2, 2);
        assertTrue("Plot should surround the smaller one", plot.encompasses(tests2Plot));
    }
}