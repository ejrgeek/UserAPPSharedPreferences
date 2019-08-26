package com.ejrgeek.userapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import butterknife.ButterKnife;
import butterknife.BindView;

public class LoginActivity extends AppCompatActivity{

    @BindView(R.id.registerLink)
    protected TextView tRegister;

    @BindView(R.id.edit_text_user)
    protected EditText etUsername;

    @BindView(R.id.edit_text_pass)
    protected EditText etPassword;

    @BindView(R.id.button_login)
    protected Button btLogin;

    private void login(){
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("userData", MODE_PRIVATE);
        String savedUser = sharedPreferences.getString("username", "");
        String savedPass = sharedPreferences.getString("password", "");

        if (username.equals(savedUser) && password.equals(savedPass)){
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            intent.putExtra("user", savedUser);
            startActivity(intent);
        }else{
            Toast.makeText(LoginActivity.this, "Usuário e/ou Senha inválida(os)!", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        tRegister.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        btLogin.setOnClickListener(view -> login());

    }

}
