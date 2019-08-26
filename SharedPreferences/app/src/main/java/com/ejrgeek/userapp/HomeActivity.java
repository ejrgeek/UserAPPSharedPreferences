package com.ejrgeek.userapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.text_saudacao)
    protected TextView saudacao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        Intent intent = getIntent();

        String user = intent.getStringExtra("user");
        saudacao.setText(String.format("%s\n%s", saudacao.getText().toString(), user));

    }
}
