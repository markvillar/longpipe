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
public class Pipe1 extends PipeMain {

    public Pipe1() {

    }

    /**
     * Constructor used to make a pipe of type 1
     *
     * @param p_length
     * @param p_outerDiameter
     * @param plasgrd
     * @param chemResistance
     */
    public Pipe1(double p_length, double p_outerDiameter, int plasgrd, boolean chemResistance) {
        super(1, p_length, p_outerDiameter, plasgrd, chemResistance);
        this.setColour(0);

    }
        protected double extraCosts() {
        return this.getChemicalPrice();
    }

}
