package com.blerdU.rootworkapp;

import java.util.ArrayList;
import java.util.List;

public class SubstanceAbuseSuggestionEngine extends SuggestionEngine {

    @Override
    public List<String> generateSuggestions(QoLUserProfile userProfile) {
        List<String> suggestions = new ArrayList<>();
        
        // Check if the user has substance abuse listed as a challenge
        if (userProfile.getChallenges().contains("substance abuse")) {
            suggestions.add("Seek professional counseling or therapy for substance abuse.");
            suggestions.add("Join support groups like Alcoholics Anonymous or Narcotics Anonymous.");
            suggestions.add("Look into inpatient or outpatient rehabilitation programs.");
            suggestions.add("Reach out to local community services for support and resources.");
            suggestions.add("Develop a healthy routine to replace substance use with positive activities.");
            suggestions.add("Stay connected with supportive family and friends.");
        }

        return suggestions;
    }
}
