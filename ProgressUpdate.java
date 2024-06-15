package com.blerdU.rootworkapp;

import java.util.Date;

public class ProgressUpdate {
    private String userId;
    private String updateDescription;
    private Date updateDate;

    // Constructor
    public ProgressUpdate(String userId, String updateDescription, Date updateDate) {
        this.userId = userId;
        this.updateDescription = updateDescription;
        this.updateDate = updateDate;
    }

    // Getter for userId
    public String getUserId() {
        return userId;
    }

    // Getter for updateDescription
    public String getUpdateDescription() {
        return updateDescription;
    }

    // Getter for updateDate
    public Date getUpdateDate() {
        return updateDate;
    }
}
