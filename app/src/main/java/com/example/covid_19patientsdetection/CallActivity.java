package com.example.covid_19patientsdetection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;

public class CallActivity extends Activity {
    ImageButton backButton;
    ImageButton finishButton;

    String nameStr;
    String phoneStr;
    String idStr;
    String addressStr;

    ImageView logoIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_layout);

        final EditText nameET;
        final EditText idET;
        final EditText phoneET;
        final EditText addressET;

        nameET = (EditText)findViewById(R.id.nameIn);
        idET = (EditText)findViewById(R.id.idIn);
        phoneET = (EditText)findViewById(R.id.phoneIn);
        addressET = (EditText)findViewById(R.id.addressIn);

        backButton = (ImageButton)findViewById(R.id.backBtn);
        finishButton = (ImageButton) findViewById(R.id.finishBtn);
        logoIV = (ImageView)findViewById(R.id.logo);

        if(Locale.getDefault().getLanguage().equals("iw"))
        {
            logoIV.setBackgroundResource(R.drawable.hebreportsympthoms);
            finishButton.setBackgroundResource(R.drawable.hebfinishbutton);
        }
        else {
            logoIV.setBackgroundResource(R.drawable.engreportsympthoms);
            finishButton.setBackgroundResource(R.drawable.finishbutton);
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CallActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameStr = nameET.getText().toString();
                phoneStr = phoneET.getText().toString();
                idStr = idET.getText().toString();
                addressStr = addressET.getText().toString();

                if (nameStr.matches("") || phoneStr.matches("") || idStr.matches("") || addressStr.matches(""))
                {
                    Toast.makeText(CallActivity.this, getResources().getString(R.string.errorStr), Toast.LENGTH_SHORT).show();
                }

                else
                {
                    //Toast.makeText(CallActivity.this, getResources().getString(R.string.messageFinishStr), Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(CallActivity.this, LastActivity.class);
                    intent.putExtra("address", addressStr);
                    startActivity(intent);
                }
            }
        });
    }
}