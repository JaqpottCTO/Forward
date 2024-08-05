package com.blerdU.rootworkapp;

public class TrainingCenter {
    private String id;
    private String name;
    private String location;
    private List<TrainingProgram> trainingPrograms;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<TrainingProgram> getTrainingPrograms() {
        return trainingPrograms;
    }

    public void setTrainingPrograms(List<TrainingProgram> trainingPrograms) {
        this.trainingPrograms = trainingPrograms;
    }
}
