public class Invite {
    private String id;
    private String email;
    private String role;
    private String doorId;
    private String responseStatus;

    public Invite() {
        // Default constructor
    }

    public Invite(String id, String email, String role, String doorId) {
        this.id = id;
        this.email = email;
        this.role = role;
        this.doorId = doorId;
        this.responseStatus = "Pending";
    }

    // Getters and setters
}
