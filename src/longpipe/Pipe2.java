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
public class Pipe2 extends Pipe {

    protected int colour;
    
    public Pipe2() {

    }

    /**
     * Constructor used to make a pipe of type 2
     *
     * @param length
     * @param outerDiameter
     * @param plasticGrade
     * @param chemicalResistance
     */
    public Pipe2(double length, double outerDiameter, int plasticGrade, boolean chemicalResistance) {
        super(length, outerDiameter, plasticGrade, chemicalResistance);
        this.type = 2;
        this.colour = 1;
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
    
    /**
     * Sets the number of colour for pipe
     *
     * @param colour the colour to be set to
     */
    public void setColour(int colour) {
        this.colour = colour;
    }
}
