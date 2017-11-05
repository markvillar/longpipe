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

        PipeMain[] pipeList = new PipeMain[3];
        PipeMain testpipe = new PipeMain(1, 1, true);
        testpipe.DisplayInfo();
        Test test = new Test();
        test.TestPipeValid(true, true, true, 2, 5, 1, 1, pipeList);
        test.TestPipeValid(true, false, false, 2, 5, 10, 10, pipeList);
        test.TestPipeValid(true, true, true, 2, 5, 1, 1, pipeList);
        System.out.println("£ ;" + pipeList[1].Price());
        
        OrderForm of = new OrderForm();
        of.setVisible(true);

    }

}
