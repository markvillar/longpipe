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
     * @param p_length
     * @param p_outerDiameter
     * @param plasgrd
     * @param chemResistance
     */
    public Pipe1(double p_length, double p_outerDiameter, int plasgrd, boolean chemResistance) {
        super(p_length, p_outerDiameter, plasgrd, chemResistance);
        type = 1;
    }
        protected double extraCosts() {
        return this.getChemicalPrice();
    }

}
