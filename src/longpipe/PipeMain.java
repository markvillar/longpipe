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
    protected double outerDiameter;
    protected double plasticVolume;
    protected boolean chemicalResistance;
    protected int colour;
    protected boolean insulation;
    protected boolean reinforcement;

    public PipeMain() {

    }

    public PipeMain(double p_length, double p_outerDiameter, boolean chemResistance) {
        lenght = p_length;
        outerDiameter = p_outerDiameter;
        plasticVolume = WorkOutVolume(outerDiameter, lenght);
        chemicalResistance = chemResistance;
    }

    protected double WorkOutVolume(double outerDiameter, double length) {
        double innerDiamater = outerDiameter * 0.9;
        double volume;
        volume = AreaOfCylinder(outerDiameter, lenght) - AreaOfCylinder(innerDiamater, lenght);
        return volume;
    }

    protected double AreaOfCylinder(double diameter, double length) {
        return Math.sqrt((diameter / 2) * Math.PI) * length;
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
        System.out.println(lenght + " Meters : " + String.format("%.2f", outerDiameter) + " Inch : " + String.format("%.2f", plasticVolume) + " Inch^3 /n" + colour);
    }

    protected double ChemicalPrice() {
        if (this.GetChemicalResistance()) {
            return 1.14;
        } else {
            return 1;
        }
    }

    protected double costOfPlastic() {
        double[] costOfPlastic = {0.4, 0.6, 0.75, 0.8, 0.95};

        return costOfPlastic[this.GetPlasticGrade()];
    }
    private double extraCosts(){
        return this.ChemicalPrice();
    }

    public double Price() {
        double price = this.costOfPlastic() * this.costOfPlastic() * this.extraCosts(); // change to voume ratherthan doubble cost
        return price;
    }
}
