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
public class Pipe1 extends Pipe {

    public Pipe1() {

    }

    /**
     * Constructor used to make a pipe of type 1
     *
     * @param length
     * @param outerDiameter
     * @param plasticGrade
     * @param chemicalResistance
     */
    public Pipe1(double length, double outerDiameter, int plasticGrade, boolean chemicalResistance) {
        super(length, outerDiameter, plasticGrade, chemicalResistance);
        this.type = 1;
    }

    /**
     * Returns the total price of pipe (of type 1).
     *
     * @return double
     */
    protected double getPrice() {
        double price, percentageIncrease, volume, plasticGradeCost;
        boolean chemicalResistant;

        //Initialise local variables
        chemicalResistant = this.chemicalResistance;

        //Calculate the basic cost
        price = this.costOfPipe();

        //Increase the price if includes chemical resistance.
        if (chemicalResistant) {
            percentageIncrease = this.getChemicalResistanceCost();
            price *= 1 + percentageIncrease;
        }
        return setTo2DecimalPlaces(price);
    }

}
