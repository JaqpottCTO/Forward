package com.blerdU.rootworkapp;

public class PledgeManager {
    private PledgeService pledgeService;

    public PledgeManager() {
        pledgeService = new PledgeService();
    }

    public void createPledge(String eventId, String pledgerId, double amount, String message) {
        String pledgeId = generatePledgeId();
        Pledge pledge = new Pledge(pledgeId, pledgerId, amount, message);
        pledgeService.addPledge(eventId, pledge);
    }

    public List<Pledge> viewPledges(String eventId) {
        return pledgeService.getPledgesForEvent(eventId);
    }

    private String generatePledgeId() {
        return UUID.randomUUID().toString();
    }
}
