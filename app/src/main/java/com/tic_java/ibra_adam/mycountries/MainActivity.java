package com.tic_java.ibra_adam.mycountries;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private TextView mainTxv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTxv = (TextView) findViewById(R.id.textView);

        Country country = new Country();
        Country.CountryType[] response = null;

        try {
            if(networkAvailable()) {
                response = country.run();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        String cities = null;

        if (response != null) {
            for (Country.CountryType item : response) {
                System.out.println(item.name);
                cities += item.name + " ";
            }
        }
        System.out.println(cities);
        mainTxv.setText(cities);
    }

    private boolean networkAvailable() {
        boolean network = false;
        ConnectivityManager manager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            network = true;
        }

        return network;
    }
}
