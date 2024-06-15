package com.blerdU.rootworkapp;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class SurveyManager {
    private Map<String, Survey> surveys;
    private Map<String, List<SurveyResponse>> surveyResponses;

    public SurveyManager() {
        surveys = new HashMap<>();
        surveyResponses = new HashMap<>();
    }

    // Create a new survey and add it to the collection
    public void createSurvey(String surveyId, String title, List<String> questions) {
        Survey newSurvey = new Survey(surveyId, title, questions);
        surveys.put(surveyId, newSurvey);
    }

    // Retrieve a survey by its ID
    public Survey getSurvey(String surveyId) {
        return surveys.get(surveyId);
    }

    // Store responses for a specific survey
    public void storeResponses(String surveyId, List<String> responses) {
        SurveyResponse surveyResponse = new SurveyResponse(surveyId, responses);
        if (!surveyResponses.containsKey(surveyId)) {
            surveyResponses.put(surveyId, new ArrayList<>());
        }
        surveyResponses.get(surveyId).add(surveyResponse);
    }

    // Get all responses for a specific survey
    public List<SurveyResponse> getSurveyResponses(String surveyId) {
        return surveyResponses.get(surveyId);
    }

    // Inner class representing a survey
    public class Survey {
        private String surveyId;
        private String title;
        private List<String> questions;

        public Survey(String surveyId, String title, List<String> questions) {
            this.surveyId = surveyId;
            this.title = title;
            this.questions = questions;
        }

        // Getters and Setters
        public String getSurveyId() {
            return surveyId;
        }

        public void setSurveyId(String surveyId) {
            this.surveyId = surveyId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getQuestions() {
            return questions;
        }

        public void setQuestions(List<String> questions) {
            this.questions = questions;
        }
    }

    // Inner class representing a survey response
    public class SurveyResponse {
        private String surveyId;
        private List<String> responses;

        public SurveyResponse(String surveyId, List<String> responses) {
            this.surveyId = surveyId;
            this.responses = responses;
        }

        // Getters and Setters
        public String getSurveyId() {
            return surveyId;
        }

        public void setSurveyId(String surveyId) {
            this.surveyId = surveyId;
        }

        public List<String> getResponses() {
            return responses;
        }

        public void setResponses(List<String> responses) {
            this.responses = responses;
        }
    }
}
