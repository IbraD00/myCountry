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


public class MainActivity extends AppCompatActivity {
    Map<String, ArrayList<String>> response;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            if(networkAvailable()) {
                Country country = new Country();
                response = country.run();

            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        if (response != null) {
            System.out.println("Yeeeeees");
            String[] countryArray = new String[5];
            countryArray[0] = "Asie";
            countryArray[1] = "Amerique";
            countryArray[2] = "Afrique";
            countryArray[3] = "Europe";
            countryArray[4] = "Océanie";

            ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_main,R.id.textView, countryArray);
            ListView listView = (ListView) findViewById(R.id.listView);
            if (listView != null) {
                listView.setAdapter(adapter);
            }
        }else {
            System.out.println("BAD");
        }
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
