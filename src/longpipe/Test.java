package longpipe;

/**
 *
 * @author up769598
 */
class Test {

    /**
     * Method used to workout witch type of pipe needs to be created and then
     * returns an integer of the type of pipe and returns a -1 if the pipe is
     * not valid
     */
    public int TestPipeValid(boolean outerReinforcement, boolean innerInsulation, int colour, int plasticGrade, double lenght, double diamater) {
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
        return plasticGrade >= 3 && plasticGrade <= 5 && colour == 2 && innerInsulation == true;
    }

    public boolean ValidatePipe4(int colour, int plasticGrade) {
        return plasticGrade >= 2 && plasticGrade <= 5 && colour == 2;
    }

    public boolean ValidatePipe3(int plasticGrade) {
        return plasticGrade >= 2 && plasticGrade <= 5;
    }

    public boolean ValidatePipe2(int plasticGrade) {
        return plasticGrade >= 2 && plasticGrade <= 4;
    }

    public boolean ValidatePipe1(int plasticGrade) {
        return plasticGrade >= 1 && plasticGrade <= 3;
    }

    public String whyNotValid(boolean outerReinforcement, boolean innerInsulation, int colour, int plasticGrade) {
        if (outerReinforcement) {
            return "With outer reinforcement plastic grade must be 3-5, colour must be 2 and it must have inner insuation";
        } else if (innerInsulation) {
            return "This pipe must be of colour 2 and plastic grade 2-5";
        } else if (colour == 2) {
            return "This must have a plastic grade 2-5";
        } else if (colour == 1) {
            return "This must have a plastic grade 2-4";
        } else if (colour == 0) {
            return "This must have a plastic grade 1-3";
        } else {
            return "Major Error";
        }
    }
}
