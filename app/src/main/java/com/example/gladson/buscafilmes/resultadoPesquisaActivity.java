package com.example.gladson.buscafilmes;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import static android.R.attr.start;

public class resultadoPesquisaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_pesquisa);
        //Captura o valor da intent
        Intent intent = getIntent();
        //Atribui o valor da intent a uma variavel
        final String nomeFilmePesquisa = intent.getStringExtra(MainActivity.FILME);
        //Cria um elemento para mostra o resultado
        final TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(nomeFilmePesquisa);


        //Adiciona o elemento a um layout
        ViewGroup layout = (ViewGroup) findViewById(R.id.mostrarResultado);
        layout.addView(textView);
    }
}
