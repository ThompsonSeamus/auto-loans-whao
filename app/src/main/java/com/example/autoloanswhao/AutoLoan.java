package com.example.autoloanswhao;

public class AutoLoan {
    private Double price;
    private Double downPayment;
    private Double tradeInValue;
    private Integer numMonths;
    private Double ratePercent;
    private Double taxPercent;

    public AutoLoan(){
    }

    public AutoLoan(Double price, Double downPayment, Double tradeInValue, Integer numMonths, Double ratePercent, Double taxPercent) {
        this.price = price;
        this.downPayment = downPayment;
        this.tradeInValue = tradeInValue;
        this.numMonths = numMonths;
        this.ratePercent = ratePercent;
        this.taxPercent = taxPercent;
    }

    public Double getTotalLoan(){
        return price + getSalesTax() - downPayment - tradeInValue;
    }

    public Double getTotalInterest(){
        return getTotalAmount() - getTotalLoan();
    }

    public Double getTotalAmount(){
        return getMonthPayment() * numMonths;
    }

    public Double getMonthPayment(){
        double rate = 0.01 * ratePercent / 12;
        return getTotalLoan() * (rate * Math.pow(1 + rate, numMonths)/(Math.pow(1 + rate, numMonths)) - 1); //formula for car loan thing (I don't really understand it, but it works)
    }

    public Double getSalesTax(){
        return price * .01 * taxPercent;
    }

    public Double getPrice() {
        return price;
    }

    public Double getDownPayment() {
        return downPayment;
    }

    public Double getTradeInValue() {
        return tradeInValue;
    }

    public Integer getNumMonths() {
        return numMonths;
    }

    public Double getRatePercent() {
        return ratePercent;
    }

    public Double getTaxPercent() {
        return taxPercent;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDownPayment(Double downPayment) {
        this.downPayment = downPayment;
    }

    public void setTradeInValue(Double tradeInValue) {
        this.tradeInValue = tradeInValue;
    }

    public void setNumMonths(Integer numMonths) {
        this.numMonths = numMonths;
    }

    public void setRatePercent(Double ratePercent) {
        this.ratePercent = ratePercent;
    }

    public void setTaxPercent(Double taxPercent) {
        this.taxPercent = taxPercent;
    }
}
