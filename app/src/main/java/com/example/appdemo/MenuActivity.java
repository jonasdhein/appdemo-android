package com.example.appdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Button btnMain, btnCalculadora;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        context = MenuActivity.this;

        btnCalculadora = findViewById(R.id.btnCalculadora_menu);
        btnMain = findViewById(R.id.btnMain_menu);

        btnCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //através da tela atual, abre a tela da calculadora
                Intent tela = new Intent(context, CalculadoraActivity.class);
                startActivity(tela);
                //finish();//fecha a tela atual
            }
        });

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //através da tela atual, abre a tela do Main
                Intent tela = new Intent(context, MainActivity.class);
                startActivity(tela);
            }
        });
    }
}