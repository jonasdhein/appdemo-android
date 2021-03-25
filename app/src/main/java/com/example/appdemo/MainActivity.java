package com.example.appdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView lblTitulo;
    Button btnBotao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //arquivo XML do layout da tela

        //vínculos dos componentes com os componentes do XML
        lblTitulo = findViewById(R.id.lblTitulo);
        btnBotao = findViewById(R.id.btnBotao);

        btnBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblTitulo.setText("Olá Mundo!!!");
            }
        });


    }
}