package com.comfortconnect.decisioning;

/**
 * Represents a financing offer from a lending partner.
 * TODO: Implement this data class.
 */
public class Offer {

    private String partnerId;
    private String partnerName;
    private double apr;
    private int termMonths;
    private double monthlyPayment;
    private double totalCost;
    private String promoLabel;

    public Offer() {}

    public Offer(String partnerId, String partnerName, double apr, int termMonths,
                 double monthlyPayment, double totalCost, String promoLabel) {
        this.partnerId = partnerId;
        this.partnerName = partnerName;
        this.apr = apr;
        this.termMonths = termMonths;
        this.monthlyPayment = monthlyPayment;
        this.totalCost = totalCost;
        this.promoLabel = promoLabel;
    }

    public String getPartnerId() { return partnerId; }
    public void setPartnerId(String partnerId) { this.partnerId = partnerId; }

    public String getPartnerName() { return partnerName; }
    public void setPartnerName(String partnerName) { this.partnerName = partnerName; }

    public double getApr() { return apr; }
    public void setApr(double apr) { this.apr = apr; }

    public int getTermMonths() { return termMonths; }
    public void setTermMonths(int termMonths) { this.termMonths = termMonths; }

    public double getMonthlyPayment() { return monthlyPayment; }
    public void setMonthlyPayment(double monthlyPayment) { this.monthlyPayment = monthlyPayment; }

    public double getTotalCost() { return totalCost; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }

    public String getPromoLabel() { return promoLabel; }
    public void setPromoLabel(String promoLabel) { this.promoLabel = promoLabel; }
}
