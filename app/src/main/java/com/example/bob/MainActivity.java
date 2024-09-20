package com.example.bob;

import android.os.Bundle;


import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    TextView txtCount;
    //zmienna countera
    int licz = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //wczytywanie zmiennej po wznowieniu
        if (savedInstanceState != null) {
            licz = savedInstanceState.getInt("licz");
        }

        //counter
        txtCount = findViewById(R.id.textView);
        txtCount.setText("Kliknięto "+String.valueOf(licz)+" razy");

        //przycisk do wyłączania przycisku i zwiększania countera o 1
        Button buttonDisable = findViewById(R.id.buttonDisable);
        buttonDisable.setOnClickListener(v -> {
            buttonDisable.setEnabled(false);
            licz ++;
            txtCount.setText("Kliknięto "+String.valueOf(licz)+" razy");
            Toast.makeText(MainActivity.this, "Kliknięto przycisk",Toast.LENGTH_SHORT).show();
        });

        //przycisk do włączania przycisku wyżej
        Button buttonEnable = findViewById(R.id.buttonEnable);
        buttonEnable.setOnClickListener(v -> buttonDisable.setEnabled(true));


        //przycisk do resetowania licznika
        Button buttonReset = findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(v -> {
            licz = 0;
            txtCount.setText("Kliknięto "+String.valueOf(licz)+" razy");
        });


    }
    //zapisywanie kliknieć
    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("licz", licz);
    }


}