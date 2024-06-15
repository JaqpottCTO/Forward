package com.blerdU.rootworkapp;

import java.util.ArrayList;
import java.util.List;

public class JoblessnessSuggestionEngine extends SuggestionEngine {

    @Override
    public List<String> generateSuggestions(QoLUserProfile userProfile) {
        List<String> suggestions = new ArrayList<>();
        
        // Check if the user has joblessness listed as a challenge
        if (userProfile.getChallenges().contains("joblessness")) {
            suggestions.add("Visit local job fairs to explore opportunities.");
            suggestions.add("Register with employment agencies for job placement assistance.");
            suggestions.add("Attend resume writing and interview skills workshops.");
            suggestions.add("Explore online job portals and apply to relevant positions.");
            suggestions.add("Look into vocational training programs to gain new skills.");
            suggestions.add("Network with professionals in your field through social media and local events.");
        }

        return suggestions;
    }
}
