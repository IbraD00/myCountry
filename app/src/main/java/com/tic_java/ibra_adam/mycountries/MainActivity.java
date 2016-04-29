package com.tic_java.ibra_adam.mycountries;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    Country country = new Country();
    Country.CountryType[] response = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            if(networkAvailable()) {
                response = country.run();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (response != null) {
            String[] countryArray = new String[response.length];
            System.out.println(response.length);
            for (int i = 0; i < response.length; i++) {
                countryArray[i] = response[i].name;
                System.out.println(response[i].name);
            }
            System.out.println(response);
            ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_main,R.id.textView, countryArray);
            ListView listView = (ListView) findViewById(R.id.listView);

            if (listView != null) {
                listView.setAdapter(adapter);
                System.out.println("YES");
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
