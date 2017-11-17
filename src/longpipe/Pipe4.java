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
public class Pipe4 extends PipeMain {

    public Pipe4() {

    }

    /**
     * Constructor used to make a pipe of type 4 
     * @param p_length
     * @param p_outerDiameter
     * @param plasgrd
     * @param chemResistance
     */
    public Pipe4(double p_length, double p_outerDiameter, int plasgrd, boolean chemResistance) {
        super(4,p_length, p_outerDiameter, plasgrd, chemResistance);
        this.setColour(2);
    }
     /**
     * this method combines all the price modifier for the different statuses of the pipe.
     * @return the price modifier for the pipe 
     */
    private double extraCosts() {
        return this.ChemicalPrice() * 1.16 * 1.13;
    }

}
