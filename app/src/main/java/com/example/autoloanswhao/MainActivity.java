package com.example.autoloanswhao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

//https://www.cars.com/car-loan-calculator/
public class MainActivity extends AppCompatActivity {

    private TextInputEditText tilCarPrice;
    private TextInputEditText tilDownPayment;
    private TextInputEditText tilTradeInValue;
    private TextInputEditText tilAnnualPercentage;
    private TextInputEditText tilSalesTaxRate;

    private RadioGroup lengthOfLoanGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lengthOfLoanGroup = findViewById(R.id.lengthOfLoanGroup);

        tilCarPrice =  findViewById(R.id.tilCarPrice);
        tilDownPayment =  findViewById(R.id.tilDownPayment);
        tilTradeInValue =  findViewById(R.id.tilTradeInValue);
        tilAnnualPercentage =  findViewById(R.id.tilAnnualPercentageRate);
        tilSalesTaxRate =  findViewById(R.id.tilSalesTaxRate);
    }



    public void goToLoanReport(View view){

        int termId = lengthOfLoanGroup.getCheckedRadioButtonId();
        RadioButton termButton = findViewById(termId);
        try{
            double price = Double.valueOf(tilCarPrice.getText().toString());
            double downPayment = Double.valueOf(tilDownPayment.getText().toString());
            double tradeInValue = Double.valueOf(tilTradeInValue.getText().toString());
            int length = Integer.parseInt(termButton.getText().toString());
            double annualPercentage = Double.valueOf(tilAnnualPercentage.getText().toString());
            double salesTaxRate = Double.valueOf(tilSalesTaxRate.getText().toString());

            if((price > downPayment && price > tradeInValue) && price > downPayment + tradeInValue){

                AutoLoan loan = new AutoLoan(price, downPayment, tradeInValue, length, annualPercentage, salesTaxRate);
                Intent intent = new Intent(this, LoanReportActivity.class);
                intent.putExtra("loan0",loan);
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "You've Paid For Your Car", Toast.LENGTH_SHORT).show();
            }


        }
        catch (Exception e){
            Toast.makeText(this, "Invalid Entry. RE-ATTEMPT PLEASE", Toast.LENGTH_SHORT).show();
        }



    }
}