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
     * @param p_length
     * @param p_outerDiameter
     * @param plasgrd
     * @param chemResistance
     */
    public Pipe3(double p_length, double p_outerDiameter, int plasgrd, boolean chemResistance) {
        super(p_length, p_outerDiameter, plasgrd, chemResistance);
        this.setColour(2);

    }

    private double extraCosts() {
        return this.ChemicalPrice() * 1.16;
    }
}
