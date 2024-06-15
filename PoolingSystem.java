package com.blerdU.rootworkapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PoolingSystem {
    private double totalPool;
    private List<Member> members;
    private GamificationEngine gamificationEngine;

    public PoolingSystem() {
        this.members = new ArrayList<>();
        this.totalPool = 0;
        this.gamificationEngine = new GamificationEngine();
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void collectContributions() {
        for (Member member : members) {
            double contribution = member.getIncome() * 0.40;
            member.deductIncome(contribution);
            totalPool += contribution;
            gamificationEngine.awardPoolingParticipationPoints(member.getUserId(), 10); // Award points for contributing
        }
    }

    public Member distributeFunds() {
        List<Member> weightedMembers = new ArrayList<>();
        for (Member member : members) {
            int weight = member.getMeritLevel();
            for (int i = 0; i < weight; i++) {
                weightedMembers.add(member);
            }
        }

        Random random = new Random();
        Member winner = weightedMembers.get(random.nextInt(weightedMembers.size()));
        winner.addIncome(totalPool);
        gamificationEngine.awardPoolingWinnerBadge(winner.getUserId()); // Award badge to the winner
        totalPool = 0; // Reset the pool after distribution
        return winner;
    }

    public GamificationEngine getGamificationEngine() {
        return gamificationEngine;
    }
}
