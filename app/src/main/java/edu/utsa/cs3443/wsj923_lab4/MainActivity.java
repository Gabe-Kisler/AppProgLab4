package edu.utsa.cs3443.wsj923_lab4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import android.view.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button windriderButton = findViewById(R.id.windrider);
        Button stormchaserButton = findViewById(R.id.stormchaser);
        Button skybreakerButton = findViewById(R.id.skybreaker);
        Button thunderhawkButton = findViewById(R.id.thunderhawk);


        windriderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity("Windrider DR-512");
            }
        });

        stormchaserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity("Stormchaser ST-743");
            }
        });

        skybreakerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                launchActivity("Skybreaker SK-301");
            }
        });

        thunderhawkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                launchActivity("Thunderhawk TH-104");
            }
        });
    }

    public void launchActivity(String registry) {
        Intent intent = new Intent(this, AirshipActivity.class);
        intent.putExtra("registry", registry);
        startActivity(intent);
    }

}