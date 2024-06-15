package com.blerdU.rootworkapp;

import java.util.ArrayList;
import java.util.List;

public class BehaviorDisorderSuggestionEngine extends SuggestionEngine {

    @Override
    public List<String> generateSuggestions(QoLUserProfile userProfile) {
        List<String> suggestions = new ArrayList<>();
        
        // Check if the user has behavior disorders listed as a challenge
        if (userProfile.getChallenges().contains("behavior disorders")) {
            suggestions.add("Consult with a mental health professional for diagnosis and treatment.");
            suggestions.add("Participate in cognitive-behavioral therapy (CBT) sessions.");
            suggestions.add("Join support groups for individuals with similar behavior disorders.");
            suggestions.add("Explore medication options with a healthcare provider if necessary.");
            suggestions.add("Develop healthy routines and coping strategies.");
            suggestions.add("Engage in mindfulness and stress-relief activities such as yoga or meditation.");
            suggestions.add("Stay connected with supportive family and friends.");
        }

        return suggestions;
    }
}
