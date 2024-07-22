public class Event {
    private String eventId;
    private String eventName;
    private Date eventDate;
    private List<String> attendees;
    private List<String> volunteers;

    public Event(String eventId, String eventName, Date eventDate) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.attendees = new ArrayList<>();
        this.volunteers = new ArrayList<>();
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public List<String> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<String> attendees) {
        this.attendees = attendees;
    }

    public List<String> getVolunteers() {
        return volunteers;
    }

    public void setVolunteers(List<String> volunteers) {
        this.volunteers = volunteers;
    }
}
