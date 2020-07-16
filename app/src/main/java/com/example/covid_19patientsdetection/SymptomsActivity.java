package com.example.covid_19patientsdetection;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Locale;

public class SymptomsActivity extends Activity {
    ImageButton backButton;
    ImageView logoIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.symptoms_layout);

        backButton = (ImageButton)findViewById(R.id.backBtn);
        logoIV = (ImageView)findViewById(R.id.logo);

        if(Locale.getDefault().getLanguage().equals("iw"))
        {
            logoIV.setBackgroundResource(R.drawable.sympthomsheb);
        }
        else {
            logoIV.setBackgroundResource(R.drawable.sympthomseng);
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SymptomsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
