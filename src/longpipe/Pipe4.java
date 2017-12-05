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
public class Pipe4 extends Pipe3 {

    boolean innerInsulation;

    public Pipe4() {

    }

    /**
     * Constructor used to make a pipe of type 4
     *
     * @param length
     * @param outerDiameter
     * @param plasticGrade
     * @param chemicalResistance
     */
    public Pipe4(double length, double outerDiameter, int plasticGrade, boolean chemicalResistance) {
        super(length, outerDiameter, plasticGrade, chemicalResistance);
        this.type = 4;
        this.colour = 2;
        this.innerInsulation = true;
    }

    /**
     * Returns the percentage increase if inner insulation is selected.
     *
     * @return double
     */
    public double getInnerInsulationPercentageIncrease() {
        return 0.13;
    }

    /**
     * Returns the total price of pipe (of type 4).
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
        price = volume / plasticGrade;
        originalPrice = price;

        //Increase the price if includes chemical resistance.
        if (chemicalResistant) {
            percentageIncrease = this.getChemicalResistanceCost();
            price = price + (originalPrice * percentageIncrease);
        }

        //Increase price depending on the number of colour selected.
        percentageIncrease = this.getColourPercentageIncrease();
        price = price + (originalPrice * percentageIncrease);

        //Increase price for inner insulation.
        percentageIncrease = this.getInnerInsulationPercentageIncrease();
        price = price + (originalPrice * percentageIncrease);

        return price;
    }
}
