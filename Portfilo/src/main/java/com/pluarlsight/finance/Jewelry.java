package com.pluarlsight.finance;
public class Jewelry extends FixedAsset {
    private double karat;

    public Jewelry(String name, double karat) {
        // assume market value is karat * 100
        super(name, karat * 100);
        this.karat = karat;
    }

    public double getKarat() {
        return karat;
    }


    public void setKarat(double karat) {
        this.karat = karat;
    }
}
