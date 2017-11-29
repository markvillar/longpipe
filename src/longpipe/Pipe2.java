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
public class Pipe2 extends PipeMain {

    public Pipe2() {

    }

    /**
     * Constructor used to make a pipe of type 2
     *
     * @param p_length
     * @param p_outerDiameter
     * @param plasgrd
     * @param chemResistance
     */
    public Pipe2(double p_length, double p_outerDiameter, int plasgrd, boolean chemResistance) {
        super(p_length, p_outerDiameter, plasgrd, chemResistance);
        type = 2;
        colour = 1;
    }

    /**
     * this method combines all the price modifier for the different statuses of
     * the pipe.
     *
     * @return the price modifier for the pipe
     */
    protected double extraCosts() {
        return this.getChemicalPrice() * 1.12;
    }
}
