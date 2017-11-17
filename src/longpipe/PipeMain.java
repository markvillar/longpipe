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
public class PipeMain {

    private double length;
    private int plasticGrade;
    private double outerDiameter;
    private double plasticVolume;
    private boolean chemicalResistance;
    private int colour;

    public PipeMain() {

    }

    /**
     * Main construtors for the defult Pipe
     * @param p_length length specified by the user 
     * @param p_outerDiameter width of the pipe specified by the user 
     * @param plasgrd plastic grade specified by the user 
     * @param chemResistance if the pipe is chemical resistant then the value will be true
     * 
     */
    public PipeMain(double p_length, double p_outerDiameter, int plasgrd, boolean chemResistance) {
        length = p_length;
        outerDiameter = p_outerDiameter;
        plasticVolume = WorkOutVolume(p_outerDiameter, p_length);
        chemicalResistance = chemResistance;
        plasticGrade = plasgrd;
    }

    /**
     * Used to work out the plastic Volume of the pipe by subtracting the inner diamiter cylinder by the outer diamiter cylinder
     * @param outerDiameter the width of the pipe passed through by the constructor
     * @param length the length of the pipe passed through by the constructor
     * @return the plastic volume of the pipe 
     */
    protected double WorkOutVolume(double outerDiameter, double length) {
        double innerDiamater = outerDiameter * 0.9;
        double volume;
        volume = VolumeOfCylinder(outerDiameter, this.getLength()) - VolumeOfCylinder(innerDiamater, this.getLength());
        return volume;
    }

    /**
     * Calculates the volume of a cylinder 
     * @param diameter Diameter of the cylinder
     * @param length Length of the cylinder
     * @return returns the volume of the cylinder
     */
    protected double VolumeOfCylinder(double diameter, double length) {
        return Math.pow((diameter / 2) * Math.PI, 2) * length;
    }

    /**
     * Converts inches to meters
     * @param inch the length in inches to be converted into inch
     * @return length in meters
     */
    protected double InchToMeters(double inch) {
        return inch * 0.0254;
    }

    /**
     * Converts Meters To Inch
     * @param meters the meters value to be converted to inch
     * @return the converted meters value
     */
    protected double MetersToInch(double meters) {
        return meters * 39.37;
    }

    /**
     * gets the value of chemical resistance
     * @return chemical resistance
     */
    public boolean GetChemicalResistance() {
        return chemicalResistance;
    }

    /**
     *  gets the value of plastic grade 
     * @return plastic grade 
     */
    public int GetPlasticGrade() {
        return plasticGrade;
    }

    /**
     *used to set the colour 
     * @param col the color to be set to
     */
    public void setColour(int col) {
        colour = col;
    }

    /**
     * gets the value of plastic Volume 
     * @return plastic Volume 
     */
    public double getPlasticVolume() {
        return plasticVolume;
    }

    /**
     * gets the value of plastic grade 
     * @return Width of the pipe 
     */
    public double getDiameter() {
        return outerDiameter;
    }

    /**
     * gets the value of length of the pipe
     * @return length of pipe 
     */
    public double getLength(){
        return length;
    }

    /**
     * used to return a string with the information of a pipe  
     * @return formated string
     */
    public String DisplayInfo() {
        return (" Meters : " + this.getLength() + "      Inch : " + String.format("%.2f", this.getDiameter()) + "       Price: £" + String.format("%.2f", this.Price()));
    }

    /**
     * adds the price increase if the Chemical Price
     * @return the price increas for chemical resistance  
     */
    protected double ChemicalPrice() {
        if (this.GetChemicalResistance()) {
            return 1.14;
        } else {
            return 1;
        }
    }

    /**
     *works out the cost of plastic per inch^3
     * @return price of plastic
     */
    protected double costOfPlastic() {
        double[] costOfPlastic = {0.4, 0.6, 0.75, 0.8, 0.95};

        return costOfPlastic[this.GetPlasticGrade() - 1];
    }
    
    /**
     * returns the total percantage increse of all different price modiffiers 
     * @return price modifier
     */
    private double extraCosts() {
        return this.ChemicalPrice();
    }

    /**
     *works out the total price for the pipe
     * @return pipe price
     */
    public double Price() {
        double price = this.costOfPlastic() * this.getPlasticVolume() * this.extraCosts(); // change to voume ratherthan doubble cost
        return price;
    }
}
