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
        
    }

    /**
     * this method combines all the price modifier for the different statuses of
     * the pipe.
     *
     * @return the price modifier for the pipe
     */
    protected double extraCosts() {
        return this.getChemicalPrice() * 1.16 * 1.13 * 1.17;
    }

}
