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
public class Pipe3 extends Pipe2 {

    public Pipe3() {

    }

    /**
     * Constructor used to make a pipe of type 3
     *
     * @param length
     * @param outerDiameter
     * @param plasticGrade
     * @param chemicalResistance
     */
    public Pipe3(double length, double outerDiameter, int plasticGrade, boolean chemicalResistance) {
        super(length, outerDiameter, plasticGrade, chemicalResistance);
        this.type = 3;
    }

    public double getColourPercentageIncrease() {
        double priceIncrease;
        //Increase the price by 16%
        priceIncrease = 0.16;
        return priceIncrease;
    }
}
