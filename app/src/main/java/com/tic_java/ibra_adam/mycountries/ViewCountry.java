package com.tic_java.ibra_adam.mycountries;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewCountry extends AppCompatActivity {
    TextView textView;
    TextView textViewPopulation;
    TextView textViewCapital;
    TextView textViewRegion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_country);
        textView = (TextView) findViewById(R.id.viewCountryTextView);
        textViewRegion = (TextView) findViewById(R.id.viewCountryTextViewRegion);
        textViewPopulation = (TextView) findViewById(R.id.viewCountryTextViewPopulation);
        textViewCapital= (TextView) findViewById(R.id.viewCountryTextViewCapital);

        Intent intent = getIntent();
        String countryName = intent.getStringExtra("countryName");
        String countryRegion = intent.getStringExtra("countryRegion");
        String countryCapital = intent.getStringExtra("countryCapital");
        String countryPopulation = intent.getStringExtra("countryPopulation");

        textView.setText("Pays:" + countryName);
        textViewRegion.setText("Continent: " + countryRegion);
        textViewPopulation.setText("Population: " + countryPopulation + " inhabitants");
        textViewCapital.setText("Capital: " + countryCapital);

    }
}
