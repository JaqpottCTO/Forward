package com.blerdU.rootworkapp;

import java.util.ArrayList;
import java.util.List;

public class PsychologicalDisorderSuggestionEngine extends SuggestionEngine {

    @Override
    public List<String> generateSuggestions(QoLUserProfile userProfile) {
        List<String> suggestions = new ArrayList<>();
        
        // Check if the user has psychological disorders listed as a challenge
        if (userProfile.getChallenges().contains("psychological disorders")) {
            suggestions.add("Seek professional counseling or therapy to manage your condition.");
            suggestions.add("Consider medication management with a licensed psychiatrist.");
            suggestions.add("Join support groups for individuals with similar psychological disorders.");
            suggestions.add("Practice mindfulness and relaxation techniques such as meditation and yoga.");
            suggestions.add("Develop a regular exercise routine to improve mental health.");
            suggestions.add("Maintain a healthy diet and ensure adequate sleep.");
            suggestions.add("Stay connected with supportive family and friends.");
        }

        return suggestions;
    }
}
