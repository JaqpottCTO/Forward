package com.blerdU.rootworkapp;

import java.util.ArrayList;
import java.util.List;

public class InadequateIncomeSuggestionEngine extends SuggestionEngine {

    @Override
    public List<String> generateSuggestions(QoLUserProfile userProfile) {
        List<String> suggestions = new ArrayList<>();
        
        // Check if the user has inadequate income listed as a challenge
        if (userProfile.getChallenges().contains("inadequate income")) {
            suggestions.add("Apply for government assistance programs such as SNAP or TANF.");
            suggestions.add("Look for local food banks and community assistance services.");
            suggestions.add("Seek part-time or freelance work to supplement your income.");
            suggestions.add("Explore job training programs to gain new skills and increase employability.");
            suggestions.add("Create a budget plan to manage expenses more effectively.");
            suggestions.add("Consult with a financial advisor for personalized advice.");
            suggestions.add("Look into educational grants and scholarships if you are a student.");
        }

        return suggestions;
    }
}
