package com.comfortconnect.decisioning;

/**
 * Represents a homeowner's financing application.
 * TODO: Implement this data class with appropriate constructor, getters, and validation.
 */
public class Application {

    private String applicationId;
    private int creditScore;
    private double loanAmount;
    private String equipmentType;
    private String state;

    public Application() {}

    public Application(String applicationId, int creditScore, double loanAmount, String equipmentType, String state) {
        this.applicationId = applicationId;
        this.creditScore = creditScore;
        this.loanAmount = loanAmount;
        this.equipmentType = equipmentType;
        this.state = state;
    }

    public String getApplicationId() { return applicationId; }
    public void setApplicationId(String applicationId) { this.applicationId = applicationId; }

    public int getCreditScore() { return creditScore; }
    public void setCreditScore(int creditScore) { this.creditScore = creditScore; }

    public double getLoanAmount() { return loanAmount; }
    public void setLoanAmount(double loanAmount) { this.loanAmount = loanAmount; }

    public String getEquipmentType() { return equipmentType; }
    public void setEquipmentType(String equipmentType) { this.equipmentType = equipmentType; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
}
