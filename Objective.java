package com.blerdU.rootworkapp;

import java.util.Date;
import java.util.List;

public class Objective {
    private String objectiveId;
    private String title;
    private String description;
    private boolean isCompleted;
    private String doorId;
    private boolean isMandatory;
    private Date completionDate;
    private int rewardPoints;
    private List<String> resources;

    // Constructors, getters, and setters
    public Objective(String objectiveId, String title, String description, boolean isCompleted, String doorId,
                     boolean isMandatory, Date completionDate, int rewardPoints, List<String> resources) {
        this.objectiveId = objectiveId;
        this.title = title;
        this.description = description;
        this.isCompleted = isCompleted;
        this.doorId = doorId;
        this.isMandatory = isMandatory;
        this.completionDate = completionDate;
        this.rewardPoints = rewardPoints;
        this.resources = resources;
    }

    // Getters and setters
    public String getObjectiveId() {
        return objectiveId;
    }

    public void setObjectiveId(String objectiveId) {
        this.objectiveId = objectiveId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getDoorId() {
        return doorId;
    }

    public void setDoorId(String doorId) {
        this.doorId = doorId;
    }

    public boolean isMandatory() {
        return isMandatory;
    }

    public void setMandatory(boolean mandatory) {
        isMandatory = mandatory;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public List<String> getResources() {
        return resources;
    }

    public void setResources(List<String> resources) {
        this.resources = resources;
    }
}
