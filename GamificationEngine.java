package com.blerdU.rootworkapp;

import java.util.HashMap;
import java.util.Map;

public class GamificationEngine {
    private Map<String, Integer> userPoints;
    private Map<String, String> userBadges;
    private Map<String, Integer> leaderboard;

    public GamificationEngine() {
        userPoints = new HashMap<>();
        userBadges = new HashMap<>();
        leaderboard = new HashMap<>();
    }

    // Calculate points for a user based on their actions
    public void calculatePoints(String userId, int points) {
        if (!userPoints.containsKey(userId)) {
            userPoints.put(userId, 0);
        }
        userPoints.put(userId, userPoints.get(userId) + points);
        updateLeaderboard(userId);
    }

    // Award a badge to a user
    public void awardBadge(String userId, String badge) {
        userBadges.put(userId, badge);
    }

    // Update the leaderboard based on user points
    private void updateLeaderboard(String userId) {
        leaderboard.put(userId, userPoints.get(userId));
        // Additional logic to sort the leaderboard can be added here if needed
    }

    // Get points for a user
    public int getUserPoints(String userId) {
        return userPoints.getOrDefault(userId, 0);
    }

    // Get badge for a user
    public String getUserBadge(String userId) {
        return userBadges.getOrDefault(userId, "No Badge");
    }

    // Get the leaderboard
    public Map<String, Integer> getLeaderboard() {
        return leaderboard;
    }

    // Award points and badges related to the pooling mechanism
    public void awardPoolingParticipationPoints(String userId, int points) {
        calculatePoints(userId, points);
    }

    public void awardPoolingWinnerBadge(String userId) {
        awardBadge(userId, "Pooling Winner");
    }
}
