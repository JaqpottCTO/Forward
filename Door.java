package com.blerdU.rootworkapp;

import java.util.List;

public class Door {
    private String title;
    private String description;
    private List<Objective> objectives;
    private boolean isUnlocked;

    // Constructors, getters, and setters
    public Door(String title, String description, List<Objective> objectives, boolean isUnlocked) {
        this.title = title;
        this.description = description;
        this.objectives = objectives;
        this.isUnlocked = isUnlocked;
    }

    // Getters and setters
}
