package com.example.appdemo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.appdemo.R;

public class MenuActivity extends AppCompatActivity {

    Button btnMain, btnCalculadora, btnPix, btnLogout;
    TextView lblUsuario;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        SharedPreferences sharedPreferences =
                getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);

        context = MenuActivity.this;

        lblUsuario = findViewById(R.id.lblUsuario_menu);
        btnCalculadora = findViewById(R.id.btnCalculadora_menu);
        btnMain = findViewById(R.id.btnMain_menu);
        btnPix = findViewById(R.id.btnPix_menu);
        btnLogout = findViewById(R.id.btnLogout_menu);

        String nome_usuario = sharedPreferences.getString("usuario", "");
        lblUsuario.setText("Bem-vindo " + nome_usuario);

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

        btnPix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tela = new Intent(context, PixActivity.class);
                startActivity(tela);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    //ZERAR O SHAREDPREFENCES
                    sharedPreferences.edit().clear().commit();

                    Intent tela = new Intent(context, LoginActivity.class);
                    startActivity(tela);
                    finish();

                }catch (Exception ex){
                    Toast.makeText(context, "Erro", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}