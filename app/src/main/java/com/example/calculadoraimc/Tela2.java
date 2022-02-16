package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class Tela2 extends AppCompatActivity {
    TextView nomeTextView;
    TextView imcTextView;
    TextView faixaEtariaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        nomeTextView = findViewById(R.id.nomeTextView);
        imcTextView = findViewById(R.id.imcTextView);
        faixaEtariaTextView = findViewById(R.id.faixaEtariaTextView);

        Intent intent = getIntent();

        if (intent != null) {
            Bundle params = intent.getExtras();
            if (params != null) {
                String nome = params.getString("nome");
                Double imc = params.getDouble("imc");
                String imcFormated = String.format("%.2f", imc);

                String faixaEtaria = params.getString("faixaEtaria");

                nomeTextView.setText(nome);
                faixaEtariaTextView.setText(faixaEtaria);
                imcTextView.setText(imcFormated);
            }
        }
    }


}