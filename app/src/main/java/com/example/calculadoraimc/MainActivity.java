package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText nomeText;
    EditText pesoText;
    EditText alturaText;
    Double imc = 0.0;
    String faixaEtaria = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcular(View view) {
        nomeText = findViewById(R.id.nomeText);
        pesoText = findViewById(R.id.pesoText);
        alturaText = findViewById(R.id.alturaText);

        Double peso = Double.parseDouble(pesoText.getText().toString());
        Double altura = Double.parseDouble(alturaText.getText().toString());


        imc = peso / (altura * 2);

        if (imc < 15 ) {
            faixaEtaria = "Extremamente abaixo do peso.";
        } else if (imc > 15 && imc < 16) {
            faixaEtaria = "Gravemente abaixo do peso.";
        } else if (imc > 16 && imc < 18.5) {
            faixaEtaria = "Abaixo do peso ideal.";
        } else if (imc > 18.5 && imc < 25) {
            faixaEtaria = "Faixa do peso ideal.";
        } else if (imc > 25 && imc < 30) {
            faixaEtaria = "Sobre peso.";
        } else if (imc > 30 && imc < 35) {
            faixaEtaria = "Obesidade grau 1.";
        } else if (imc > 35 && imc < 40) {
            faixaEtaria = "Obesidade grau 2(grave).";
        } else {
            faixaEtaria = "Obesidade grau 3(mórbida).";
        }


        Intent intent = new Intent(this, Tela2.class);

        Bundle params = new Bundle();

        params.putString("nome", nomeText.getText().toString());
        params.putDouble("imc", imc);
        params.putString("faixaEtaria", faixaEtaria);

        intent.putExtras(params);
        startActivity(intent);
    }
}