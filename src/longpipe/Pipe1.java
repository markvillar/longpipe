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
     * @param length
     * @param outerDiameter
     * @param plasticGrade
     * @param chemicalResistance
     */
    public Pipe1(double length, double outerDiameter, int plasticGrade, boolean chemicalResistance) {
        super(length, outerDiameter, plasticGrade, chemicalResistance);
        this.type = 1;
    }
        protected double extraCosts() {
        return this.getChemicalPrice();
    }

}
