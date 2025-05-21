package com.pluarlsight.finance;


import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private String name;
    private String owner;
    private List<Valuable> assets;

    public Portfolio(String name, String owner) {
        this.name = name;
        this.owner = owner;
        this.assets = new ArrayList<>();
    }

    public void add(Valuable asset) {
        this.assets.add(asset);
    }

    public double getValue() {
        double totalValue = 0;
        for (Valuable asset : this.assets) {
            totalValue += asset.getValue();
        }
        return totalValue;
    }

    public Valuable getMostValuable() {
        if (assets.isEmpty()) {
            return null; // Or throw an exception, e.g., IllegalStateException
        }

        Valuable mostValuableAsset = assets.get(0);
        double maxVal = mostValuableAsset.getValue();

        for (int i = 1; i < assets.size(); i++) {
            Valuable currentAsset = assets.get(i);
            if (currentAsset.getValue() > maxVal) {
                maxVal = currentAsset.getValue();
                mostValuableAsset = currentAsset;
            }
        }
        return mostValuableAsset;
    }

    public Valuable getLeastValuable() {
        if (assets.isEmpty()) {
            return null; // Or throw an exception
        }

        Valuable leastValuableAsset = assets.get(0);
        double minVal = leastValuableAsset.getValue();

        for (int i = 1; i < assets.size(); i++) {
            Valuable currentAsset = assets.get(i);
            if (currentAsset.getValue() < minVal) {
                minVal = currentAsset.getValue();
                leastValuableAsset = currentAsset;
            }
        }
        return leastValuableAsset;
    }


}