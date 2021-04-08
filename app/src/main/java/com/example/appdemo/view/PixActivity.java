package com.example.appdemo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.appdemo.R;
import com.example.appdemo.model.Pix;

import java.nio.file.Files;

public class PixActivity extends AppCompatActivity {

    Button btnPagar, btnReceber;
    EditText txtValor;
    TextView lblChave, lblSaldo;
    Pix contaPix;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pix);

        sharedPreferences =
                getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);

        contaPix = new Pix();
        contaPix.setChave(sharedPreferences.getString("chavePix", ""));
        float saldo = sharedPreferences.getFloat("valor", 0);
        contaPix.setSaldo(saldo);
        contaPix.setCheque_especial(500);

        //vincular objetos da tela
        txtValor = findViewById(R.id.txtValor_pix);
        btnPagar = findViewById(R.id.btnPagar_pix);
        btnReceber = findViewById(R.id.btnReceber_pix);
        lblChave = findViewById(R.id.lblChave_pix);
        lblSaldo = findViewById(R.id.lblSaldo_pix);

        //Funcionalidade de pagar, até o saldo negativo ficar no limite do cheque especial
        //Receber é ilimitado

        btnPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pagar um valor

                float valor = Float.parseFloat(txtValor.getText().toString());
                float saldo = contaPix.getSaldo() - valor;
                contaPix.setSaldo(saldo);

                atualizarDados();
            }
        });

        atualizarDados();

    }

    private void atualizarDados(){
        try{

            lblSaldo.setText(String.valueOf(contaPix.getSaldo()));
            lblChave.setText(contaPix.getChave());
            txtValor.setText("");

        }catch (Exception ex){

        }
    }
}