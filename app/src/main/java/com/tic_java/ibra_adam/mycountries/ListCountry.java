package com.tic_java.ibra_adam.mycountries;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

public class ListCountry extends AppCompatActivity {

    ArrayAdapter adapter;
    Map<String, ArrayList<String>> response;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_country);

/*
        try {
            if(networkAvailable()) {
                Country country = new Country();
                response = country.run();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (response != null) {


        } else {
            System.out.println("BAD");
            System.out.println(response);
        }
        System.out.println("Yeeeeees");
        String[] continents = new String[5];
        continents[0] = "Asie";
        continents[1] = "Amerique";
        continents[2] = "Afrique";
        continents[3] = "Europe";
        continents[4] = "Océanie";

        adapter = new ArrayAdapter<String>(this, R.layout.activity_main,R.id.textView, continents);
        if (listView != null) {
            listView.setAdapter(adapter);
        }*/
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
