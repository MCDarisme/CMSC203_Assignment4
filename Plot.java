/*
 * Class: CMSC203 
 * Instructor: Dr. Grinberg
 * Description: Keeps track of the size and location.
 * Due: 04/01/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Guerlain Darisme
*/

public class Plot {
    private int x;
    private int y;
    private int width;
    private int depth;


    public Plot() {
        this(0, 0, 1, 1);
    }


    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }


    public Plot(Plot otherPlot) {
        this(otherPlot.x, otherPlot.y, otherPlot.width, otherPlot.depth);
    }


    public boolean overlaps(Plot plot) {
        return x < plot.x + plot.width && x + width > plot.x &&
            y < plot.y + plot.depth && y + depth > plot.y;
    }


    public boolean encompasses(Plot plot) {
        return x <= plot.x && y <= plot.y &&
            (x + width) >= (plot.x + plot.width) &&
            (y + depth) >= (plot.y + plot.depth);
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getWidth() {
        return width;
    }
    public int getDepth() {
        return depth;
    }

    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}