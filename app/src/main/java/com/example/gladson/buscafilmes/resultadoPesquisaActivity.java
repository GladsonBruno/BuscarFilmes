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
                //Tentando criar a URL
                try{
                    URL OMDb = new URL(url);
                    //Tentando abrir conexão
                    try{
                        HttpsURLConnection minhaConexao = (HttpsURLConnection) OMDb.openConnection();
                        //Identificando a aplicaçao na requisição
                        minhaConexao.setRequestProperty("User-Agent", "BuscaFilmes");

                        if(minhaConexao.getResponseCode() == 200){

                            textView.setText("ok");
                        }else{
                            textView.setText(minhaConexao.getResponseCode());
                        }


                    }catch (IOException ex){
                        //Tratamento de excessão
                        textView.setText(ex.getMessage().toString());
                    }
                }catch(MalformedURLException ex){
                    //Tratamento de excessão por erro de url
                    textView.setText(ex.getMessage().toString());
                }

            }
        });
        //Adiciona o elemento a um layout
        ViewGroup layout = (ViewGroup) findViewById(R.id.mostrarResultado);
        layout.addView(textView);
    }
}
