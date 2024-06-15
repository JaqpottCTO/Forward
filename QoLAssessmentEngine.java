package com.blerdU.rootworkapp;

import java.util.List;

public class QoLAssessmentEngine {
    // Assessment logic
    public QoLAssessmentResult assessUser(QoLUserProfile userProfile) {
        // Calculate merit level based on user activities and achievements
        int newMeritLevel = calculateMeritLevel(userProfile);
        userProfile.setMeritLevel(newMeritLevel);

        // Generate suggestions based on profile and merit level
        List<Suggestion> suggestions = getSuggestionEngines().stream()
            .flatMap(engine -> engine.generateSuggestions(userProfile).stream())
            .collect(Collectors.toList());

        return new QoLAssessmentResult(userProfile, suggestions);
    }

    private int calculateMeritLevel(QoLUserProfile userProfile) {
        // Logic to calculate merit level
        return 3; // Placeholder value
    }

    public List<SuggestionEngine> getSuggestionEngines() {
        // Return a list of all suggestion engines
        return List.of(
            new HomelessnessSuggestionEngine(),
            new JoblessnessSuggestionEngine(),
            new SubstanceAbuseSuggestionEngine(),
            new BehaviorDisorderSuggestionEngine(),
            new InadequateIncomeSuggestionEngine(),
            new PsychologicalDisorderSuggestionEngine()
        );
    }
}
