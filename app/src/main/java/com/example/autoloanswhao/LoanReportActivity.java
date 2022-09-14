package com.example.autoloanswhao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
        foundTotalAmount = findViewById(R.id.foundTotalLoan);
        foundMonthlyPayment = findViewById(R.id.foundMonthlyPayment);

    }


    public void goDataEntry(View view){
        finish();
    }
}