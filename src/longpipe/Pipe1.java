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
public class Pipe1 extends PipeMain {

    public Pipe1() {

    }

    /**
     * Constructor used to make a pipe of type 1
     *
     * @param p_length The given Length of the pipe
     * @param p_outerDiameter The given Width of the pipe
     * @param plasgrd The plastic grade of the pipe
     * @param chemResistance If the pipe is chemical resistant
     */
    public Pipe1(double p_length, double p_outerDiameter, int plasgrd, boolean chemResistance) {
        super(p_length, p_outerDiameter, plasgrd, chemResistance);
        this.setColour(0);

    }

}
