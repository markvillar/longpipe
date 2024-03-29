/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longpipe;

/**
 *
 * @author James
 */
public class Pipe2 extends Pipe {

    public Pipe2() {

    }

    /**
     * Constructor used to make a pipe of type 2
     *
     * @param length
     * @param outerDiameter
     * @param plasticGrade
     * @param chemicalResistance
     */
    public Pipe2(double length, double outerDiameter, int plasticGrade, boolean chemicalResistance) {
        super(length, outerDiameter, plasticGrade, chemicalResistance);
        this.type = 2;
    }

    /**
     * Returns the percentage increase of price depending on the number of
     * colour selected.
     *
     * @return double
     */
    public double getColourPercentageIncrease() {
        double priceIncrease;
        //Increase the price by 12%
        priceIncrease = 0.12;
        return priceIncrease;
    }

    /**
     * Returns the total price of pipe (of type 2 & 3).
     *
     * @return the price modifier for the pipe
     */
    protected double getPrice() {
        double originalPrice, price, percentageIncrease, volume, plasticGrade;
        boolean chemicalResistant;
        int numberOfColour;

        //Initialise local variables
        chemicalResistant = this.chemicalResistance;

        //Calculate the basic cost
        price = this.costOfPipe();

        //Increase the price if includes chemical resistance.
        percentageIncrease = this.getColourPercentageIncrease();
        if (chemicalResistant) {
            percentageIncrease += this.getChemicalResistanceCost();
        }

        //Increase price depending on the number of colour selected.
        price *= 1 + percentageIncrease;

        return setTo2DecimalPlaces(price);
    }
}
