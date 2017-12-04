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
public class Pipe5 extends Pipe4 {

    boolean outerReinforcement;

    public Pipe5() {

    }

    /**
     * Constructor used to make a pipe of type 5
     *
     * @param length
     * @param outerDiameter
     * @param plasticGrade
     * @param chemicalResistance
     */
    public Pipe5(double length, double outerDiameter, int plasticGrade, boolean chemicalResistance) {
        super(length, outerDiameter, plasticGrade, chemicalResistance);
        this.type = 5;
        this.colour = 2;
        this.outerReinforcement = true;
    }

    /**
     * Returns the percentage increase if outer reinforcement is selected.
     *
     * @return double
     */
    public double getOuterReinforcementPercentageIncrease() {
        return 0.17;
    }

    /**
     * Returns the total price of pipe (of type 5).
     *
     * @return double
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

        //Increase price for outer reinforcement.
        percentageIncrease = this.getOuterReinforcementPercentageIncrease();
        price = price + (originalPrice * percentageIncrease);

        return price;
    }
}
