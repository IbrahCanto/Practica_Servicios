package com.example.practica_servicios;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.telephony.SmsManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ediURL, ediPhone, ediSMSPhone, ediSMS;
    Button btnlink, btnLlamar, btnSMS;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnlink = (Button) findViewById(R.id.btnlink);
        ediURL = (EditText) findViewById(R.id.ediURL);

        btnLlamar = (Button) findViewById(R.id.btnLlamar);
        ediPhone = (EditText) findViewById(R.id.ediPhone);

        btnSMS = (Button) findViewById(R.id.btnSMS);
        ediSMSPhone = (EditText) findViewById(R.id.ediSMSPhone);
        ediSMS = (EditText) findViewById(R.id.ediSMS);


        btnlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + ediURL.getText().toString()));
                //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com.mx/search?q=" + ediURL.getText().toString()));
                //https://www.google.com.mx/search?q=
                startActivity(intent);
            }
        });


        btnLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:" + ediPhone.getText().toString()));
                startActivity(intent);
            }
        });


        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("smsto:" + ediSMSPhone.getText().toString()));
                intent.putExtra("sms_body", ediSMS.getText().toString());
                startActivity(intent);
            }
        });

    }
}