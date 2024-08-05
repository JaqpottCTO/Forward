package com.blerdU.rootworkapp;

public class Pledge {
    private String pledgeId;
    private String pledgerId;
    private double amount;
    private String message;

    public Pledge(String pledgeId, String pledgerId, double amount, String message) {
        this.pledgeId = pledgeId;
        this.pledgerId = pledgerId;
        this.amount = amount;
        this.message = message;
    }

    public String getPledgeId() {
        return pledgeId;
    }

    public void setPledgeId(String pledgeId) {
        this.pledgeId = pledgeId;
    }

    public String getPledgerId() {
        return pledgerId;
    }

    public void setPledgerId(String pledgerId) {
        this.pledgerId = pledgerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
