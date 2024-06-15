package com.blerdU.rootworkapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QoLProgressTracker {
    private Map<String, List<ProgressUpdate>> userProgressUpdates;
    private Map<String, List<Resource>> userRecommendations;

    // Constructor to initialize the maps
    public QoLProgressTracker() {
        userProgressUpdates = new HashMap<>();
        userRecommendations = new HashMap<>();
    }

    // Add a progress update for a specific user
    public void addProgressUpdate(String userId, ProgressUpdate update) {
        if (!userProgressUpdates.containsKey(userId)) {
            userProgressUpdates.put(userId, new ArrayList<>());
        }
        userProgressUpdates.get(userId).add(update);
        adjustRecommendations(userId);
    }

    // Retrieve all progress updates for a specific user
    public List<ProgressUpdate> getProgressUpdates(String userId) {
        return userProgressUpdates.getOrDefault(userId, new ArrayList<>());
    }

    // Adjust recommendations for a specific user based on their progress updates
    public void adjustRecommendations(String userId) {
        List<ProgressUpdate> updates = userProgressUpdates.get(userId);
        List<Resource> updatedResources = new ArrayList<>();

        // Logic to adjust recommendations based on progress updates
        // For simplicity, let's say we re-evaluate the user's needs and find resources again
        for (ProgressUpdate update : updates) {
            // Placeholder logic for adjusting recommendations
            // This should be customized based on real adjustment criteria
            if (update.getDescription().toLowerCase().contains("job")) {
                updatedResources.add(new Resource("res2", "Job Training Program", "Service", "Offers vocational training for job seekers."));
            }
            if (update.getDescription().toLowerCase().contains("income")) {
                updatedResources.add(new Resource("res1", "Local Food Bank", "Service", "Provides free meals to those in need."));
            }
        }

        userRecommendations.put(userId, updatedResources);
    }

    // Retrieve adjusted recommendations for a specific user
    public List<Resource> getRecommendations(String userId) {
        return userRecommendations.getOrDefault(userId, new ArrayList<>());
    }
}
