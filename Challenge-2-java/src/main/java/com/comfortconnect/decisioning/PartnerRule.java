package com.comfortconnect.decisioning;

import java.util.List;

/**
 * Configuration for a lending partner's eligibility and pricing rules.
 */
public class PartnerRule {

    private String partnerId;
    private String partnerName;
    private int minCreditScore;
    private double maxLoanAmount;
    private List<String> supportedEquipment;
    private List<String> excludedStates;
    private double baseApr;
    private int defaultTermMonths;
    private String promoLabel;

    public PartnerRule() {}

    public PartnerRule(String partnerId, String partnerName, int minCreditScore, double maxLoanAmount,
                       List<String> supportedEquipment, List<String> excludedStates,
                       double baseApr, int defaultTermMonths, String promoLabel) {
        this.partnerId = partnerId;
        this.partnerName = partnerName;
        this.minCreditScore = minCreditScore;
        this.maxLoanAmount = maxLoanAmount;
        this.supportedEquipment = supportedEquipment;
        this.excludedStates = excludedStates;
        this.baseApr = baseApr;
        this.defaultTermMonths = defaultTermMonths;
        this.promoLabel = promoLabel;
    }

    public String getPartnerId() { return partnerId; }
    public void setPartnerId(String partnerId) { this.partnerId = partnerId; }

    public String getPartnerName() { return partnerName; }
    public void setPartnerName(String partnerName) { this.partnerName = partnerName; }

    public int getMinCreditScore() { return minCreditScore; }
    public void setMinCreditScore(int minCreditScore) { this.minCreditScore = minCreditScore; }

    public double getMaxLoanAmount() { return maxLoanAmount; }
    public void setMaxLoanAmount(double maxLoanAmount) { this.maxLoanAmount = maxLoanAmount; }

    public List<String> getSupportedEquipment() { return supportedEquipment; }
    public void setSupportedEquipment(List<String> supportedEquipment) { this.supportedEquipment = supportedEquipment; }

    public List<String> getExcludedStates() { return excludedStates; }
    public void setExcludedStates(List<String> excludedStates) { this.excludedStates = excludedStates; }

    public double getBaseApr() { return baseApr; }
    public void setBaseApr(double baseApr) { this.baseApr = baseApr; }

    public int getDefaultTermMonths() { return defaultTermMonths; }
    public void setDefaultTermMonths(int defaultTermMonths) { this.defaultTermMonths = defaultTermMonths; }

    public String getPromoLabel() { return promoLabel; }
    public void setPromoLabel(String promoLabel) { this.promoLabel = promoLabel; }
}
