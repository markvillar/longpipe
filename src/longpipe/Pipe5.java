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
public class Pipe5 extends PipeMain {

    public Pipe5() {

    }

    /**
     * Constructor used to make a pipe of type 5
     *
     * @param p_length The given Length of the pipe
     * @param p_outerDiameter The given Width of the pipe
     * @param plasgrd The plastic grade of the pipe
     * @param chemResistance If the pipe is chemical resistant
     */
<<<<<<< HEAD
    public Pipe5(double p_length, double p_outerDiameter,int plasgrd, boolean chemResistance) {
        super(5,p_length, p_outerDiameter,plasgrd, chemResistance);
=======
    public Pipe5(double p_length, double p_outerDiameter, int plasgrd, boolean chemResistance) {
        super(p_length, p_outerDiameter, plasgrd, chemResistance);
>>>>>>> origin/master
        this.setColour(2);
    }

    /**
     * this method combines all the price modifier for the different statuses of
     * the pipe.
     *
     * @return the price modifier for the pipe
     */
    private double extraCosts() {
        return this.ChemicalPrice() * 1.16 * 1.13 * 1.17;
    }

}
