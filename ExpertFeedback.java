public class ExpertFeedback {
    private String id;
    private String expertId;
    private String content;
    private String status;
    private String doorId;

    public ExpertFeedback() {
        // Default constructor
    }

    public ExpertFeedback(String id, String expertId, String content, String doorId) {
        this.id = id;
        this.expertId = expertId;
        this.content = content;
        this.doorId = doorId;
        this.status = "Pending";
    }

    // Getters and setters
}
