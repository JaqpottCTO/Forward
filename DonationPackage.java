package com.blerdU.rootworkapp;

public class DonationPackage {
    private String name;
    private int minAmount;
    private int maxAmount;
    private String purpose;
    private List<String> benefits;

    public DonationPackage(String name, int minAmount, int maxAmount, String purpose, List<String> benefits) {
        this.name = name;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.purpose = purpose;
        this.benefits = benefits;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getMinAmount() {
        return minAmount;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public String getPurpose() {
        return purpose;
    }

    public List<String> getBenefits() {
        return benefits;
    }
}
