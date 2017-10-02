package com.example.gladson.buscafilmes;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;

public class resultadoPesquisaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_pesquisa);

        PesquisarFilme();
    }

    public void PesquisarFilme(){
        //Captura o valor da intent
        Intent intent = getIntent();
        //Atribui o valor da intent a uma variavel
        final String nomeFilmePesquisa = intent.getStringExtra(MainActivity.FILME);
        //Cria um elemento para mostra o resultado
        final TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(nomeFilmePesquisa);


        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                String url = "http://www.omdbapi.com/?t=" + nomeFilmePesquisa;

                try{
                    URL OMDb = new URL(url);
                    textView.setText("ok");
                }catch(MalformedURLException ex){
                    textView.setText(ex.getMessage().toString());
                }

            }
        });
        //Adiciona o elemento a um layout
        ViewGroup layout = (ViewGroup) findViewById(R.id.mostrarResultado);
        layout.addView(textView);
    }
}
