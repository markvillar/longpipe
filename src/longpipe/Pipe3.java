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
public class Pipe3 extends PipeMain {

    public Pipe3() {

    }

    /**
     * Constructor used to make a pipe of type 3
     *
     * @param p_length
     * @param p_outerDiameter
     * @param plasgrd
     * @param chemResistance
     */
    public Pipe3(double p_length, double p_outerDiameter, int plasgrd, boolean chemResistance) {
        super(p_length, p_outerDiameter, plasgrd, chemResistance);
        type = 3;
        colour = 2;
    }

    /**
     * this method combines all the price modifier for the different statuses of
     * the pipe.
     *
     * @return the price modifier for the pipe
     */
    protected double extraCosts() {
        return this.getChemicalPrice() * 1.16;
    }
}
