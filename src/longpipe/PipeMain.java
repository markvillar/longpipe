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

    public PipeMain(double p_length, double p_outerDiameter, int plasgrd, boolean chemResistance) {
        length = p_length;
        outerDiameter = p_outerDiameter;
        plasticVolume = WorkOutVolume(p_outerDiameter, p_length);
        chemicalResistance = chemResistance;
        plasticGrade = plasgrd;
    }

    protected double WorkOutVolume(double outerDiameter, double length) {
        double innerDiamater = outerDiameter * 0.9;
        double volume;
        volume = VolumeOfCylinder(outerDiameter, this.getLength()) - VolumeOfCylinder(innerDiamater, this.getLength());
        return volume;
    }

    protected double VolumeOfCylinder(double diameter, double length) {
        return Math.pow((diameter / 2) * Math.PI, 2) * length;
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

    public void setColour(int col) {
        colour = col;
    }

    public double getPlasticVolume() {
        return plasticVolume;
    }

    public double getDiameter() {
        return outerDiameter;
    }
    public double getLength(){
        return length;
    }

    public String DisplayInfo() {
        return (" Meters : " + this.getLength() + " Inch : " + String.format("%.2f", this.getDiameter()) + " Price: £" + String.format("%.2f", this.Price()));
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

        return costOfPlastic[this.GetPlasticGrade() - 1];
    }

    private double extraCosts() {
        return this.ChemicalPrice();
    }

    public double Price() {
        double price = this.costOfPlastic() * this.getPlasticVolume() * this.extraCosts(); // change to voume ratherthan doubble cost
        return price;
    }
}
