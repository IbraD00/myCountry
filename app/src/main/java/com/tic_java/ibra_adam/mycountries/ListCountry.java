package com.tic_java.ibra_adam.mycountries;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

public class ListCountry extends AppCompatActivity {

    ArrayAdapter adapter;
    ArrayList<String> response;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_country);

        listView = (ListView) findViewById(R.id.listView);

        Intent intent = getIntent();
        String continent = intent.getStringExtra("region");

        try {
            if(networkAvailable()) {
                Country country = new Country();
                response = country.run(continent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (response != null) {
            adapter = new ArrayAdapter<>(this, R.layout.activity_list_country,R.id.listCountryTextView, response);
            if (listView != null) {
                listView.setAdapter(adapter);
            }
        } else {
            System.out.println("ERROR ON GET REPONSE");
        }
    }

    private boolean networkAvailable()
    {
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
