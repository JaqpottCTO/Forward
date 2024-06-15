package com.blerdU.rootworkapp;

import java.util.ArrayList;
import java.util.List;

public class ResourceMatcher {

    private List<Resource> availableResources;

    // Constructor to initialize the list of available resources
    public ResourceMatcher(List<Resource> availableResources) {
        this.availableResources = availableResources;
    }

    // Method to match resources based on the user's assessment result
    public List<Resource> matchResources(QoLAssessmentResult assessmentResult) {
        List<Resource> matchedResources = new ArrayList<>();
        List<String> challenges = assessmentResult.getUserProfile().getChallenges();

        for (Resource resource : availableResources) {
            for (String challenge : challenges) {
                if (isResourceRelevant(resource, challenge)) {
                    matchedResources.add(resource);
                    break;
                }
            }
        }

        return matchedResources;
    }

    // Helper method to determine if a resource is relevant to a challenge
    private boolean isResourceRelevant(Resource resource, String challenge) {
        // Logic to determine if the resource is relevant to the challenge
        // This can be based on the resource type, description, or other attributes
        // Here, it's assumed that resource description contains keywords related to challenges
        return resource.getDescription().toLowerCase().contains(challenge.toLowerCase());
    }
}
