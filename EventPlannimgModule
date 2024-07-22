public class EventPlanningModule {
    private List<Event> events;
    private Map<Date, List<Event>> eventCalendar;
    private List<Volunteer> volunteers;

    public void createEvent(Event event) {
        // Add event to events list
        events.add(event);
        eventCalendar.putIfAbsent(event.getEventDate(), new ArrayList<>());
        eventCalendar.get(event.getEventDate()).add(event);
    }

    public void updateEvent(Event event) {
        // Update event details
        for (Event e : events) {
            if (e.getEventId().equals(event.getEventId())) {
                e.setEventName(event.getEventName());
                e.setEventDate(event.getEventDate());
                e.setAttendees(event.getAttendees());
                e.setVolunteers(event.getVolunteers());
                break;
            }
        }
    }

    public void deleteEvent(String eventId) {
        // Remove event from events list
        events.removeIf(e -> e.getEventId().equals(eventId));
        eventCalendar.values().forEach(list -> list.removeIf(e -> e.getEventId().equals(eventId)));
    }

    public Event getEventDetails(String eventId) {
        // Return event details by eventId
        for (Event event : events) {
            if (event.getEventId().equals(eventId)) {
                return event;
            }
        }
        return null;
    }
}
