package com.blerdU.rootworkapp;

public class PledgeService {
    private Map<String, List<Pledge>> eventPledges;

    public PledgeService() {
        eventPledges = new HashMap<>();
    }

    public void addPledge(String eventId, Pledge pledge) {
        eventPledges.putIfAbsent(eventId, new ArrayList<>());
        eventPledges.get(eventId).add(pledge);
        sendPledgeNotification(eventId, pledge);
    }

    public List<Pledge> getPledgesForEvent(String eventId) {
        return eventPledges.getOrDefault(eventId, new ArrayList<>());
    }

    private void sendPledgeNotification(String eventId, Pledge pledge) {
        // Implement notification logic here
        System.out.println("Notification: New pledge for event " + eventId + " by " + pledge.getPledgerId());
    }
}
