/*
 * Class: CMSC203 
 * Instructor: Dr. Grinberg
 * Description: Organizer for properties. 
 * Due: 04/01/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Guerlain Darisme
*/

public class ManagementCompany {
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;
    
    private String name;
    private String taxID;
    private double mgmFee;
    private Plot plot;
    private Property[] properties;
    private int propertiesCount = 0;

    public ManagementCompany() {
        this("", "", 0, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    public ManagementCompany(String name, String taxID, double mgmFee) {
        this(name, taxID, mgmFee, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
    }

    public ManagementCompany(ManagementCompany otherCompany) {
        this(otherCompany.name, otherCompany.taxID, otherCompany.mgmFee,
             otherCompany.plot.getX(), otherCompany.plot.getY(),
             otherCompany.plot.getWidth(), otherCompany.plot.getDepth());
        this.properties = new Property[MAX_PROPERTY];
        for (int i = 0; i < otherCompany.propertiesCount; i++) {
            this.properties[i] = new Property(otherCompany.properties[i]);
        }
        this.propertiesCount = otherCompany.propertiesCount;
    }

    
    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

   
    public int addProperty(String name, String city, double rent, String owner) {
        return addProperty(new Property(name, city, rent, owner));
    }

    public int addProperty(Property property) {
        if (propertiesCount >= MAX_PROPERTY) {
            return -1; 
        }
        if (property == null) {
            return -2; 
        }
        if (!plot.encompasses(property.getPlot())) {
            return -3; 
        }
        for (int i = 0; i < propertiesCount; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) {
                return -4; // Overlaps another property
            }
        }
        properties[propertiesCount++] = new Property(property);
        return propertiesCount - 1;
    }

    public double getTotalRent() {
        double total = 0;
        for (int i = 0; i < propertiesCount; i++) {
            total += properties[i].getRentAmount();
        }
        return total;
    }

    public Property getHighestRentPropperty() {
        Property highestRentProperty = null;
        double highestRent = 0;
        for (int i = 0; i < propertiesCount; i++) {
            if (properties[i].getRentAmount() > highestRent) {
                highestRent = properties[i].getRentAmount();
                highestRentProperty = properties[i];
            }
        }
        return highestRentProperty;
    }

    
    public String getName() { return name; }
    public String getTaxID() { return taxID; }
    public double getMgmFeePer() { return mgmFee; }
    public Plot getPlot() { return plot; }
    public int getPropertiesCount() { return propertiesCount; }
    public Property[] getProperties() { return properties; }

    public boolean isMangementFeeValid() {
        return mgmFee >= 0 && mgmFee <= 100;
    }

    public boolean isPropertiesFull() {
        return propertiesCount >= MAX_PROPERTY;
    }

    public void removeLastProperty() {
        if (propertiesCount > 0) {
            properties[--propertiesCount] = null;
        }
    }


    public String toString() {
        StringBuilder sb = new StringBuilder("List of the properties for " + name + ", taxID: " + taxID + "\n");
        sb.append("______________________________________________________\n");
        for (int i = 0; i < propertiesCount; i++) {
            sb.append(properties[i].toString()).append("\n");
        }
        sb.append("______________________________________________________\n\n");
        double totalRent = getTotalRent();
        double totalManagementFee = totalRent * (mgmFee / 100);
        sb.append(" total management Fee: ").append(String.format("%.2f", totalManagementFee));
        return sb.toString();
    }

}
