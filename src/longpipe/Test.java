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
class Test {

    public void TestPipeValid(boolean outerReinforcement, boolean innerInsulation, boolean chemResistance, int colour, int plasticGrade, double lenght, double diamater, PipeMain[] pipeList) {
        if (outerReinforcement) {
            if (ValidatePipe5(innerInsulation, colour, plasticGrade)) {
                System.out.println("Valid pipe type 5");
                Pipe5 testpipe = new Pipe5(lenght, diamater, chemResistance);
                pipeList[1] = testpipe;
                
            } else {
                System.out.println("Invalid Pipe");
                return;
            }
        } else if (innerInsulation) {
            if (ValidatePipe4(colour, plasticGrade)) {
                System.out.println("Valid pipe type 4");
                Pipe4 testpipe = new Pipe4(lenght, diamater, chemResistance);
            } else {
                System.out.println("Invalid Pipe");
                return;

            }

        } else if (colour == 2) {
            if (ValidatePipe3(plasticGrade)) {
                System.out.println("Valid pipe type 3");
                Pipe3 testpipe = new Pipe3(lenght, diamater, chemResistance);
            } else {
                System.out.println("Invalid Pipe");
                return;

            }
        } else if (colour == 1) {
            if (ValidatePipe2(plasticGrade)) {
                System.out.println("Valid pipe type 2");
                Pipe2 testpipe = new Pipe2(lenght, diamater, chemResistance);
            } else {
                System.out.println("Invalid Pipe");
                return;

            }
        } else if (colour == 0) {
            if (ValidatePipe1(plasticGrade)) {
                System.out.println("Valid pipe type 1");
                Pipe1 testpipe = new Pipe1(lenght, diamater, chemResistance);
            } else {
                System.out.println("Invalid Pipe");
                return;

            }
        }
        
    }

    public boolean ValidatePipe5(boolean innerInsulation, int colour, int plasticGrade) {
        if (plasticGrade >= 3 && plasticGrade <= 5 && colour == 2 && innerInsulation == true) {
            return true;
        } else {
            return false;
        }

    }

    public boolean ValidatePipe4(int colour, int plasticGrade) {
        if (plasticGrade >= 2 && plasticGrade <= 5 && colour == 2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean ValidatePipe3(int plasticGrade) {
        if (plasticGrade >= 2 && plasticGrade <= 5) {
            return true;
        } else {
            return false;
        }
    }

    public boolean ValidatePipe2(int plasticGrade) {
        if (plasticGrade >= 2 && plasticGrade <= 4) {
            return true;
        } else {
            return false;
        }
    }

    public boolean ValidatePipe1(int plasticGrade) {
        if (plasticGrade >= 1 && plasticGrade <= 3) {
            return true;
        } else {
            return false;
        }
    }
}
