package com.example.autoloanswhao;

import android.os.Parcel;
import android.os.Parcelable;

public class AutoLoan implements Parcelable {
    private Double price;
    private Double downPayment;
    private Double tradeInValue;
    private Integer numMonths;
    private Double ratePercent;
    private Double taxPercent;

    public AutoLoan(){
        price = 0.0;
        downPayment = 0.0;
        tradeInValue = 0.0;
        numMonths = 36;
        ratePercent = 0.00;
        taxPercent = 0.00;
    }

    public AutoLoan(Double price, Double downPayment, Double tradeInValue, Integer numMonths, Double ratePercent, Double taxPercent) {
        this.price = price;
        this.downPayment = downPayment;
        this.tradeInValue = tradeInValue;
        this.numMonths = numMonths;
        this.ratePercent = ratePercent;
        this.taxPercent = taxPercent;
    }

    protected AutoLoan(Parcel in) {
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readDouble();
        }
        if (in.readByte() == 0) {
            downPayment = null;
        } else {
            downPayment = in.readDouble();
        }
        if (in.readByte() == 0) {
            tradeInValue = null;
        } else {
            tradeInValue = in.readDouble();
        }
        if (in.readByte() == 0) {
            numMonths = null;
        } else {
            numMonths = in.readInt();
        }
        if (in.readByte() == 0) {
            ratePercent = null;
        } else {
            ratePercent = in.readDouble();
        }
        if (in.readByte() == 0) {
            taxPercent = null;
        } else {
            taxPercent = in.readDouble();
        }
    }

    public static final Creator<AutoLoan> CREATOR = new Creator<AutoLoan>() {
        @Override
        public AutoLoan createFromParcel(Parcel in) {
            return new AutoLoan(in);
        }

        @Override
        public AutoLoan[] newArray(int size) {
            return new AutoLoan[size];
        }
    };

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
        return getTotalLoan() * (rate * Math.pow(1 + rate, numMonths))/(Math.pow(1 + rate, numMonths) - 1); //formula for car loan thing (I don't really understand it, but it works)
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (price == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(price);
        }
        if (downPayment == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(downPayment);
        }
        if (tradeInValue == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(tradeInValue);
        }
        if (numMonths == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(numMonths);
        }
        if (ratePercent == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(ratePercent);
        }
        if (taxPercent == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(taxPercent);
        }
    }
}
