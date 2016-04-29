package com.tic_java.ibra_adam.mycountries;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

public class ListCountry extends AppCompatActivity {

    ArrayAdapter adapter;
    Map<String, ArrayList<Country.CountryType>> response;
    ListView listView;
    String continent;
    Country country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_country);

        listView = (ListView) findViewById(R.id.listView);

        Intent intent = getIntent();
        continent = intent.getStringExtra("region");

        try {
            if(networkAvailable()) {
                country = new Country();
                response = country.run(continent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (response != null) {
            ArrayList<String> countryList  = new ArrayList<>();
            for (Country.CountryType item : response.get(continent)) {
                countryList.add(item.name + " - " + item.capital);
            }

            adapter = new ArrayAdapter<>(this, R.layout.activity_list_country,R.id.listCountryTextView, countryList);
            if (listView != null) {
                listView.setAdapter(adapter);
            }
        } else {
            System.out.println("ERROR ON GET REPONSE");
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ViewCountry.class);
                intent.putExtra("countryName", response.get(continent).get(position).name);
                intent.putExtra("countryRegion", response.get(continent).get(position).region);
                intent.putExtra("countryPopulation", response.get(continent).get(position).population);
                intent.putExtra("countryCapital", response.get(continent).get(position).capital);
                startActivity(intent);
            }
        });
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
