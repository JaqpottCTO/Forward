package com.blerdU.rootworkapp;

public class Resource {
    private String resourceId;
    private String resourceName;
    private String resourceType;
    private String description;

    // Constructor
    public Resource(String resourceId, String resourceName, String resourceType, String description) {
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.resourceType = resourceType;
        this.description = description;
    }

    // Getter for resourceId
    public String getResourceId() {
        return resourceId;
    }

    // Getter for resourceName
    public String getResourceName() {
        return resourceName;
    }

    // Getter for resourceType
    public String getResourceType() {
        return resourceType;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }
}
