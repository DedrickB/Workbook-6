package com.pluarlsight.finance;
public class Gold extends FixedAsset {
    private double weight;

    public Gold(double weight) {
        // assuming $1000 * weight as the market value
        super("Gold", weight * 1000);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}