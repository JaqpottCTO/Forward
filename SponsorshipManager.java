package com.blerdU.rootworkapp;

public class SponsorshipManager {
    private List<Sponsor> sponsors;
    private List<Event> events;

    public SponsorshipManager() {
        this.sponsors = new ArrayList<>();
        this.events = new ArrayList<>();
    }

    public void addSponsor(Sponsor sponsor) {
        // Add sponsor to sponsors list
        sponsors.add(sponsor);
    }

    public void removeSponsor(String sponsorId) {
        // Remove sponsor from sponsors list
        sponsors.removeIf(s -> s.getSponsorId().equals(sponsorId));
    }

    public Sponsor getSponsorDetails(String sponsorId) {
        // Return sponsor details by sponsorId
        for (Sponsor sponsor : sponsors) {
            if (sponsor.getSponsorId().equals(sponsorId)) {
                return sponsor;
            }
        }
        return null;
    }
}
