package com.blerdU.rootworkapp.qol;

import java.util.List;

public class QoLUserProfile {

    private String userId;
    private String name;
    private int age;
    private String gender;
    private String socioEconomicStatus;
    private List<String> challenges;

    // Constructor
    public QoLUserProfile(String userId, String name, int age, String gender, String socioEconomicStatus, List<String> challenges) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.socioEconomicStatus = socioEconomicStatus;
        this.challenges = challenges;
    }

    // Getter and Setter methods
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSocioEconomicStatus() {
        return socioEconomicStatus;
    }

    public void setSocioEconomicStatus(String socioEconomicStatus) {
        this.socioEconomicStatus = socioEconomicStatus;
    }

    public List<String> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<String> challenges) {
        this.challenges = challenges;
    }
}
