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
        chemicalResistant = this.chemicalResistance;

        //Calculate the basic cost
        price = this.costOfPipe();

        //Increase price depending on the number of colour selected and outer reinforcement and  inner insulation.
        percentageIncrease = this.getColourPercentageIncrease() + this.getOuterReinforcementPercentageIncrease() + this.getInnerInsulationPercentageIncrease();
        
        //Increase the price if includes chemical resistance.
        if (chemicalResistant) {
            percentageIncrease += this.getChemicalResistanceCost();
        }
        price *= 1 + percentageIncrease;
        return price;
    }
}
