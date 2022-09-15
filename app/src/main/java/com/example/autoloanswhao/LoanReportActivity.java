package com.example.autoloanswhao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class LoanReportActivity extends AppCompatActivity {

    private TextView foundCarPrice, foundDownPayment, foundTradeInValue, foundSalesTax;
    private TextView foundTotalLoan, foundTotalInterestPaid, foundTotalAmount, foundMonthlyPayment;
    // ^ only on a different line so no sideways scrolling

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_loan_report);

        foundCarPrice = findViewById(R.id.foundCarPrice);
        foundDownPayment = findViewById(R.id.foundDownPayment);
        foundTradeInValue = findViewById(R.id.foundTradeInValue);
        foundSalesTax = findViewById(R.id.foundSalesTax);
        foundTotalLoan = findViewById(R.id.foundTotalLoan);
        foundTotalInterestPaid = findViewById(R.id.foundTotalInterestPaid);
        foundTotalAmount = findViewById(R.id.foundTotalAmount);
        foundMonthlyPayment = findViewById(R.id.foundMonthlyPayment);

        getSupportActionBar().setTitle("Loan Report");

        Intent intent = getIntent();
        AutoLoan loan = intent.getParcelableExtra("loan0");

        foundCarPrice.setText(String.format(Locale.US, "$%.2f", loan.getPrice()));
        foundDownPayment.setText(String.format(Locale.US, "$%.2f", loan.getDownPayment()));
        foundTradeInValue.setText(String.format(Locale.US, "$%.2f", loan.getTradeInValue()));
        foundSalesTax.setText(String.format(Locale.US, "%%%.2f", loan.getSalesTax()));
        foundTotalLoan.setText(String.format(Locale.US, "$%.2f", loan.getTotalLoan()));
        foundTotalInterestPaid.setText(String.format(Locale.US, "$%.2f", loan.getTotalInterest()));
        foundTotalAmount.setText(String.format(Locale.US, "$%.2f", loan.getTotalAmount()));
        foundMonthlyPayment.setText(String.format(Locale.US, "$%.2f", loan.getMonthPayment()));

    }


    public void goDataEntry(View view){
        finish();
    }
}