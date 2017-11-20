/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longpipe;

/**
 *
 * @author up769598
 */
public class PipeMain {

    private int type;
    private double length;
    private int plasticGrade;
    private double outerDiameter;
    private double plasticVolume;
    private boolean chemicalResistance;
    private int colour;

    public PipeMain() {

    }

    /**
     * Main constructor for the default Pipe
     *
     * @param p_length length specified by the user
     * @param p_outerDiameter width of the pipe specified by the user
     * @param plasgrd plastic grade specified by the user
     * @param chemResistance if the pipe is chemical resistant then the value
     * will be true
     *
     */
    public PipeMain(int in_type, double p_length, double p_outerDiameter, int plasgrd, boolean chemResistance) {
        length = p_length;
        outerDiameter = p_outerDiameter;
        plasticVolume = calculatePlasticVolume(p_outerDiameter, p_length);
        chemicalResistance = chemResistance;
        plasticGrade = plasgrd;
        type = in_type;
    }

    /**
     * Used to work out the plastic Volume of the pipe by subtracting the inner
     * diameter cylinder by the outer diameter cylinder
     *
     * @param outerDiameter the width of the pipe passed through by the
     * constructor
     * @param length the length of the pipe passed through by the constructor
     * @return the plastic volume of the pipe
     */
    protected double calculatePlasticVolume(double outerDiameter, double length) {
        double innerDiamater = outerDiameter * 0.9;
        double volume;
        volume = calculateCylinderVolume(outerDiameter, this.getLength()) - calculateCylinderVolume(innerDiamater, this.getLength());
        return volume;
    }

    /**
     * Calculates the volume of a cylinder
     *
     * @param diameter Diameter of the cylinder
     * @param length Length of the cylinder
     * @return returns the volume of the cylinder
     */
    protected double calculateCylinderVolume(double diameter, double length) {
        return Math.pow((diameter / 2) * Math.PI, 2) * length;
    }

    /**
     * Converts inches to meters
     *
     * @param inch the length in inches to be converted into inch
     * @return length in meters
     */
    protected double transferInchToMeters(double inch) {
        return inch * 0.0254;
    }

    /**
     * Converts Meters To Inch
     *
     * @param meters the meters value to be converted to inch
     * @return the converted meters value
     */
    protected double transferMetersToInch(double meters) {
        return meters * 39.37;
    }

    /**
     * gets the value of chemical resistance
     *
     * @return chemical resistance
     */
    public boolean getChemicalResistance() {
        return chemicalResistance;
    }

    /**
     * gets the value of plastic grade
     *
     * @return plastic grade
     */
    public int getPlasticGrade() {
        return plasticGrade;
    }

    /**
     * used to set the colour
     *
     * @param col the colour to be set to
     */
    public void setColour(int col) {
        colour = col;
    }

    /**
     * gets the value of plastic Volume
     *
     * @return plastic Volume
     */
    public double getPlasticVolume() {
        return plasticVolume;
    }

    /**
     * gets the value of plastic grade
     *
     * @return Width of the pipe
     */
    public double getDiameter() {
        return outerDiameter;
    }

    /**
     * gets the value of length of the pipe
     *
     * @return length of pipe
     */
    public double getLength() {
        return length;
    }

    /**
     * adds the price increase if the Chemical getPrice
     *
     * @return the price increase for chemical resistance
     */
    protected double getChemicalPrice() {
        if (this.getChemicalResistance()) {
            return 1.14;
        } else {
            return 1;
        }
    }

    /**
     * works out the cost of plastic per inch^3 Has an array that contains the
     * prices for the different types of plastic
     *
     * @return price of plastic
     */
    protected double costOfPlastic() {
        double[] costOfPlastic = {0.4, 0.6, 0.75, 0.8, 0.95};

        return costOfPlastic[this.getPlasticGrade() - 1];
    }

    /**
     * returns the total percentage increase of all different price modifiers
     *
     * @return price modifier
     */
    private double extraCosts() {
        return this.getChemicalPrice();
    }

    /**
     * works out the total price for the pipe
     *
     * @return pipe price
     */
    public double getPrice() {
        double price = this.costOfPlastic() * this.getPlasticVolume() * this.extraCosts(); 
        return price;
    }

    public int getType() {
        return type;
    }
}
