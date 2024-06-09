package com.blerdU.rootworkapp.qol;

import java.util.List;

public class QoLAssessmentResult {

    private QoLUserProfile userProfile;
    private List<Suggestion> suggestions;

    // Constructor
    public QoLAssessmentResult(QoLUserProfile userProfile, List<Suggestion> suggestions) {
        this.userProfile = userProfile;
        this.suggestions = suggestions;
    }

    // Getter methods
    public QoLUserProfile getUserProfile() {
        return userProfile;
    }

    public List<Suggestion> getSuggestions() {
        return suggestions;
    }
}
