package com.example.autoloanswhao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//https://www.cars.com/car-loan-calculator/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToLoanReport(View view){

        AutoLoan loan = new AutoLoan();



        Intent intent = new Intent(this, LoanReportActivity.class);
        startActivity(intent);
    }
}