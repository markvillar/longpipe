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

    protected int colour;

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
        this.colour = 1;
    }

    /**
     * Returns the number of colour(s) of the pipe.
     *
     * @return int
     */
    public int getColour() {
        return this.colour;
    }

    /**
     * Returns the percentage increase of price depending on the number of
     * colour selected.
     *
     * @return double
     */
    public double getColourPercentageIncrease() {
        int colour;
        double priceIncrease;

        colour = this.getColour();

        if (colour == 1) {
            //Increase the price by 12%
            priceIncrease = 0.12;
        } else {
            //Increase the price by 16%
            priceIncrease = 0.16;
        }

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
        volume = this.getVolume();
        plasticGrade = this.getPlasticGradeCost();
        chemicalResistant = this.chemicalResistance;
        numberOfColour = this.getColour();

        //Calculate the basic cost
        price = volume * plasticGrade;
        originalPrice = price;

        //Increase the price if includes chemical resistance.
        if (chemicalResistant) {
            percentageIncrease = this.getChemicalResistanceCost();
            price = price + (originalPrice * percentageIncrease);
        }

        //Increase price depending on the number of colour selected.
        percentageIncrease = this.getColourPercentageIncrease();
        price = price + (originalPrice * percentageIncrease);

        return price;
    }
}
