public class DonationService {
    private Map<Event, List<Donation>> donations;

    public DonationService() {
        this.donations = new HashMap<>();
    }

    public void processDonation(Donation donation) {
        // Process donation
        donations.putIfAbsent(donation.getEvent(), new ArrayList<>());
        donations.get(donation.getEvent()).add(donation);
    }

    public List<Donation> getDonationHistory(String eventId) {
        // Return donation history for an event
        for (Event event : donations.keySet()) {
            if (event.getEventId().equals(eventId)) {
                return donations.get(event);
            }
        }
        return null;
    }
}
