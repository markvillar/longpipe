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
public class LongPipe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        PipeMain testpipe = new PipeMain(1, 1);
        testpipe.DisplayInfo();
        Test test = new Test();
        test.TestPipeValid(true, true , 2 , 5);
        test.TestPipeValid(true, false , 2 , 5);

    }

   

}
