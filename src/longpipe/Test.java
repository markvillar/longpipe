package longpipe;

/**
 *
 * @author up769598
 */
class Test {

    /**
     * Method used to workout which type of pipe needs to be created and then
     * returns an integer that corresponds to the type of pipe. If however the
     * pipe cannot be created, the function will simply return -1.
     *
     * Using a series of if statements that work their way from the pipe type 5
     * with the most specific things required down to type 1 with the least. the
     * if statement should be able to work out if a pipe is a valid type without
     * using brute force.
     *
     * To Keep the code readable the complex nested if statement has been
     * transfered to their own method
     *
     * @param outerReinforcement Boolean describing if the proposed pipe has
     * outer reinforcement
     * @param innerInsulation Boolean describing if the proposed pipe has inner
     * insulation
     * @param colour int describing the colour of the pipe
     * @param plasticGrade int describing the plastic grade of the pipe
     * @return the type of pipe or -1 if pipe is invalid
     */
    public int TestPipeValid(boolean outerReinforcement, boolean innerInsulation, int colour, int plasticGrade) {
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

    /**
     *
     * @param outerReinforcement Boolean describing if the proposed pipe has
     * outer reinforcement
     * @param innerInsulation Boolean describing if the proposed pipe has inner
     * insulation
     * @param colour int describing the colour of the pipe
     * @param plasticGrade int describing the plastic grade of the pipe
     * @return A string with Information for the user telling them why the Pipe
     * is invalid for what the program thinks they want. with else case to
     * return "Major Error" if something gets through the if statements
     */
    public String whyNotValid(boolean outerReinforcement, boolean innerInsulation, int colour, int plasticGrade) {
        if (outerReinforcement) {
            return "Pipe(s) with outer reinforcement must have plastic grade of at least 3, colour of 2, and it must include an inner insuation.";
        } else if (innerInsulation) {
            return "Pipe(s) with inner insulation must have at least 2 colours, and a plastic grade of at least 2.";
        } else if (colour == 2) {
            return "Pipe(s) with 2 colours must at least have a plastic grade of 2.";
        } else if (colour == 1) {
            return "Pipe(s) with 1 colour can only have 2 up to 4 class of plastic grade.";
        } else if (colour == 0) {
            return "Pipe(s) without colour can only have a plastic grade of 1 up to 3";
        } else {
            return "Unknown Error";
        }
    }
}
