package com.tic_java.ibra_adam.mycountries;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {
    Button europe;
    Button africa;
    Button americas;
    Button asia;
    Button oceanie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        europe = (Button) findViewById(R.id.Europe);
        africa = (Button) findViewById(R.id.Africa);
        americas = (Button) findViewById(R.id.Americas);
        asia = (Button) findViewById(R.id.Asia);
        oceanie = (Button) findViewById(R.id.Oceania);

        europe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListCountry.class);
                intent.putExtra("region", "Europe");
                startActivity(intent);
            }
        });
    }

}
