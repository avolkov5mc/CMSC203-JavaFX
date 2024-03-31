/*
Class: CMSC203 CRN 30339
Program: Assignment #4
Instructor: Grigoriy Grinberg
Summary of Description: Calculates and stores information about plots of land and properties.
Due Date: 4/1/2024
Integrity Pledge: I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
Alexei Volkov
*/

package CMSC203_Assignment4;

public class ManagementCompany {

    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_DEPTH = 10;
    public static final int MGMT_WIDTH = 10;

    private String name;
    private String taxID;
    private double mgmFee;

    private Plot plot;
    private Property[] properties;
    private int numberOfProperties;

    public ManagementCompany() {
        this.name = "";
        this.taxID = "";
        this.mgmFee = 1;
        this.plot = new Plot(0,0,MGMT_WIDTH, MGMT_DEPTH);
        properties = new Property[MAX_PROPERTY];
        numberOfProperties = 0;
    }

    public ManagementCompany(String name, String taxID, double mgmFee) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;

        if(!isManagementFeeValid()){
            this.mgmFee = 1;
        }

        this.plot = new Plot(0,0,MGMT_WIDTH, MGMT_DEPTH);
        properties = new Property[MAX_PROPERTY];
        numberOfProperties = 0;
    }

    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;

        if(!isManagementFeeValid()){
            this.mgmFee = 1;
        }

        plot = new Plot(x, y, width, depth);
        properties = new Property[MAX_PROPERTY];
        numberOfProperties = 0;
    }

    public ManagementCompany(ManagementCompany other){
        this.name = other.name;
        this.taxID = other.taxID;
        this.mgmFee = other.mgmFee;
        this.plot = new Plot(other.plot);
        this.properties = copyPropertiesArray(other.properties);
        numberOfProperties = other.numberOfProperties;
    }

    /**
     * Creates a copy of the Property, then calls helper method.
     * @return Index of the property, or an error code.
     */
    public int addProperty(String name, String city, double rent, String owner){
        return addPropertyHelper(new Property(name, city, rent, owner));
    }

    /**
     * Creates a copy of the Property, then calls helper method.
     * @return Index of the property, or an error code.
     */
    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth){
        return addPropertyHelper(new Property(name, city, rent, owner, x, y, width, depth));
    }

    /**
     * Creates a copy of the Property, then calls helper method.
     * @param property The new property.
     * @return Index of the property, or an error code.
     */
    public int addProperty(Property property){
        return addPropertyHelper(new Property(property));
    }

    /**
     * Performs checks to see if a new property can be added to the list of properties.
     * @param property Either a new property object, or a copy of an existing property object. Can be null.
     * @return Either the index of the property, or an error code.
     */
    private int addPropertyHelper(Property property){
        if(property == null){
            return -2;
        }
        if(isPropertiesFull()){
            return -1;
        }
        // if the property isn't fully contained w/in the company plot
        if(!plot.encompasses(property.getPlot())){
            return -3;
        }
        // ensure that the new property doesn't overlap any existing properties
        for(int i = 0; i < numberOfProperties; i++){
            if(property.getPlot().overlaps(properties[i].getPlot())){
                return -4;
            }
        }
        // at this point, successful operation - add the property and get the new index
        properties[numberOfProperties] = property;
        int index = numberOfProperties;
        // dont forget to increment number of properties
        numberOfProperties++;
        return index;
    }

    /**
     * Helper method, which uses the Property copy constructor to create a deep copy of an array of Properties.
     * @param props Array to copy.
     * @return A deep copy of the properties array.
     */
    private Property[] copyPropertiesArray(Property[] props){
        Property[] toReturn = new Property[MAX_PROPERTY];
        for(int i = 0; i < props.length; i++){
            toReturn[i] = new Property(props[i]);
        }
        return toReturn;
    }

    public Property getHighestRentProperty(){
        return properties[maxRentPropertyIndex()];
    }

    private int maxRentPropertyIndex(){
        int maxRentIndex = 0;
        for(int i = 1; i < numberOfProperties; i++){
            if(properties[i].getRentAmount() > properties[maxRentIndex].getRentAmount()){
                maxRentIndex = i;
            }
        }
        return maxRentIndex;
    }

    public double getTotalRent(){
        double sum = 0;
        for(int i = 0; i < numberOfProperties; i++){
            sum += properties[i].getRentAmount();
        }
        return sum;
    }

    public void removeLastProperty(){
        if(numberOfProperties > 0){
            properties[numberOfProperties-1] = null;
            numberOfProperties--;
        }
    }

    public String toString(){
        String build = "List of the properties for " + name + ", taxID: " + taxID;
        build += "\n______________________________________________________";
        for(int i = 0; i < numberOfProperties; i++){
            build += "\n" + properties[i].toString();
        }
        build += "\n______________________________________________________\n";
        build += "\n total management Fee: " + (getTotalRent() * 0.01) * getMgmFeePer();
        return build;
    }

    public boolean isPropertiesFull(){
        return numberOfProperties >= MAX_PROPERTY;
    }

    public int getPropertiesCount(){
        return numberOfProperties;
    }

    public boolean isManagementFeeValid(){
        return mgmFee >= 0 && mgmFee <= 100;
    }

    public String getName() {
        return name;
    }

    public String getTaxID() {
        return taxID;
    }

    public double getMgmFeePer() {
        return mgmFee;
    }

    public Plot getPlot() {
        return plot;
    }
}
