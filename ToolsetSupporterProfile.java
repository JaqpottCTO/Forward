package com.blerdU.rootworkapp;

import java.util.List;

public class ToolsetSupporterProfile {
    private String name;
    private List<String> preferredCategories;
    private String preferredBusinessStatus; // Idea, Concept, Prototype, MVP, Go To Market
    private String preferredSupportLevel; // Quarterly, Monthly, Weekly, Daily
    private List<String> socialMediaLevels; // Mentor, Toolset, Business Plan, Operation, Development, Quality of Life

    // Constructors
    public ToolsetSupporterProfile(String name, List<String> preferredCategories, String preferredBusinessStatus, String preferredSupportLevel, List<String> socialMediaLevels) {
        this.name = name;
        this.preferredCategories = preferredCategories;
        this.preferredBusinessStatus = preferredBusinessStatus;
        this.preferredSupportLevel = preferredSupportLevel;
        this.socialMediaLevels = socialMediaLevels;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPreferredCategories() {
        return preferredCategories;
    }

    public void setPreferredCategories(List<String> preferredCategories) {
        this.preferredCategories = preferredCategories;
    }

    public String getPreferredBusinessStatus() {
        return preferredBusinessStatus;
    }

    public void setPreferredBusinessStatus(String preferredBusinessStatus) {
        this.preferredBusinessStatus = preferredBusinessStatus;
    }

    public String getPreferredSupportLevel() {
        return preferredSupportLevel;
    }

    public void setPreferredSupportLevel(String preferredSupportLevel) {
        this.preferredSupportLevel = preferredSupportLevel;
    }

    public List<String> getSocialMediaLevels() {
        return socialMediaLevels;
    }

    public void setSocialMediaLevels(List<String> socialMediaLevels) {
        this.socialMediaLevels = socialMediaLevels;
    }
}
