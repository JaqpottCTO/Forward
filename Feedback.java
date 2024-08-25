package com.evertisky.rootworkv1;

public class Feedback {
    private String id;
    private String expertId;
    private String content;
    private String status;

    // Default constructor (required for Firebase or ORM libraries)
    public Feedback() {
    }

    // Constructor to initialize Feedback object
    public Feedback(String id, String expertId, String content) {
        this.id = id;
        this.expertId = expertId;
        this.content = content;
        this.status = "Pending"; // Default status is "Pending"
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExpertId() {
        return expertId;
    }

    public void setExpertId(String expertId) {
        this.expertId = expertId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
