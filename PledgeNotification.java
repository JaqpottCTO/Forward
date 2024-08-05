package com.blerdU.rootworkapp;

public class PledgeNotification {
    private String eventId;
    private String pledgeId;
    private String pledgerId;
    private double amount;

    public PledgeNotification(String eventId, String pledgeId, String pledgerId, double amount) {
        this.eventId = eventId;
        this.pledgeId = pledgeId;
        this.pledgerId = pledgerId;
        this.amount = amount;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
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
}
