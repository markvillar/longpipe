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
public class Pipe5 extends PipeMain {

    public Pipe5() {

    }

    public Pipe5(double p_length, double p_outerDiameter,int plasgrd, boolean chemResistance) {
        super(p_length, p_outerDiameter,plasgrd, chemResistance);
        colour = 2;
    }

    private double extraCosts() {
        return this.ChemicalPrice() * 1.16 * 1.3 * 1.7;
    }

}
