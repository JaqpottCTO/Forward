package com.blerdU.rootworkapp;

public class Member {
    private String userId;
    private double income;
    private int meritLevel; // 1 to 5
    private MemberType memberType;

    public Member(String userId, double income, int meritLevel, MemberType memberType) {
        this.userId = userId;
        this.income = income;
        this.meritLevel = meritLevel;
        this.memberType = memberType;
    }

    public String getUserId() {
        return userId;
    }

    public double getIncome() {
        return income;
    }

    public int getMeritLevel() {
        return meritLevel;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void addIncome(double amount) {
        income += amount;
    }

    public void deductIncome(double amount) {
        income -= amount;
    }

    public void setMeritLevel(int meritLevel) {
        this.meritLevel = meritLevel;
    }
}
