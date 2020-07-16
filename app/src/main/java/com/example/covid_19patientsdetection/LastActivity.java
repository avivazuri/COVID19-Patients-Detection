package com.example.covid_19patientsdetection;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Locale;

public class LastActivity extends Activity {
    ImageButton backButton;
    ImageButton finishButton;
    ImageButton callButton;
    ImageButton locationButton;
    String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.last_layout);

        address = getIntent().getStringExtra("address");
        backButton = (ImageButton) findViewById(R.id.backBtn);
        finishButton = (ImageButton) findViewById(R.id.finishBtn);
        callButton = (ImageButton) findViewById(R.id.callBtn);
        locationButton = (ImageButton) findViewById(R.id.locationBtn);

        if (Locale.getDefault().getLanguage().equals("iw")) {
            callButton.setBackgroundResource(R.drawable.hebbuttoncall);
            locationButton.setBackgroundResource(R.drawable.hebbuttonsendlocation);
            finishButton.setBackgroundResource(R.drawable.hebfinishbutton);
        } else {
            callButton.setBackgroundResource(R.drawable.buttoncall);
            locationButton.setBackgroundResource(R.drawable.buttonsendlocation);
            finishButton.setBackgroundResource(R.drawable.finishbutton);
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LastActivity.this, CallActivity.class);
                startActivity(intent);
            }
        });

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LastActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                String number = "101";
                intent.setData(Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });

        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?q=" + address));
                startActivity(intent);
            }
        });
    }
}
