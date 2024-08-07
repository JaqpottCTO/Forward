package com.blerdU.rootworkapp;

public class VolunteerCoordinator {
    private List<Volunteer> volunteers;
    private List<Event> events;

    public VolunteerCoordinator() {
        this.volunteers = new ArrayList<>();
        this.events = new ArrayList<>();
    }

    public void assignVolunteer(String eventId, String volunteerId) {
        // Assign volunteer to event
        for (Event event : events) {
            if (event.getEventId().equals(eventId)) {
                event.getVolunteers().add(volunteerId);
                break;
            }
        }
    }

    public void trackVolunteerHours(String volunteerId, int hours) {
        // Track volunteer hours
        for (Volunteer volunteer : volunteers) {
            if (volunteer.getVolunteerId().equals(volunteerId)) {
                volunteer.addHours(hours);
                break;
            }
        }
    }

    public void rewardVolunteer(String volunteerId, int points) {
        // Reward volunteer with points
        for (Volunteer volunteer : volunteers) {
            if (volunteer.getVolunteerId().equals(volunteerId)) {
                volunteer.addPoints(points);
                break;
            }
        }
    }
}
