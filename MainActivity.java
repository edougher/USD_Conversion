package com.example.aaron.usd_conversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity{
    double conversionRate = 1121.76;
    double amountEntered = 0.0;
    double amountConverted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText amount = (EditText) findViewById(R.id.txtAmount);
        final RadioButton usdToSkw = (RadioButton) findViewById(R.id.usToSkw);
        final RadioButton skwToUsd = (RadioButton) findViewById(R.id.skwToUsd);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        Button convert = (Button) findViewById(R.id.btnConvert);

        convert.setOnClickListener(View) {
            amountEntered = Double.parseDouble(amount.getText().toString());
            DecimalFormat tenth = new DecimalFormat("#.#");
            if (usdToSkw.isChecked()) {
                if (amountEntered <= 10000) {
                    amountConverted = amountEntered * conversionRate;
                    result.setText(tenth.format(amountConverted) + " South Korean Won");
                } else {
                    Toast.makeText(MainActivity.this, "Amount must be less than $10,000 USD",
                            Toast.LENGTH_LONG).show();
                }
            }
            if (skwToUsd.isChecked()) {
                if (amountEntered <= 11217600) {
                    amountConverted = amountEntered / conversionRate;
                    result.setText(tenth.format(amountConverted) + " US Dollars");
                } else {
                    Toast.makeText(MainActivity.this, "Amount must be less than 11217600 SKW",
                            Toast.LENGTH_LONG).show();
                }
            }

        }
    }
}
