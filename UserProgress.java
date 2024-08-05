package com.blerdU.rootworkapp;

public class UserProgress {
    private boolean isUnlocked;
    private Map<String, Boolean> completedObjectives;

    public UserProgress() {
        // Default constructor
    }

    public UserProgress(boolean isUnlocked, Map<String, Boolean> completedObjectives) {
        this.isUnlocked = isUnlocked;
        this.completedObjectives = completedObjectives;
    }

    // Getters and setters
}
