/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longpipe;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 * @author up769598
 */
public abstract class Pipe {

    protected int type;
    protected double length;
    protected int plasticGrade;
    protected double outerDiameter;
    protected double plasticVolume;
    protected boolean chemicalResistance;

    public Pipe() {

    }

    /**
     * Main constructor for the default Pipe
     *
     * @param length length specified by the user
     * @param outerDiameter width of the pipe specified by the user
     * @param plasticGrade plastic grade specified by the user
     * @param chemicalResistance if the pipe is chemical resistant then the value
     * will be true
     *
     */
    public Pipe(double length, double outerDiameter, int plasticGrade, boolean chemicalResistance) {
        this.length = this.convertToInches(length);
        this.outerDiameter = outerDiameter;
        this.plasticGrade = plasticGrade;
        this.chemicalResistance = chemicalResistance;
        this.plasticVolume = this.getVolume();
    }
    
    /**
     * Calculates the plastic volume of the pipe by subtracting the inner
     * diameter cylinder by the outer diameter cylinder
     *
     * @param outerDiameter the width of the pipe passed through by the
     * constructor
     * @param length the length of the pipe passed through by the constructor
     * @return the plastic volume of the pipe
     */
    protected double getVolume() {
        double innerDiamater = this.getDiameter() * 0.9;
        double volume;
        volume = this.calculateCylinderVolume(this.getDiameter(), this.getLength()) - this.calculateCylinderVolume(innerDiamater, this.getLength());
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
        return Math.pow((diameter / 2), 2) * Math.PI * length;
    }

    /**
     * Converts inches to meters
     *
     * @param inch the length in inches to be converted into inch
     * @return length in meters
     */
    protected double convertToMeters(double inch) {
        return inch * 0.0254;
    }

    /**
     * Converts Meters To Inch
     *
     * @param meters the meters value to be converted to inch
     * @return the converted meters value
     */
    protected double convertToInches(double meters) {
        return meters * 39.37;
    }
    
    /**
     * Returns the type number of pipe
     * @return 
     */
    public int getType() {
        return this.type;
    }
    
    /**
     * Gets the value of chemical resistance
     *
     * @return chemical resistance
     */
    public boolean getChemicalResistance() {
        return this.chemicalResistance;
    }

    /**
     * Gets the value of plastic grade
     *
     * @return plastic grade
     */
    public int getPlasticGrade() {
        return this.plasticGrade;
    }

    /**
     * Gets the value of plastic Volume
     *
     * @return plastic Volume
     */
    public double getPlasticVolume() {
        return this.plasticVolume;
    }

    /**
     * Gets the value of plastic grade
     *
     * @return width of the pipe
     */
    public double getDiameter() {
        return this.outerDiameter;
    }

    /**
     * Gets the value of length of the pipe
     *
     * @return length of pipe
     */
    public double getLength() {
        return this.length;
    }

    /**
     * Adds the price increase if pipe includes chemical resistance.
     *
     * @return price increase for chemical resistance
     */
    protected double getChemicalPrice() {
        if (this.getChemicalResistance()) {
            return 1.14;
        } else {
            return 1;
        }
    }

    /**
     * Works out the cost of plastic per cubic inch. Has an array that contains the
     * prices for the different types of plastic
     *
     * @return price of plastic
     */
    protected double costOfPlastic() {
        double[] costOfPlastic = {0.4, 0.6, 0.75, 0.8, 0.95};
        return costOfPlastic[this.getPlasticGrade() - 1];
    }

    /**
     * Works out the total price for the pipe
     *
     * @return pipe price
     */
    public double getPrice() {
        String stringPrice;
        double price;
        
        //Price formatter
        DecimalFormat decimal;
        decimal = new DecimalFormat("#.##");         //Format to two decimal places.
        decimal.setRoundingMode(RoundingMode.FLOOR); //Do not round the numbers UP or DOWN
        
        price = this.costOfPlastic() * this.getPlasticVolume() * this.extraCosts();
        
        stringPrice = decimal.format(price);         //format method returns the price in a string type.
        price = Double.parseDouble(stringPrice);     //convert the price from string to double before returning.
        
        return price;
    }
    
    /**
     * returns the total percentage increase of all different price modifiers
     *
     * @return price modifier
     */
    protected abstract double extraCosts();
}
