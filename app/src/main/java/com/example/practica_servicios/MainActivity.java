package com.example.practica_servicios;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.telephony.SmsManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ediURL, ediPhone, ediSMSPhone, ediSMS;
    Button btnlink, btnLlamar, btnSMS, salir;



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

        salir = (Button) findViewById(R.id.btncancelar);


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

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Bloque que se ejecuta
                Toast.makeText(getApplicationContext(), "By Ibrahin Canto Almeida\n" + "Curso de Titulación Lic. en Informatica", Toast.LENGTH_LONG).show();
                Log.i("ERROR1", "Diste click en salir");
                finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });


    }
}