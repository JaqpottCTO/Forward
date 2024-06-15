package com.blerdU.rootworkapp;

import java.util.List;

public abstract class SuggestionEngine {

    // Abstract method to generate suggestions based on the user profile
    public abstract List<String> generateSuggestions(QoLUserProfile userProfile);
}
