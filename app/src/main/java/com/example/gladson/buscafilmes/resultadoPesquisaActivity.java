package com.example.gladson.buscafilmes;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class resultadoPesquisaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_pesquisa);
        //Captura o valor da intent
        Intent intent = getIntent();
        //Atribui o valor da intent a uma variavel
        final String nomeFilmePesquisa = intent.getStringExtra(MainActivity.FILME);
        //Quando tiver o caractere espaço subtitui pelo sinal +
        String resultadoFormatado = nomeFilmePesquisa.replace(" ", "+");
        //Cria um elemento para mostra o resultado
        final TextView textView = new TextView(this);
        textView.setTextSize(12);

        //Inicializando a requisição
        RequestQueue request = Volley.newRequestQueue(this);
        //String formando a URL de pesquisa
        String url = "http://www.omdbapi.com/?apikey=ea23cea2&t=" + resultadoFormatado;

        //Requisição Volley do tipo JsonObject
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response){
                        //Tratamento para manipular o resultado
                        try{
                            //Pego o resultado e pego o valor da chave especificado em getString
                            String resposta = "Titulo: " + response.getString("Title");
                            //Montando resposta com as informações obitidas
                            resposta = resposta + "\nAno: " + response.get("Year");
                            resposta = resposta + "\nLançamento: " + response.getString("Released");
                            resposta = resposta + "\nRank: " + response.getString("Rated");
                            resposta = resposta + "\nGênero: " + response.getString("Genre");
                            resposta = resposta + "\nDiretor: " + response.getString("Director");
                            resposta = resposta + "\nEscritor: " + response.getString("Writer");
                            resposta = resposta + "\nAtores: " + response.getString("Actors");
                            resposta = resposta + "\nLinguagem: " + response.getString("Language");
                            resposta = resposta + "\nPaís de Orirgem: " + response.getString("Country");


                            //Atribui o resultado para o TextView
                            textView.setText(resposta);

                        }catch (JSONException EX){
                            //Tratamento de erros caso não consiga achar o objeto especificado na hora pegar o objeto
                            textView.setText(EX.getMessage());
                        }

                    }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                //Tratamento de erros caso não encontre resposta
                textView.setText(error.getMessage());
            }
        });
        request.add(jsonObjectRequest);
        //Adiciona o elemento a um layout
        ViewGroup layout = (ViewGroup) findViewById(R.id.mostrarResultado);
        layout.addView(textView);
    }
}
