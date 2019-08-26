package com.ejrgeek.userapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "RegisterActivity";

    @BindView(R.id.edit_text_new_user)
    protected EditText etNewUser;

    @BindView(R.id.edit_text_new_pass)
    protected EditText etNewPass;

    @BindView(R.id.button_register)
    protected Button btRegister;

    private boolean verifyUser(final String etUser){
        if (etUser.isEmpty()){
            Toast.makeText(RegisterActivity.this, "Usuário vazio!", Toast.LENGTH_SHORT).show();
            return false;
        }else if (etUser.length() < 3){
            Toast.makeText(RegisterActivity.this, "Nome de Usuário precisa ter mais que 3 caracteres!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean verifyPass(final String etPass){
        if (etPass.isEmpty()){
            Toast.makeText(RegisterActivity.this, "Senha vazia!", Toast.LENGTH_SHORT).show();
            return false;
        }else if (etPass.length() < 8){
            Toast.makeText(RegisterActivity.this, "A Senha precisa conter 8 ou mais caracteres!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void register(){
        final String user = etNewUser.getText().toString();
        final String pass = etNewPass.getText().toString();
        if (verifyUser(user) && verifyPass(pass)){
            SharedPreferences sharedPreferences = getSharedPreferences("userData", MODE_PRIVATE);
            SharedPreferences.Editor editorSEditor = sharedPreferences.edit();
            editorSEditor.putString("username", user);
            editorSEditor.putString("password", pass);
            editorSEditor.apply();

            String savedUser = sharedPreferences.getString("username", "");

            Toast.makeText(RegisterActivity.this, savedUser + " registrado!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(RegisterActivity.this, "Usuário não registrado!", Toast.LENGTH_SHORT).show();
        }
    }
    

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);

        btRegister.setOnClickListener(view -> {
            register();
        });

    }




}
