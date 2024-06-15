package com.blerdU.rootworkapp;

import java.util.ArrayList;
import java.util.List;

public class HomelessnessSuggestionEngine extends SuggestionEngine {

    @Override
    public List<String> generateSuggestions(QoLUserProfile userProfile) {
        List<String> suggestions = new ArrayList<>();
        
        // Check if the user has homelessness listed as a challenge
        if (userProfile.getChallenges().contains("homelessness")) {
            suggestions.add("Contact local shelters for immediate assistance.");
            suggestions.add("Apply for housing assistance programs.");
            suggestions.add("Reach out to community services for support.");
            suggestions.add("Explore transitional housing options.");
            suggestions.add("Look into job training programs that offer housing support.");
        }

        return suggestions;
    }
}
