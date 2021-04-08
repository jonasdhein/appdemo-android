package com.example.appdemo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appdemo.R;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText txtUsuario, txtSenha;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Cria o objeto sharedPreferences para utilização
        SharedPreferences sharedPreferences =
                getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);

        btnLogin = findViewById(R.id.btnLogin_usuario);
        txtUsuario = findViewById(R.id.txtLogin_usuario);
        txtSenha = findViewById(R.id.txtSenha_usuario);

        context = LoginActivity.this;

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    //abrir a tela de menu se o login estiver correto
                    if(txtUsuario.getText().toString().equals("jonas") &&
                            txtSenha.getText().toString().equals("abc123")){

                        /*Se acertar os dados de acesso, salva eles no SharedPreferences para não
                        pedir login novamente */
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("usuario", txtUsuario.getText().toString());
                        editor.putBoolean("logado", true);
                        editor.putString("chavePix", "01245669800");
                        if(editor.commit()){
                            Intent tela = new Intent(context, MenuActivity.class);
                            startActivity(tela);
                            finish();
                        }else{
                            Toast.makeText(context, "Ops, algo de errado não está certo...", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(context, "Dados inválidos", Toast.LENGTH_SHORT).show();
                    }

                }catch (Exception ex){
                    Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });

        //verifica se existe um valor para a chave "usuario" no sharedPreferences
        String nome_usuario = sharedPreferences.getString("usuario", "");
        if(!nome_usuario.equals("")){
            Intent tela = new Intent(context, MenuActivity.class);
            startActivity(tela);
            finish();
        }

    }
}