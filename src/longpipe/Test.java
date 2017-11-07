/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longpipe;

import java.util.ArrayList;

/**
 *
 * @author up769598
 */
class Test {
// Methord Used to workout witch type of pipe needs to be created adn then retuns an int of the type of pipe and returns a -1 if the pipe is not valid
    public int TestPipeValid(boolean outerReinforcement, boolean innerInsulation, boolean chemResistance, int colour, int plasticGrade, double lenght, double diamater) {
        int type = -1;
        if (outerReinforcement) {
            if (ValidatePipe5(innerInsulation, colour, plasticGrade)) {
                type = 5;
            }
        } else if (innerInsulation) {
            if (ValidatePipe4(colour, plasticGrade)) {
                type = 4;
            }
        } else if (colour == 2) {
            if (ValidatePipe3(plasticGrade)) {
                type = 3;
            }
        } else if (colour == 1) {
            if (ValidatePipe2(plasticGrade)) {
                type = 2;
            }
        } else if (colour == 0) {
            if (ValidatePipe1(plasticGrade)) {
                type = 1;
            }
        }
        return type;
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
