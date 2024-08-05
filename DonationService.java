package com.blerdU.rootworkapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DonationService {
    private Map<Event, List<Donation>> donations;
    private Map<String, DonationPackage> donationPackages;

    public DonationService() {
        this.donations = new HashMap<>();
        this.donationPackages = new HashMap<>();
        initializeDonationPackages();
    }

    // Initialize predefined donation packages with their respective details
    private void initializeDonationPackages() {
        donationPackages.put("Initial Facility Enhancement Sponsor", 
            new DonationPackage("Initial Facility Enhancement Sponsor", 30000, Integer.MAX_VALUE, 
                "Support for facility rehab, including structural upgrades and a dedicated PEDU area.",
                List.of("Naming rights for the PEDU facility.", "Prominent recognition in promotional materials and at the opening ceremony.",
                        "VIP invitations to exclusive events and tours.", "Regular reports on facility enhancement progress and impact.")
            )
        );

        donationPackages.put("Initial Technology Enhancement Sponsor", 
            new DonationPackage("Initial Technology Enhancement Sponsor", 15000, 29999,
                "Funding to enhance Wi-Fi and acquire desktop PCs.",
                List.of("Recognition in technology-related materials and digital platforms.", 
                        "Invitations to events showcasing new technological capabilities.",
                        "Bi-annual updates on technology integration and usage impact.")
            )
        );

        donationPackages.put("Personal Development Project Sponsor", 
            new DonationPackage("Personal Development Project Sponsor", 10000, 14999, 
                "Support for individual onboarding projects via the app.",
                List.of("Acknowledgment in project-specific communications.", 
                        "Invitations to project showcase events.",
                        "Quarterly updates on project progress and outcomes.")
            )
        );

        donationPackages.put("Elite Participant Empowerment Supporter", 
            new DonationPackage("Elite Participant Empowerment Supporter", 5000, 9999,
                "Support for elite participant achievements.",
                List.of("Special recognition in participant stories and literature.", 
                        "Updates on significant achievements and milestones.")
            )
        );

        donationPackages.put("Premier Community Supporter", 
            new DonationPackage("Premier Community Supporter", 0, 4999, 
                "General support for programmatic needs.",
                List.of("Recognition in annual reports and promotional materials.", 
                        "Periodic updates on overall program achievements and impact.")
            )
        );
    }

    // Process a donation and categorize it under the appropriate event
    public void processDonation(Donation donation) {
        donations.putIfAbsent(donation.getEvent(), new ArrayList<>());
        donations.get(donation.getEvent()).add(donation);
    }

    // Return donation history for a specific event
    public List<Donation> getDonationHistory(String eventId) {
        for (Event event : donations.keySet()) {
            if (event.getEventId().equals(eventId)) {
                return donations.get(event);
            }
        }
        return null;
    }

    // Retrieve donation package details
    public DonationPackage getDonationPackage(String packageName) {
        return donationPackages.get(packageName);
    }

    // Add a new donation package (for admin use)
    public void addDonationPackage(DonationPackage donationPackage) {
        donationPackages.put(donationPackage.getName(), donationPackage);
    }

    // Get all donation packages
    public List<DonationPackage> getAllDonationPackages() {
        return new ArrayList<>(donationPackages.values());
    }
}
