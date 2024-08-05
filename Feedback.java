package com.blerdU.rootworkapp;

public class Feedback {
    private String id;
    private String expertId;
    private String content;
    private String status;

    public Feedback() {
        // Default constructor
    }

    public Feedback(String id, String expertId, String content) {
        this.id = id;
        this.expertId = expertId;
        this.content = content;
        this.status = "Pending";
    }

    // Getters and setters
}
