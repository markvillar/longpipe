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

    protected double lenght;
    protected int plasticGrade;
    protected double outerDiamater;
    protected double plasticVolume;
    protected boolean chemicalResistance;
    protected int colour;

    public PipeMain() {

    }

    public PipeMain(double p_length, double p_outerDiamater, boolean chemResistance) {
        lenght = p_length;
        outerDiamater = p_outerDiamater;
        plasticVolume = WorkOutVolume(outerDiamater, lenght);
        chemicalResistance = chemResistance;

    }

    protected double WorkOutVolume(double outerDiamater, double length) {
        double innerDiamater = outerDiamater * 0.9;
        double volume;
        volume = AreaOfCylnder(outerDiamater, lenght) - AreaOfCylnder(innerDiamater, lenght);
        return volume;
    }

    protected double AreaOfCylnder(double diamater, double length) {
        return Math.sqrt((diamater / 2) * Math.PI) * length;
    }

    protected double InchToMeters(double inch) {
        return inch * 0.0254;
    }

    protected double MetersToInch(double meters) {
        return meters * 39.37;
    }

    public boolean GetChemicalResistance() {
        return chemicalResistance;
    }

    public int GetPlasticGrade() {
        return plasticGrade;
    }

    public double GetPlasticVolume() {
        return plasticVolume;
    }

    public void DisplayInfo() {
        System.out.println(lenght + " Meters : " + outerDiamater + " Inch : " + plasticVolume + " Inch^3 /n" + colour);
    }

    protected double ChemicalPrice() {
        if (this.GetChemicalResistance()) {
            return 1.14;
        } else {
            return 1;
        }
    }

    protected double costOfPalstic() {
        double[] costOfPlastic = {0.4, 0.6, 0.75, 0.8, 0.95};

        return costOfPlastic[this.GetPlasticGrade() - 1];
    }
    private double extraCosts(){
        return this.ChemicalPrice();
    }

    public double Price() {
        double price = this.costOfPalstic() * this.costOfPalstic() * this.extraCosts();
        return price;
    }
}
